
package org.tensorflow.lite.examples.classification.indoormap;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import org.tensorflow.lite.examples.classification.ClassifierActivity;
import org.tensorflow.lite.examples.classification.R;
import org.tensorflow.lite.examples.classification.SpecialCase;
import org.tensorflow.lite.examples.classification.indoormap.aStar.Path;
import org.tensorflow.lite.examples.classification.logForm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.annotation.RequiresApi;

public class MainActivity extends AppCompatActivity

{

    MyView[] myViews;
    Button mOrder, submitButton, nearestItemButton,addToCartButton,itemReconButton,viewShoppingListButton,recipesReconButton;
    EditText rackIdVar,searchItemShop;
    GridLayout myGridLayout;
    boolean[] checkedItems;
    int itemlist;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    public static ArrayList<String> itemListAddCart = new ArrayList<>();
    FloorPlan rackPlan = new FloorPlan();
    String name;
    List<String> racklist = rackPlan.getRackPlan();
    List<String> itemListInRack = rackPlan.getItemList();
    String[] listItems = getRackListToArray(itemListInRack);
    public static ArrayList<String> itemListSearch;
    public static ArrayList<String> itemListSearchSpecialCase;
    public static ArrayList<String> remainItemListSearch;
    public static LinkedHashMap<String, String> viewSearchHashMap = new LinkedHashMap<String, String>();
    public static String nearestSearchRack;
    public static String userCurrentLocationRack;
    public static String message;
    public static String recommendation="";
    public static String recipesRecon="";
    ShoppinList shoppinListObj = new ShoppinList();

    // @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myGridLayout = findViewById(R.id.mygrid);
        mOrder = (Button) findViewById(R.id.btnOrder);
        nearestItemButton = (Button) findViewById(R.id.btnNearest);
        recipesReconButton = (Button) findViewById(R.id.btnRecipesRecon);
        viewShoppingListButton = (Button) findViewById(R.id.btnViewShoppingList);
        itemReconButton = (Button) findViewById(R.id.btnItemRecon);
        rackIdVar = (EditText) findViewById(R.id.rackId);

        submitButton = (Button) findViewById(R.id.submitButton);
        addToCartButton = (Button) findViewById(R.id.btnAddToCart);
        checkedItems = new boolean[listItems.length];
        getInitialview();
        checkItemAddInOnCreat();

        //System.out.print(LogForm.serverIpAddress);
        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                //TODO search in item list
                //searchItemShop =new EditText(MainActivity.this);
                //mBuilder.setView(searchItemShop);

                mBuilder.setMultiChoiceItems(listItems, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                        if (isChecked) {
                            //mUserItems.add(position);
                            ShoppinList.mShoppingItems.add(position);
                        } else {
                           // mUserItems.remove((Integer.valueOf(position)));
                            ShoppinList.mShoppingItems.remove((Integer.valueOf(position)));
                        }
                    }
                });

                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton(R.string.ok_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        itemListSearch = new ArrayList<>();
                        itemListSearchSpecialCase = new ArrayList<>();
                        String itemSendToSever="";
                        recommendation="";
                        recipesRecon="";
                    //    for (int i = 0; i < mUserItems.size(); i++) {
                            for (int i = 0; i < ShoppinList.mShoppingItems.size(); i++) {
                            //String itemInSearchList = listItems[mUserItems.get(i)];
                                String itemInSearchList = listItems[ShoppinList.mShoppingItems.get(i)];

                            //itemSendToSever = itemSendToSever + listItems[mUserItems.get(i)];
                                itemSendToSever = itemSendToSever + listItems[ShoppinList.mShoppingItems.get(i)];
                           // if (i != mUserItems.size() - 1) {
                                if (i != ShoppinList.mShoppingItems.size() - 1) {
                                itemSendToSever = itemSendToSever + ",";

                            }



                            String rackTakeByItem = rackPlan.getRackIdUsingItem(itemInSearchList);
                            // we can use viewsearchhashmap for view nearset item
                            viewSearchHashMap.put(itemInSearchList, rackTakeByItem);
                            // add the isuru'sirs comments
                            boolean ans=SpecialCase.specialCaseSearchItemList.contains(itemInSearchList);
                            if (ans){
                                if (!(itemListSearchSpecialCase.contains(rackTakeByItem))) {

                                    itemListSearchSpecialCase.add(rackTakeByItem);
                                }
                            }
                            else {
                                if (!(itemListSearch.contains(rackTakeByItem))) {

                                    itemListSearch.add(rackTakeByItem);
                                }
                            }
                        }


                        if (!itemListSearch.isEmpty()) {
                            String messageTosever="";
                            String chareter="#";
                            messageTosever=messageTosever+chareter;
                            messageTosever=messageTosever+ logForm.userId;
                            messageTosever=messageTosever+"#";
                            messageTosever=messageTosever+itemSendToSever;
                            MainActivity.message=messageTosever;

                           //send sendcode = new send();

                           //sendcode.execute();
                            checkAddItemAndCartItem();
                        }

                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;

                        }
                    }

                });

                mBuilder.setNegativeButton(R.string.dismiss_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        dialogInterface.dismiss();
                    }
                });

                mBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            checkedItems[i] = false;
                            //mUserItems.clear();
                            //########################

                            //ShoppinList.mShoppingItems.clear();
                            //itemListSearch = new ArrayList<>();
                            //viewSearchHashMap.clear();
                           // recommendation="";
                            //##################
                        }
                       // getInitialview();
                    }
                });

                //searchItemShop =new EditText(MainActivity.this);

                AlertDialog mDialog = mBuilder.create();
                mDialog.show();

            }

        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = rackIdVar.getText().toString();
                if(name.equals("start")){

                    name="02-02";
                }

                if (name.length() != 0) {
                    itemListAddCart.add(name);
                }
                if (!itemListAddCart.isEmpty()) {

                    checkAddItemAndCartItem();
                }


            }
        });



        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent activity2Intent = new Intent(getApplicationContext(), ClassifierActivity.class);
                startActivity(activity2Intent);

            }
        });


        nearestItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nearestItem =getnearestItem();
                AlertDialog.Builder mBuilder1 = new AlertDialog.Builder(MainActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();
                mBuilder1.setMessage(nearestItem);

                if(!nearestItem.equals("Current Remaining  Shopping list is empty")) {

                    mBuilder1.setPositiveButton(R.string.add_label, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {

                            AlertDialog.Builder mBuilder2 = new AlertDialog.Builder(MainActivity.this);


                            mBuilder2.setMessage( "Are you pick  "+nearestItem+ " ? ");
                            mBuilder2.setPositiveButton(R.string.yes_label, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    String lines[] = nearestItem.split("\\r?\\n");
                                    String itemRackNumber = rackPlan.getRackIdUsingItem(lines[0]);
                                    itemListAddCart.add(itemRackNumber);
                                    checkAddItemAndCartItem();

                                }

                            });

                            mBuilder2.setNegativeButton(R.string.no_label, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                    dialogInterface.dismiss();
                                }
                            });

                            AlertDialog mDialog2 = mBuilder2.create();
                            mDialog2.show();

                        }

                    });


                }
                AlertDialog mDialog1 = mBuilder1.create();
                mDialog1.show();
            }

        });

        viewShoppingListButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AlertDialog.Builder viewShoppingListBuilder = new AlertDialog.Builder(MainActivity.this);
                String ShoppingList =getMyShoppingList();
                viewShoppingListBuilder.setMessage(ShoppingList);
                viewShoppingListBuilder.setNeutralButton(R.string.clear_all_label, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                            ShoppinList.mShoppingItems.clear();
                            itemListSearch = new ArrayList<>();
                            viewSearchHashMap.clear();
                            recommendation="";
                            recipesRecon="";


                        getInitialview();
                    }
                });

                AlertDialog viewShoppingListDialog = viewShoppingListBuilder.create();
                viewShoppingListDialog.show();
            }

        });

        /*       selectProductDetails();

           public void selectProductDetails(){

            Intent intent = getIntent();
            String str = intent.getStringExtra("productName");
            productName.setText(str);
        }*/
        itemReconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();

                if(recommendation==null || recommendation.isEmpty()){

                    dialog.setMessage("No Item Recommendation");
                }
                else {
                    dialog.setMessage(recommendation);

                }
                dialog.show();
            }

        });

        recipesReconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                AlertDialog dialog = new AlertDialog.Builder(MainActivity.this).create();

                if(recipesRecon==null || recipesRecon.isEmpty()){

                    dialog.setMessage("No Item Recipes Recommend");
                }
                else {
                    dialog.setMessage(recipesRecon);

                }
                dialog.show();
            }

        });


    }
    public void checkItemAddInOnCreat(){

        if (!itemListAddCart.isEmpty()) {

            checkAddItemAndCartItem();
        }
    }
    public String getnearestItem(){


        List<String> listOfNearestItmes = getAllKeysForValue(viewSearchHashMap,nearestSearchRack );
        String nearestItem = "";
        if(listOfNearestItmes!=null){
            for (int i = 0; i < listOfNearestItmes.size(); i++) {

                nearestItem = nearestItem + listOfNearestItmes.get(i);

                if (i != listOfNearestItmes.size() - 1) {
                    nearestItem = nearestItem + "\n";

                }

            }
        }

        else
        {
            nearestItem= "Current Remaining  Shopping list is empty";
        }

        return nearestItem;
    }

    public String getMyShoppingList(){
        String myShoppingList="";
       if(ShoppinList.mShoppingItems.size()>0){


        for (int i = 0; i < ShoppinList.mShoppingItems.size(); i++) {

            myShoppingList = myShoppingList + listItems[ShoppinList.mShoppingItems.get(i)];

            if (i != ShoppinList.mShoppingItems.size() - 1) {
                myShoppingList = myShoppingList + "\n";

            }
        }
    }
       else {

           myShoppingList="No Item in your Shopping List";
       }
       return myShoppingList;
    }

    public void getview(List myList) {

        Path FloorPlan = new Path();
        myGridLayout.removeAllViews();
        int numOfCol = 50;
        int numOfRow = 20;
        myViews = new MyView[numOfCol * numOfRow];
        for (int yPos = 0; yPos < numOfRow; yPos++) {
            for (int xPos = 0; xPos < numOfCol; xPos++) {
                MyView tView = new MyView(this, xPos, yPos);
                myViews[yPos * numOfCol + xPos] = tView;


                String floorCheck = this.floorPlanCheck(yPos, xPos);
                if (floorCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.LTGRAY);

                }

                String cashierCheck = this.cashierCheck(yPos, xPos);
                if (cashierCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.DKGRAY);

                }
                String cartCheck = this.cartCheck(yPos, xPos);
                if (cartCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.GRAY);

                }

                String rackCheck = this.rackPlanCheck(yPos, xPos);
                if (rackCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.GREEN);

                }
                String pathCheck = this.pathCheck(yPos, xPos, myList);
                if (pathCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.YELLOW);
                    //manageBlinkEffect(yPos, numOfCol, xPos);


                }
                String searchRack = this.nearestRack(yPos, xPos);
                if (searchRack.equals("yes")) {

                    // tView.setBackgroundColor(Color.BLUE);
                    manageBlinkEffect(yPos, numOfCol, xPos);
                }

                String currentRack = this.currentLocationRack(yPos, xPos);
                if (currentRack.equals("yes")) {

                    tView.setBackgroundColor(Color.RED);

                    // manageBlinkEffect(yPos, numOfCol, xPos);
                }

                myGridLayout.addView(tView);
            }
        }

        myGridLayout.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {

                    // @RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
                    @Override
                    public void onGlobalLayout() {

                        final int MARGIN = 1;

                        int pWidth = myGridLayout.getWidth();
                        int pHeight = myGridLayout.getHeight();
                        int numOfCol = myGridLayout.getColumnCount();
                        int numOfRow = myGridLayout.getRowCount();
                        int w = pWidth / numOfCol;
                        int h = pHeight / numOfRow;
                        for (int yPos = 0; yPos < 20; yPos++) {
                            for (int xPos = 0; xPos < 50; xPos++) {
                                GridLayout.LayoutParams params =
                                        (GridLayout.LayoutParams) myViews[yPos * numOfCol + xPos].getLayoutParams();
                                params.width = w - 2 * MARGIN;
                                params.height = h - 2 * MARGIN;

                                params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
                                myViews[yPos * numOfCol + xPos].setLayoutParams(params);
                            }
                        }

                    }
                });
    }


    public void getInitialview() {
        int numOfCol = 50;
        int numOfRow = 20;
        myGridLayout.removeAllViews();
        myViews = new MyView[numOfCol * numOfRow];
        for (int yPos = 0; yPos < numOfRow; yPos++) {
            for (int xPos = 0; xPos < numOfCol; xPos++) {
                MyView tView = new MyView(this, xPos, yPos);
                myViews[yPos * numOfCol + xPos] = tView;


                String floorCheck = this.floorPlanCheck(yPos, xPos);
                if (floorCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.LTGRAY);

                }
                String cashierCheck = this.cashierCheck(yPos, xPos);
                if (cashierCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.DKGRAY);

                }


                String cartCheck = this.cartCheck(yPos, xPos);
                if (cartCheck.equals("yes")) {
                    tView.setBackgroundColor(Color.GRAY);

                }

                String rackCheck = this.rackPlanCheck(yPos, xPos);
                if (rackCheck.equals("yes")) {

                    tView.setBackgroundColor(Color.GREEN);

                }
                myGridLayout.addView(tView);
            }


            myGridLayout.getViewTreeObserver().addOnGlobalLayoutListener(
                    new ViewTreeObserver.OnGlobalLayoutListener() {

                        //@RequiresApi(api = Build.VERSION_CODES.ICE_CREAM_SANDWICH)
                        @Override
                        public void onGlobalLayout() {

                            final int MARGIN = 1;

                            int pWidth = myGridLayout.getWidth();
                            int pHeight = myGridLayout.getHeight();
                            int numOfCol = myGridLayout.getColumnCount();
                            int numOfRow = myGridLayout.getRowCount();
                            int w = pWidth / numOfCol;
                            int h = pHeight / numOfRow;

                            for (int yPos = 0; yPos < numOfRow; yPos++) {
                                for (int xPos = 0; xPos < numOfCol; xPos++) {
                                    GridLayout.LayoutParams params =
                                            (GridLayout.LayoutParams) myViews[yPos * numOfCol + xPos].getLayoutParams();

                                    params.width = w - 2 * MARGIN;
                                    params.height = h - 2 * MARGIN;

                                    params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
                                    myViews[yPos * numOfCol + xPos].setLayoutParams(params);


                                }
                            }

                        }

                    });
        }
    }


    public String floorPlanCheck(int row, int col) {

        FloorPlan FloorPlan = new FloorPlan();
        List<String> list = FloorPlan.getFloorPlan();

        String[] parts = new String[0];
        for (int x = 0; x < list.size(); x++) {
            parts = list.get(x).split("-");
            String rawId = parts[0];
            String columnId = parts[1];

            if (row == Integer.parseInt(rawId) && col == Integer.parseInt(columnId)) {
                return "yes";
            }


        }
        return "no";
    }


    public String cartCheck(int row, int col) {

        FloorPlan FloorPlan = new FloorPlan();
        List<String> list = FloorPlan.getCart();

        String[] parts = new String[0];
        for (int x = 0; x < list.size(); x++) {
            parts = list.get(x).split("-");
            String rawId = parts[0];
            String columnId = parts[1];

            if (row == Integer.parseInt(rawId) && col == Integer.parseInt(columnId)) {
                return "yes";
            }


        }
        return "no";
    }


    public String cashierCheck(int row, int col) {

        FloorPlan FloorPlan = new FloorPlan();
        List<String> list = FloorPlan.getCashier();

        String[] parts = new String[0];
        for (int x = 0; x < list.size(); x++) {
            parts = list.get(x).split("-");
            String rawId = parts[0];
            String columnId = parts[1];

            if (row == Integer.parseInt(rawId) && col == Integer.parseInt(columnId)) {
                return "yes";
            }


        }
        return "no";
    }





    public String rackPlanCheck(int row, int col) {


        String[] parts = new String[0];
        for (int x = 0; x < racklist.size(); x++) {
            parts = racklist.get(x).split("-");
            String rawId = parts[0];
            String columnId = parts[1];

            if (row == Integer.parseInt(rawId) && col == Integer.parseInt(columnId)) {
                return "yes";
            }


        }
        return "no";
    }

    public String nearestRack (int row, int col) {

        String[] parts = new String[0];
        parts = nearestSearchRack.split("-");
        String rawId = parts[0];
        String columnId = parts[1];

        if (row == Integer.parseInt(rawId) && col == Integer.parseInt(columnId)) {
            return "yes";
        }



        return "no";
    }


    public String currentLocationRack (int row, int col) {

        String[] parts = new String[0];
        parts = userCurrentLocationRack.split("-");
        String rawId = parts[0];
        String columnId = parts[1];

        if (row == Integer.parseInt(rawId) && col == Integer.parseInt(columnId)) {
            return "yes";
        }



        return "no";
    }



    public String pathCheck(int row, int col, List myList) {

        for (int x = 0; x < myList.size(); x++) {

            int rowPath = (int) myList.get(x);
            ++x;
            int colPath = (int) myList.get(x);

            if (row == rowPath && col == colPath) {
                return "yes";
            }
        }
        return "no";
    }

    public String[] getRackListToArray(List<String> racklist) {
        String[] rackListToArray = new String[racklist.size()];
        for (int x = 0; x < racklist.size(); x++) {
            rackListToArray[x] = racklist.get(x);
        }
        return rackListToArray;
    }

    //@RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @SuppressLint({"WrongConstant", "RestrictedApi"})
    private void manageBlinkEffect(int yPos, int numOfCol, int xPos) {
        ObjectAnimator anim = ObjectAnimator.ofInt(myViews[yPos * numOfCol + xPos], "backgroundColor", Color.WHITE, Color.RED,
                Color.WHITE);
        anim.setDuration(500);
        anim.setEvaluator(new ArgbEvaluator());
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);
        anim.start();
    }


    /// @RequiresApi(api = Build.VERSION_CODES.N)
    public void checkAddItemAndCartItem() {
        Path GetItemDistant = new Path();
        HashMap<String, Integer> itemDistantHashMap = new HashMap<String, Integer>();
        HashMap<String, List> itemPathHashMap = new HashMap<String, List>();
        ArrayList<Integer> distanList = new ArrayList<>();

        if ((!itemListAddCart.isEmpty())) {

            if (!(itemListSearch==null)) {
                remainItemListSearch = (itemListSearch);
                for (String s : itemListAddCart) {
                    if (remainItemListSearch.contains(s)) {
                        remainItemListSearch.remove(s);
                    }
                    System.out.println("intersect on " + remainItemListSearch);
                }

                if (remainItemListSearch.isEmpty()) {

                    if (itemListSearchSpecialCase==null) {
                        System.out.print("search list is empty");
                        getInitialview();

                        AlertDialog.Builder completeCurrentShoppingList = new AlertDialog.Builder(MainActivity.this);
                        completeCurrentShoppingList.setMessage("Buy the All Items in Current Shopping List");
                        completeCurrentShoppingList.show();
                    }
                    else if  (itemListSearchSpecialCase!=null)
                    {
                        checkAddItemAndCartItemSpecialCase();
                        System.out.println("i am in ");
                    }


                } else {
                    for (int a = 0; a < remainItemListSearch.size(); a++) {
                        remainItemListSearch.get(a);
                        itemListAddCart.get(itemListAddCart.size() - 1);
                        List itemDistant = GetItemDistant.shortestPath(remainItemListSearch.get(a), itemListAddCart.get(itemListAddCart.size() - 1));
                        itemPathHashMap.put(remainItemListSearch.get(a), itemDistant);
                        itemDistantHashMap.put(remainItemListSearch.get(a), itemDistant.size());
                        distanList.add(itemDistant.size());
                        System.out.print("In the condition");
                    }
                    Collections.sort(distanList);
                    System.out.print(distanList);
                    List<String> listOfKeys = getAllKeysForValue(itemDistantHashMap, distanList.get(0));
                    // listofkeys represent the rackid with shortest path the add the listofkeys to public variable  the
                    nearestSearchRack=listOfKeys.get(0);
                    userCurrentLocationRack=itemListAddCart.get(itemListAddCart.size() - 1);
                    List value = itemPathHashMap.get(listOfKeys.get(0));
                    getview(value);

                }
            }
        }


    }


    public void checkAddItemAndCartItemSpecialCase() {
        Path GetItemDistant = new Path();
        HashMap<String, Integer> itemDistantHashMap = new HashMap<String, Integer>();
        HashMap<String, List> itemPathHashMap = new HashMap<String, List>();
        ArrayList<Integer> distanList = new ArrayList<>();

        if ((!itemListAddCart.isEmpty())) {

            if (!(itemListSearchSpecialCase==null)) {
                remainItemListSearch = (itemListSearchSpecialCase);
                for (String s : itemListAddCart) {
                    if (remainItemListSearch.contains(s)) {
                        remainItemListSearch.remove(s);
                    }
                    System.out.println("intersect on " + remainItemListSearch);
                }

                if (remainItemListSearch.isEmpty()) {


                        System.out.print("search list is empty");
                        getInitialview();
                        AlertDialog.Builder completeCurrentShoppingList = new AlertDialog.Builder(MainActivity.this);
                        completeCurrentShoppingList.setMessage("Buy the All Items in Current Shopping List");
                        completeCurrentShoppingList.show();



                } else {
                    for (int a = 0; a < remainItemListSearch.size(); a++) {
                        remainItemListSearch.get(a);
                        itemListAddCart.get(itemListAddCart.size() - 1);
                        List itemDistant = GetItemDistant.shortestPath(remainItemListSearch.get(a), itemListAddCart.get(itemListAddCart.size() - 1));
                        itemPathHashMap.put(remainItemListSearch.get(a), itemDistant);
                        itemDistantHashMap.put(remainItemListSearch.get(a), itemDistant.size());
                        distanList.add(itemDistant.size());
                        System.out.print("In the condition");
                    }
                    Collections.sort(distanList);
                    System.out.print(distanList);
                    List<String> listOfKeys = getAllKeysForValue(itemDistantHashMap, distanList.get(0));
                    // listofkeys represent the rackid with shortest path the add the listofkeys to public variable  the
                    nearestSearchRack=listOfKeys.get(0);
                    userCurrentLocationRack=itemListAddCart.get(itemListAddCart.size() - 1);
                    List value = itemPathHashMap.get(listOfKeys.get(0));
                    getview(value);

                }
            }
        }


    }


    static <K, V> List<K> getAllKeysForValue(Map<K, V> mapOfWords, V value) {

        List<K> listOfKeys = null;


        if (mapOfWords.containsValue(value)) {

            listOfKeys = new ArrayList<>();

            for (Map.Entry<K, V> entry : mapOfWords.entrySet()) {
                if (entry.getValue().equals(value)) {
                    listOfKeys.add(entry.getKey());
                }
            }
        }
        return listOfKeys;
    }


    class send extends AsyncTask<Void,Void,Void> {
        Socket s;
        PrintWriter pw,wr;
        InputStream mystring;
        TextView newtex;

        logForm obje = new logForm();
        @Override
        protected Void doInBackground(Void...params){
            try {
                s = new Socket(logForm.serverIpAddress,3305);
                pw = new PrintWriter(s.getOutputStream());

                //wr = new PrintWriter(String.valueOf(s.getInputStream()));
                System.out.print(wr);
                pw.write(MainActivity.message);
                mystring =s.getInputStream();
                System.out.print(mystring);

                pw.flush();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                String line;
                line=br.readLine();
                String[] partsMessagefromServer = new String[0];
                partsMessagefromServer = line.split("#");
                String recommendationMessage = partsMessagefromServer[0];
                String recipesReconMessage = partsMessagefromServer[1];
                recommendation=recommendationMessage;
                recipesRecon=recipesReconMessage;


                pw.close();
                s.close();
            } catch (UnknownHostException e) {
                System.out.println("Fail");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println("Fail");
                e.printStackTrace();
            }
            return null;
        }




        public void mymethod(TextView responseText){

            responseText.setText("give Your user id ");


        }
    }
}


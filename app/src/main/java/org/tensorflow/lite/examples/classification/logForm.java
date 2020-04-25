
package org.tensorflow.lite.examples.classification;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.tensorflow.lite.examples.classification.indoormap.MainActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import androidx.appcompat.app.AppCompatActivity;

public class logForm extends AppCompatActivity {

    Button  secondFormButton,logFormButton;
    EditText ipAddress,userIdText;
    TextView responseText;
    public static String serverIpAddress;
    public static String userId;
    public static String serverConnectMsg;
    public static String message="Iamconnect";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_form);

        secondFormButton = (Button) findViewById(R.id.btnSecondForm);
        logFormButton = (Button) findViewById(R.id.btnLogForm);
        ipAddress = (EditText) findViewById(R.id.ipAddressText);
        userIdText = (EditText) findViewById(R.id.userText);
        responseText = (TextView )findViewById(R.id.responseText);



        secondFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //openSecondForm(responseText); //please remove the comment when need to connect to server


            }
        });
        logFormButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNextXml();// please comment this when need to connect to server
            /*   responseText.setText(serverConnectMsg);
                String checkMsg="Success";
                userId = userIdText.getText().toString();

                if(checkMsg.equals(serverConnectMsg)){

                    getNextXml();
                }
                else {
                    responseText.setText("Cant connect sever");
                }*/



            }
        });



    }


    public  void getNextXml(){

        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openSecondForm(TextView responseText){
        serverIpAddress = ipAddress.getText().toString();
        send sendcode = new send();

        sendcode.execute();
        sendcode.mymethod(responseText);


    }






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
            pw.write(logForm.message);
            mystring =s.getInputStream();
            System.out.print(mystring);

            pw.flush();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line;
            line=br.readLine();
            obje.serverConnectMsg=line;


            pw.close();
            s.close();
        } catch (UnknownHostException e) {
            System.out.println("Fail");
            obje.serverConnectMsg="conLos";
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Fail");
            obje.serverConnectMsg="conLos";
            e.printStackTrace();
        }
        return null;
    }




    public void mymethod(TextView responseText){

        responseText.setText("give Your user id ");


    }
}
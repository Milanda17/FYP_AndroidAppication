package org.tensorflow.lite.examples.classification.indoormap.aStar;

import org.tensorflow.lite.examples.classification.indoormap.FloorPlan ;

import org.tensorflow.lite.examples.classification.indoormap.FloorPlan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Path {


    public List shortestPath(String item,String start){
        String[] partsItem = new String[0];
        String[] partsStart = new String[0];

        partsItem = item.split("-");
        partsStart = start.split("-");

        String rawItemId = partsItem[0];
        String columnItemId = partsItem[1];

        String rawStartId = partsStart[0];
        String columnStartId = partsStart[1];
        Node initialNode = new Node(Integer.parseInt(rawItemId),Integer.parseInt(columnItemId));
        Node finalNode = new Node(Integer.parseInt(rawStartId),Integer.parseInt(columnStartId));
        //Node finalNode = new Node(15, 07);
        int rows = 20;
        int cols = 50;
        List listSource = new ArrayList();

        AStar aStar = new AStar(rows, cols, initialNode, finalNode);

        FloorPlan FloorPlan = new FloorPlan();
        ArrayList<String> blocksArray = new ArrayList<>(Arrays.asList());
        List<String> rackArray = FloorPlan.getRackPlan();
        List<String> floorArray = FloorPlan.getFloorPlan();
        List<String> cashierArray = FloorPlan.getCashier();
        List<String> cartArray = FloorPlan.getCart();
       // List<String> blocksArray = FloorPlan.getRackPlan();
        blocksArray.addAll(rackArray);
        blocksArray.addAll(floorArray);
        blocksArray.addAll(cashierArray);
        blocksArray.addAll(cartArray);



        aStar.setBlocks(blocksArray,start,rawStartId,columnStartId);
        List<Node> path = aStar.findPath();
        for (Node node : path) {
            listSource.add(node.getRow());
            listSource.add(node.getCol());
        }


        return listSource;
    }

}

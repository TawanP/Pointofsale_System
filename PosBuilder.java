//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Scanner;
//import java.io.*;
///*
//This class purpose is to build a (Graph) data structure from the input menu.
//@author Luke Panupon Burnett
// */
//public class PosBuilder<T>
//{
//    /*
//    All data inside the input file will be break down into words and store inside each array.
//     */
//    private ArrayList<String> menuArray;
//
//    /*
//    This is constructor
//    @param file name of the menu
//     */
//    public PosBuilder(String menuFile)
//    {
//        menuArray = readData(menuFile);
//    }
//
//    /*
//    This method read data inside the file and convert them into list of words
//     */
//    public ArrayList<String> readData(String menuFile)
//    {
//        ArrayList<String> newFileArray = new ArrayList<String>();
//        try
//        {
//            BufferedReader reader = new BufferedReader(new FileReader(menuFile));
//            StringBuilder sb = new StringBuilder();
//            String currLine;
//            //Each menu in each line will be split menu by menu here with a comma (,).
//            while((currLine = reader.readLine()) != null) sb.append(currLine).append(",");
//            //Split each line into each array
//            String[] lineSplit = sb.toString().split(",");
//            //Store each menu into newFileArray
//            for(String menu: lineSplit) newFileArray.add(menu.trim());
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        return newFileArray;
//    }
//
//    /*
//    This method create data structure to store all the menu information.
//     */
//    public Node<String> buildStructure(ArrayList<String> fileArray, Node<String> node)
//    {
//
//    }
//}

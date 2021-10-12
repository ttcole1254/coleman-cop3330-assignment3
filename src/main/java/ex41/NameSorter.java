package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class NameSorter {
    public static BufferedReader readFile = null;
    public static BufferedWriter writeFile = null;
    public static String filePath = System.getProperty("user.dir");

    public static void main(String[] args) {
        ArrayList<String> fileLines = fileRead(readFile, filePath + "/exercise41_input.txt");
        Collections.sort(fileLines);
        writeFile = fileWrite(writeFile, fileLines, filePath + "/exercise41_output.txt");
    }

    public static ArrayList<String> fileRead(BufferedReader inputFile, String fileName) {
        ArrayList<String> fileLines = new ArrayList<>();
        try {
            inputFile = new BufferedReader(new FileReader(fileName));
            String eachLines = inputFile.readLine();
            while (eachLines != null) {
                fileLines.add(eachLines);
                eachLines = inputFile.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (inputFile != null) {
                    inputFile.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileLines;
    }
    public static BufferedWriter fileWrite(BufferedWriter outputFile, ArrayList<String> sortedString, String fileName) {
        try {
            outputFile = new BufferedWriter(new FileWriter(fileName));
            int numOfLines = sortedString.size();
            outputFile.write("Total of " + numOfLines + " names\n-----------------\n");
            for (String eachLine : sortedString) {
                outputFile.write(eachLine);
                outputFile.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (outputFile != null) {
                    outputFile.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputFile;
    }
}

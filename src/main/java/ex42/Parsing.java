package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.io.*;
import java.util.ArrayList;

public class Parsing {
    public static BufferedReader readFile = null;
    public static BufferedWriter writeFile = null;
    public static String filePath = System.getProperty("user.dir");

    public static void main(String[] args) {
        ArrayList<String> fileLines = fileRead(readFile, filePath + "/exercise42_input.txt");
        writeFile = fileWrite(writeFile, fileLines, filePath + "/exercise42_output.txt");
    }
    public static BufferedWriter fileWrite(BufferedWriter outputFile, ArrayList<String> inputString, String fileName) {
        try {
            outputFile = new BufferedWriter(new FileWriter(fileName));
            String[] parsedString;
            outputFile.write("Last      First     Salary\n--------------------------\n");
            for (String eachLine : inputString) {
                parsedString = eachLine.split(",");
                outputFile.write(String.format("%-10s" + "%-10.10s" + "%-10.50s", parsedString[0], parsedString[1], parsedString[2]));
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
}

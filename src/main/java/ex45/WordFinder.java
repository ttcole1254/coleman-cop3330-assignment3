package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class TextFileInput {
    private final String filePath;
    private ArrayList<String> contents;
    private String output;

    public TextFileInput(String filePath) {
        this.filePath = filePath;
    }
    public String getFilePath() {
        return filePath;
    }
    public ArrayList<String> getContents() {
        return contents;
    }
    public void setContents(ArrayList<String> contents) {
        this.contents = contents;
    }
    public String getOutput() {
        return output;
    }
    public void setOutput(String output) {
        this.output = output;
    }
    public void readFileInput() {
        String path = getFilePath();
        ArrayList<String> a = new ArrayList<>();
        try (Scanner file = new Scanner(new File(path)).useDelimiter(System.lineSeparator())) {
            while (file.hasNext()) a.add(file.next());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        setContents(a);
    }
    public void replaceWord(String target, String with) {
        ArrayList<String> l = getContents();
        for (int i = 0; i < l.size(); i++) {
            String s = l.get(i).replaceAll(target, with);
            l.set(i, s);
        }
        setContents(l);
    }
    public void buildOutput() {
        ArrayList<String> l = getContents();
        StringBuilder out = new StringBuilder();
        for (String line : l) {
            out.append(line).append("\n");
        }
        setOutput(out.toString());
    }
}

public class WordFinder {
    public static String filePath = System.getProperty("user.dir");
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        String inputFile = filePath + "/exercise45_input.txt";
        System.out.println("What would you like the new file to be named? ");
        String fileName = in.nextLine();
        fileName = fixFileName(fileName);
        TextFileInput input = new TextFileInput(inputFile);
        input.readFileInput();
        String replaceTarget = "utilize";
        String replaceWith = "use";
        input.replaceWord(replaceTarget, replaceWith);
        input.buildOutput();
        writeFile(fileName, input);
        System.out.println(input.getOutput());
    }
    public static String fixFileName(String fileName) {
        if(!fileName.endsWith(".txt")) {
            fileName = fileName + ".txt";
        }
        return fileName;
    }
    public static FileWriter writeFile(String fileName, TextFileInput text) {
        FileWriter w = null;
        try {
            w = new FileWriter(filePath + "/" + fileName);
            w.write(text.getOutput());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (w != null) {
                    w.close();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return w;
    }
}

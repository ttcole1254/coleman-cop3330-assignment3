package ex43;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Tyler Coleman
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class WebsiteGenerator {
    public static Scanner in = new Scanner(System.in);
    public static FileWriter html = null;
    public static String filePath = System.getProperty("user.dir");

    public static void main(String[] args) {
        ArrayList<String> websiteData = getWebsiteData();
        pathMaker(websiteData);
    }
    public static ArrayList<String> getWebsiteData() {
        ArrayList<String> websiteData = new ArrayList<>();
        System.out.println("Site name: ");
        websiteData.add(in.nextLine());
        System.out.println("Author: ");
        websiteData.add(in.nextLine());
        System.out.println("Do you want a folder for JavaScript?: ");
        websiteData.add(in.nextLine());
        System.out.println("Do you want a folder for CSS?: ");
        websiteData.add(in.nextLine());
        return websiteData;
    }

    public static void pathMaker(ArrayList<String> websiteData) {
        File folder;
        String askInput;
        for (int i = 0; i < websiteData.size(); i++) {
            switch (i) {
                case 0 -> {
                    folder = createFolderPath(filePath, "website", websiteData.get(i));
                    createFolder(folder);
                    filePath += "//website";
                }
                case 1 -> {
                    html = htmlMaker(html, websiteData, (filePath + "//" + websiteData.get(0) + "//index.html"));
                    createHTMLFile(html, (filePath + "//" + websiteData.get(0) + "//index.html"));
                }
                case 2 -> {
                    askInput = websiteData.get(i);
                    if (askInput.equalsIgnoreCase("y") || askInput.equalsIgnoreCase("yes")) {
                        folder = createFolderPath(filePath, websiteData.get(0), "js");
                        createFolder(folder);
                    }
                }
                case 3 -> {
                    askInput = websiteData.get(i);
                    if (askInput.equalsIgnoreCase("y") || askInput.equalsIgnoreCase("yes")) {
                        folder = createFolderPath(filePath, websiteData.get(0), "css");
                        createFolder(folder);
                    }
                }
            }
        }
    }
    public static File createFolderPath(String sourceDir, String folderName, String subFolderName) {
        sourceDir += ("//" + folderName + "//" + subFolderName);
        return new File(sourceDir);
    }
    public static void createFolder(File folder) {
        boolean fileCreated = (folder.mkdirs());
        if (fileCreated) {
            System.out.println("Created " + folder.getAbsolutePath());
        } else {
            System.out.println("Failed to create folder " + folder + ", it may already exist.");
        }
    }
    public static void createHTMLFile(FileWriter outputFile, String path) {
        if (outputFile != null) {
            File file = new File(path);
            System.out.println("Created " + file.getAbsolutePath());
        } else {
            System.out.println("Failed to create file " + outputFile + ".");
        }
    }
    public static FileWriter htmlMaker(FileWriter outputFile, ArrayList<String> websiteData, String path) {
        try {
            outputFile = new FileWriter(path);
            outputFile.write("<!DOCTYPE html>\n<html>\n<head>\n<title>" + websiteData.get(0) + "</title>\n" +
                    "<meta name=\"Author\" content=\"" + websiteData.get(1) + "\">\n</head>\n</html>");
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

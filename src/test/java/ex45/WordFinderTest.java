package ex45;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import static ex45.WordFinder.writeFile;
import static org.junit.jupiter.api.Assertions.*;

class WordFinderTest {
    public static String filePath = System.getProperty("user.dir");
    @Test
    void wordReplacer() {
        String inputFile = filePath + "/ex45-test";
        TextFileInput input = new TextFileInput(inputFile);
        input.readFileInput();
        String replaceTarget = "string";
        String replaceWith = "word";
        input.replaceWord(replaceTarget, replaceWith);
        String replaced = input.toString();

        assertEquals("Test word", replaced);

    }
    @Test
    void fileWriter(){
        TextFileInput file = new TextFileInput(filePath + "/ex45-test.txt");
        FileWriter writeFile = WordFinder.writeFile("/ex45-test-output.txt", file);
        boolean actualOutput = writeFile != null;
        assertTrue(actualOutput);
    }

}
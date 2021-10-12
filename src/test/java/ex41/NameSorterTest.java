package ex41;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class NameSorterTest {
    BufferedReader readFile = null;
    BufferedWriter writeFile = null;
    public static String filePath = System.getProperty("user.dir");

    @Test
    void fileReader() {
        ArrayList<String> fileLines = NameSorter.fileRead(this.readFile, filePath + "/ex41-test.txt");
        String expected = "Name, Test";
        String actual = fileLines.get(0);
        assertEquals(actual, expected);
    }
    @Test
    void fileWriter() {
        ArrayList<String> fileLines = NameSorter.fileRead(this.readFile, filePath + "/ex41-test.txt");
        Collections.sort(fileLines);
        this.writeFile = NameSorter.fileWrite(this.writeFile, fileLines, filePath + "/ex41-testOutput.txt");
        boolean actual = this.writeFile != null;
        assertTrue(actual);
    }
}
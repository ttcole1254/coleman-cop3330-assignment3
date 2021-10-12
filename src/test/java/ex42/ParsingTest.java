package ex42;

import ex41.NameSorter;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParsingTest {
    BufferedReader readFile = null;
    BufferedWriter writeFile = null;
    public static String filePath = System.getProperty("user.dir");

    @Test
    void fileReader() {
        ArrayList<String> fileLines = Parsing.fileRead(this.readFile, filePath + "/ex42-test.txt");
        String expected = "Name,Test,10,20";
        String actual = fileLines.get(0);
        assertEquals(actual, expected);
    }

    @Test
    void fileWriter() {
        ArrayList<String> fileLines = Parsing.fileRead(this.readFile, filePath + "/ex42-test.txt");
        this.writeFile = Parsing.fileWrite(this.writeFile, fileLines, filePath + "/ex42-test-output");
        boolean actual = this.writeFile != null;
        assertTrue(actual);
    }

}
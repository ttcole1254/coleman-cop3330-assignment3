package ex43;

import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {

    public static String testDir = System.getProperty("user.dir");
    public static final String parentFolderName = "TestWebsite";
    public static final String subFolderName = "TestSubfolder";
    public static FileWriter htmlFile = null;

    @Test
    void testHTML() {
        ArrayList<String> websiteData = new ArrayList<>();
        websiteData.add("Name: Test");
        websiteData.add("Author: Sample");

        htmlFile = WebsiteGenerator.htmlMaker(htmlFile, websiteData, testDir + "//index.html");
        boolean result = htmlFile != null;
        assertTrue(result);
    }

}
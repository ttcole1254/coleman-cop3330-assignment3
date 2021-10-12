package ex44;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ProductSearchTest {

    public static String filePath = System.getProperty("user.dir");

    @Test
    void testProducts() {
        String input = filePath + "/ex44-test.json";
        List<Products> products = ProductSearch.getProducts(input);
        String actualName1 = products.get(0).getName();
        String expectedName1 = "Test1";
        Double actualPrice1 = products.get(0).getPrice();
        Double expectedPrice1 = 5.00;
        Integer actualQuantity1 = products.get(0).getQuantity();
        Integer expectedQuantity1 = 1;

        String actualName2 = products.get(1).getName();
        String expectedName2 = "Test2";
        Double actualPrice2 = products.get(1).getPrice();
        Double expectedPrice2 = 10.00;
        Integer actualQuantity2 = products.get(1).getQuantity();
        Integer expectedQuantity2 = 50;

        String actualName3 = products.get(2).getName();
        String expectedName3 = "Test3";
        Double actualPrice3 = products.get(2).getPrice();
        Double expectedPrice3 = 15.00;
        Integer actualQuantity3 = products.get(2).getQuantity();
        Integer expectedQuantity3 = 100;

        assertEquals(actualName1, expectedName1);
        assertEquals(actualPrice1, expectedPrice1);
        assertEquals(actualQuantity1, expectedQuantity1);

        assertEquals(actualName2, expectedName2);
        assertEquals(actualPrice2, expectedPrice2);
        assertEquals(actualQuantity2, expectedQuantity2);

        assertEquals(actualName3, expectedName3);
        assertEquals(actualPrice3, expectedPrice3);
        assertEquals(actualQuantity3, expectedQuantity3);

    }
    @Test
    void productFinderTrue() {
        String input = filePath + "/exercise44_input.json";
        List<Products> products = ProductSearch.getProducts(input);
        String productSearch = "widget";
        Products actual = ProductSearch.search(products, productSearch);
        String result = actual.getName().toLowerCase();
        assertEquals(productSearch, result);
    }

    @Test
    void productFinderFalse() {
        String input = filePath + "/exercise44_input.json";
        List<Products> products = ProductSearch.getProducts(input);
        String productSearch = "fruit loops";
        Products actual = ProductSearch.search(products, productSearch);
        String result = actual.getName();
        assertNotEquals(productSearch, result);
    }
}
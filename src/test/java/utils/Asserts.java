package utils;

import org.openqa.selenium.WebElement;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Asserts {

    /**
     * Ensures that web element contains exactly one text.
     * Example: assertive(element, "text of assertion");
     *
     * @param webElement
     * @param text
     */

    public static void assertive(WebElement webElement, String text) {
        webElement.isEnabled();
        assertEquals(webElement.getText(), text);
    }

    /**
     * Validation contains text in a web element.
     * Example: contains(element, "text of assertion");
     * 
     * @param webElement
     * @param text
     */

    public static void contains(WebElement webElement, String text) {
        webElement.isEnabled();
        assertTrue(webElement.getText().contains(text));
    }

    /**
     * Asserts which element is visible on the screen
     * Example: assertVisible(element);
     *
     * @param webElement
     */

    public static void assertVisible(WebElement webElement) {
        try {
            webElement.isEnabled();
            webElement.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Element not visible!");
        }
    }
}
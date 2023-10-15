package utils;

import org.junit.Assert;
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

    /*
     * Comando para fazer asserções com textos e textos
     * Ex: assertText(elemento, "meu texto");
     */

    public static void assertText(String text, String textTwo) {
        Assert.assertEquals(text, textTwo);
    };

    /*
     * Comando para fazer asserções com textos e textos
     * Ex: containsText("Texto 1", "texto 2");
     */

    public static void containsText(String textOne, String textTwo) {
        Assert.assertTrue(textOne.contains(textTwo));
    };

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
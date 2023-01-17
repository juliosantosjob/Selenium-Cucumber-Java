package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import support.DriverDefinition;

import java.time.Duration;

import static java.lang.System.out;

public class Commands extends DriverDefinition {

    /**
     * Click on the field.
     *
     * @param text The text to be clicked
     * @throws Exception
     */

    public static void clickText(String text) {
        try {
            driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
        } catch (Exception e) {
            out.println("Unable to click text!");
        }
    }

    /**
     * Wait for a defined time until the web element is visible on the screen.
     *
     * @param webElement
     * @param timeout    How many seconds to wait for element to be visible
     * @return
     * @throws Exception
     */

    public static WebElement waitForElement(WebElement webElement, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (Exception e) {
            out.println("Unable to wait for element!");
        }
        return webElement;
    }

    /**
     * Wait for element to become invisible.
     *
     * @param elementBy
     */

    public static void waitElementDisappear(By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    /**
     * Wait a defined time until the web element is visible on the screen and click on it.
     *
     * @param webElement
     * @param timeout
     * @return
     * @throws Exception
     */

    public static WebElement waitAndTap(WebElement webElement, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (Exception e) {
            out.println("Unable to wait for element!");
        }
        return webElement;
    }

    /**
     * Click command for element that is not in focus.
     *
     * @param webElement
     */

    public static void realClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    /**
     * Wait until element is visible and enabled.
     *
     * @param webElement
     * @param timeout
     * @return
     * @throws Exception
     */

    public static WebElement isEnable(WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.isEnabled();
        } catch (Exception e) {
            out.println("element is not enabled!");
        }
        return webElement;
    }

    /**
     * Scroll to web element.
     *
     * @param webElement
     * @return
     */

    public static WebElement scrollTo(WebElement webElement) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
        } catch (Exception e) {
            out.println(e.getCause());
        }
        return webElement;
    }

    /**
     * Floating mouse over web element.
     *
     * @param webElement
     */

    public static WebElement mouseHover(WebElement webElement) {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).build().perform();
        return webElement;
    }

    /**
     * Command to select options.
     *
     * @param webElement
     * @param option
     */

    public static void selectOption(WebElement webElement, String option) {
        Select select = new Select(webElement);
        select.selectByVisibleText(option);
    }

    /**
     * Support command to debug.
     *
     * @param timeout
     */

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ignored) {
            out.println("Error execution wait!");
        }
    }
}
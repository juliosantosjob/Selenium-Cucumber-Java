package support;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.System.out;

public class BasePage {
    protected static WebDriver driver;
    public static String browser = System.getProperty("BROWSER", "CHROME");

    /**
     * Set up the driver instance.
     */

    public static void setUp() {
        if (driver == null) {
            System.setProperty(support.enums.Browsers.getPropertyDriver(browser),
                    support.enums.Browsers.getPathDriver(browser));
            driver = Browsers.getInstanceOptions();
        }
    }

    /**
     * Close the browser.
     */

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    /**
     * Get the driver.
     * 
     * @return driver
     */

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Visit the url.
     * Example: visit("https://www.example.com");
     *
     * @param url The url to be visited
     */

    public static void visit(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            out.println("Error to visit the url " + url);
        }
    }

    /**
     * Get the text from the web element.
     * Example: getTxt(element);
     *
     * @param webElement
     * @return
     * @throws Exception
     */

    public static String grabText(WebElement webElement) {
        try {
            waitForElement(webElement, 10);
            return webElement.getText();
        } catch (Exception e) {
            throw new RuntimeException("Error getting text from element: " + e.getMessage());
        }
    }

    /**
     * Clicks on the specified WebElement.
     *
     * @param webElement the WebElement to be clicked
     */

    public static void click(WebElement webElement) {
        try {
            waitForElement(webElement, 10);
            webElement.click();
        } catch (Exception e) {
            throw new RuntimeException("Error clicking on element: " + e.getMessage());
        }
    }

    /**
     * Click on the field.
     * Example: clickText("text");
     *
     * @param text The text to be clicked
     * @throws Exception
     */

    public static void clickText(String text) {
        try {
            driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
        } catch (Exception e) {
            out.println("Not found text: " + text);
        }
    }

    /**
     * Sends a given text to a web element by invoking the `sendKeys` method on the
     * web element.
     *
     * @param webElement the web element to type the text into
     * @param text       the text to send to the web element
     */

    public static void type(WebElement webElement, String text) {
        try {
            webElement.sendKeys(text);
        } catch (Exception e) {
            out.println("Error trying to send keys: " + e.getMessage());
        }
    }

    /**
     * Sends a given text to a web element by invoking the `sendKeys` method on the
     * web element.
     *
     * @param webElement the web element to type the text into
     * @param text       the text to send to the web element
     */

    public static void typeAndPress(WebElement webElement, String text, Keys enter) {
        try {
            webElement.sendKeys(text, enter);
        } catch (Exception e) {
            out.println("Error trying to send keys: " + e.getMessage());
        }
    }

    /**
     * Waits for a web element to become clickable within a specified timeout.
     *
     * @param webElement the web element to wait for
     * @param timeout    the maximum time to wait in seconds
     * @return the web element if it becomes clickable within the timeout,
     *         or null if it does not become clickable
     */

    public static WebElement waitForElement(WebElement webElement, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.isDisplayed();
        } catch (Exception e) {
            out.println("Error waiting for element to be clickable: " + e.getMessage());
            return null;
        }
        return webElement;
    }

    /**
     * Wait for element to become invisible.
     * Example: waitElementDisappear(element, 10);
     *
     * @param elementBy
     */

    public static void waitElementDisappear(By elementBy) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
        } catch (Exception e) {
            out.println("Error waiting for element to disappear: " + e.getMessage());
        }
    }

    /**
     * Click command for element that is not in focus.
     * Example: realClick(element);
     *
     * @param webElement
     */

    public static void realClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            executor.executeScript("arguments[0].click();", webElement);
        } catch (Exception e) {
            out.println("Error click: " + e.getMessage());
        }
    }

    /**
     * Wait until element is visible and enabled.
     * Element: isEnable(element);
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
            return webElement;
        } catch (Exception e) {
            out.println("Error waiting for element to be clickable: " + e.getMessage());
            return null;
        }
    }

    /**
     * Scroll to web element.
     * Element: scrollTo(element);
     *
     * @param webElement
     * @return
     */

    public static WebElement scrollTo(WebElement webElement) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            return webElement;
        } catch (Exception e) {
            out.println("Error scrolling to element: " + e.getMessage());
            return null;
        }
    }

    /**
     * Floating mouse over web element.
     * Example: mouseHover(element);
     *
     * @param webElement
     */

    public static WebElement mouseHover(WebElement webElement) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(webElement).build().perform();
            return webElement;
        } catch (Exception e) {
            out.println("Error hovering mouse to element: " + e.getMessage());
            return null;
        }
    }

    /**
     * Command to select options.
     * Example: selectOption(element, "text option");
     *
     * @param webElement
     * @param option
     */

    public static void selectOptions(WebElement webElement, String option) {
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(option);
        } catch (Exception e) {
            out.println("Error selecting option: " + e.getMessage());
        }
    }

    /**
     * Support command to debug.
     * Example: sleep(5000);
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
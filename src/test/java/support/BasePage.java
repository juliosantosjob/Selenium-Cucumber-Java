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
import support.enums.BrowsersLin;
import support.enums.BrowsersMac;
import support.enums.BrowsersWin;

import static java.lang.System.out;

public class BasePage {
    protected static WebDriver driver;
    public static long MAT_TIMEOUT = 10;
    public static String browser = System.getProperty("BROWSER");
    public static String os = System.getProperty("os.name");

    public static void setUp() {
        if (driver == null) {
            if (os.toLowerCase().contains("win")) {
                System.setProperty(BrowsersWin.getPropertyDriver(browser), BrowsersWin.getPathDriver(browser));
            } else if (os.toLowerCase().contains("nix") || os.contains("nux")) {
                System.setProperty(BrowsersLin.getPropertyDriver(browser), "/usr/local/bin/chromedriver");
            } else if (os.toLowerCase().contains("mac")) {
                System.setProperty(BrowsersMac.getPropertyDriver(browser), BrowsersMac.getPathDriver(browser));
            }
            driver = Browsers.getInstanceOptions();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            out.println("Error to visit the url " + url);
        }
    }

    public static String grabText(WebElement webElement) {
        try {
            waitForElement(webElement, MAT_TIMEOUT);
            return webElement.getText();
        } catch (Exception e) {
            throw new RuntimeException("Error getting text from element: " + e.getMessage());
        }
    }

    public static void click(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAT_TIMEOUT));
        int maxAttempts = 5;
        int attempts = 1;

        try {
            while (attempts <= maxAttempts) {
                try {
                    wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
                    wait.until(ExpectedConditions.elementToBeClickable(webElement));
                    webElement.click();
                    break;
                } catch (Exception e) {
                    attempts++;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Error clicking on element: " + e.getMessage());
        }
    }

    public static void clickText(String text) {
        try {
            driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
        } catch (Exception e) {
            out.println("Not found text: " + text);
        }
    }

    public static void type(WebElement webElement, String text) {
        try {
            webElement.sendKeys(text);
        } catch (Exception e) {
            out.println("Error trying to send keys: " + e.getMessage());
        }
    }

    public static void typeAndPress(WebElement webElement, String text, Keys enter) {
        try {
            webElement.sendKeys(text, enter);
        } catch (Exception e) {
            out.println("Error trying to send keys: " + e.getMessage());
        }
    }

    public static WebElement waitForElement(WebElement webElement, long timeout) {
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

    public static void waitElementDisappear(By elementBy) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(MAT_TIMEOUT));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
        } catch (Exception e) {
            out.println("Error waiting for element to disappear: " + e.getMessage());
        }
    }

    public static void clickJS(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            executor.executeScript("arguments[0].click();", webElement);
        } catch (Exception e) {
            out.println("Error click: " + e.getMessage());
        }
    }

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

    public static WebElement scrollTo(WebElement webElement) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", webElement);
            return webElement;
        } catch (Exception e) {
            out.println("Error scrolling to element: " + e.getMessage());
            return null;
        }
    }

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

    public static void selectOptions(WebElement webElement, String option) {
        try {
            Select select = new Select(webElement);
            select.selectByVisibleText(option);
        } catch (Exception e) {
            out.println("Error selecting option: " + e.getMessage());
        }
    }

    public static void stop(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException ignored) {
            out.println("Error execution wait!");
        }
    }
}
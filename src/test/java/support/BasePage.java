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
import support.enums.DriversEnum;

import static java.lang.System.out;

public class BasePage {
    public static String browser = System.getProperty("BROWSER", "CHROME");
    public static JavascriptExecutor js;
    protected static WebDriver driver;
    public static WebDriverWait wait;
    public static long MAT_TIMEOUT = 10;
    public static Actions action;
    public static Select select;

    public static void setUp() {
        System.setProperty(DriversEnum.getPropertyDriver(browser), DriversEnum.getDriverPathBySystem(browser));
        driver = Browsers.getInstanceOptions();
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

    public static String grabText(WebElement webElement, long... timeout) {
        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout.length > 0 ? timeout[0] : MAT_TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            return webElement.getText();
        } catch (Exception e) {
            throw new RuntimeException("Error getting text from element: " + e.getMessage());
        }
    }

    public static void click(WebElement webElement, long... timeout) {
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout.length > 0 ? timeout[0] : MAT_TIMEOUT));
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
            getDriver().findElement(By.xpath("//*[text()='" + text + "']")).click();
        } catch (Exception e) {
            out.println("Not found text: " + text);
        }
    }

    public static void type(WebElement webElement, String text, long... timeout) {
        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout.length > 0 ? timeout[0] : MAT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.sendKeys(text);
        } catch (Exception e) {
            out.println("Error trying to send keys: " + e.getMessage());
        }
    }

    public static void typeAndPress(WebElement webElement, String text, Keys enter, long... timeout) {
        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout.length > 0 ? timeout[0] : MAT_TIMEOUT));
            wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.sendKeys(text, enter);
        } catch (Exception e) {
            out.println("Error trying to send keys: " + e.getMessage());
        }
    }

    public static WebElement waitForElement(WebElement webElement, long... timeout) {
        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout.length > 0 ? timeout[0] : MAT_TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.isDisplayed();
        } catch (Exception e) {
            out.println("Error waiting for element to be clickable: " + e.getMessage());
            return null;
        }
        return webElement;
    }

    public static void waitElementDisappear(By elementBy, long... timeout) {
        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout.length > 0 ? timeout[0] : MAT_TIMEOUT));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
        } catch (Exception e) {
            out.println("Error waiting for element to disappear: " + e.getMessage());
        }
    }

    public static void clickJS(WebElement webElement) {
        js = (JavascriptExecutor) getDriver();
        try {
            js.executeScript("arguments[0].click();", webElement);
        } catch (Exception e) {
            out.println("Error click: " + e.getMessage());
        }
    }

    public static WebElement isEnable(WebElement webElement) {
        try {
            wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.isEnabled();
            return webElement;
        } catch (Exception e) {
            out.println("Error waiting for element to be clickable: " + e.getMessage());
            return null;
        }
    }

    public static WebElement scrollTo(WebElement webElement) {
        js = (JavascriptExecutor) getDriver();

        try {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            return webElement;
        } catch (Exception e) {
            out.println("Error scrolling to element: " + e.getMessage());
            return null;
        }
    }

    public static WebElement mouseHover(WebElement webElement) {
        try {
            action = new Actions(getDriver());
            action.moveToElement(webElement).build().perform();
            return webElement;
        } catch (Exception e) {
            out.println("Error hovering mouse to element: " + e.getMessage());
            return null;
        }
    }

    public static void selectOptions(WebElement webElement, String option) {
        try {
            select = new Select(webElement);
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
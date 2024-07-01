package support;

import org.openqa.selenium.WebDriver;

import enums.Browsers;

public class DriverDefinition {
    protected static WebDriver driver;
    public static String browser = System.getProperty("BROWSER", "CHROME_HEADLESS");

    public static void setUp() {
        if (driver == null) {
            System.setProperty(Browsers.getPropertyDriver(browser),
                    Browsers.getPathDriver(browser));
            driver = InstancesBrowsers.getInstanceOptions();
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
}
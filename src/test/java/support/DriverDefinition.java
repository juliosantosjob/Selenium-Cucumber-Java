package support;

import org.openqa.selenium.WebDriver;

import enums.Browsers;

public class DriverDefinition {
    protected static WebDriver driver;
    protected static String browser = System.getProperty("BROWSER", "CHROME");

    public static void setDriver() {
        System.setProperty(Browsers.getPropertyDriver(browser),
                Browsers.getPathDriver(browser));
        driver = InstancesBrowsers.getInstanceOptions();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import enums.Browsers;

import static java.lang.System.getProperty;

public class DriverDefinition {
    protected static WebDriver driver;
    private static String browser = getProperty("BROWSER");

    public static void browserConfig() {
        if (browser == null) {
            browser = "CHROME_HEADLES";
        }

        switch (browser) {
            case "CHROME":
                System.setProperty(Browsers.getPropertyDriver(browser),
                        Browsers.getPathDriver(browser));

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");

                driver = new ChromeDriver(options);
                break;

            case "EDGE":
                System.setProperty(Browsers.getPropertyDriver(browser),
                        Browsers.getPathDriver(browser));

                driver = new EdgeDriver();
                break;

            case "CHROME_HEADLESS":
                System.setProperty(Browsers.getPropertyDriver(browser),
                        Browsers.getPathDriver(browser));

                ChromeOptions optChrome = new ChromeOptions();
                optChrome.addArguments("-headless");
                optChrome.addArguments("--remote-allow-origins=*");
                optChrome.addArguments("--window-size=1920x1080");
                driver = new ChromeDriver(optChrome);
                break;

            case "EDGE_HEADLESS":
                System.setProperty(Browsers.getPropertyDriver(browser),
                        Browsers.getPathDriver(browser));

                EdgeOptions optEdge = new EdgeOptions();
                optEdge.addArguments("headless");
                optEdge.addArguments("--window-size=1920x1080");
                driver = new EdgeDriver(optEdge);
                break;

            default:
                throw new IllegalArgumentException("Invalid browser argument!");
        }
    }
}
package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static java.lang.System.getProperty;

public class DriverDefinition {
    protected static WebDriver driver;
    private static String browser = getProperty("BROWSER");


    public static void browserConfig() {
        if (browser == null)
            browser = "chrome-headless";

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();

                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions optChrome = new ChromeOptions();
                optChrome.addArguments("--headless");
                optChrome.addArguments("--remote-allow-origins=*");
                optChrome.addArguments("--window-size=1920x1080");
                driver = new ChromeDriver(optChrome);
                break;

            case "edge-headless":
                WebDriverManager.edgedriver().setup();
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
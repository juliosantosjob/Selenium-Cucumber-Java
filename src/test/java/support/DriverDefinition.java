package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static environments.setup.Env.env;
import static java.lang.System.getProperty;
import static java.lang.System.out;

public class DriverDefinition {
    protected static WebDriver driver;
    String browser = getProperty("BROWSER");

    public static DriverDefinition driverDefinition() {
        return new DriverDefinition();
    }

    public WebDriver browserConfig() throws Exception {
        try {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions optChrome = new ChromeOptions();
                    optChrome.addArguments("--headless");
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
        } catch (Exception e) {
            throw new IllegalArgumentException("You must pass the BROWSER parameter to this run!");
        }

        return driver;
    }
}

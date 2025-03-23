package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browsers {
    
    public static WebDriver getInstanceOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        ChromeOptions chromeOptions = new ChromeOptions();
        FirefoxOptions firefoxOptions = new FirefoxOptions();

        switch (BasePage.browser.toUpperCase()) {
            case "CHROME":
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);

           case "CHROME_HEADLESS":
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(chromeOptions);
            
            case "EDGE":
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions);

            case "EDGE_HEADLESS":
                edgeOptions.addArguments("--headless");
                edgeOptions.addArguments("--remote-allow-origins=*");
                return new EdgeDriver(edgeOptions);

            case "FIREFOX":
                return new FirefoxDriver();

            case "FIREFOX_HEADLESS":
                firefoxOptions.addArguments("--headless");
                return new FirefoxDriver(firefoxOptions);

            default:
                throw new IllegalArgumentException("Browser not supported: " + BasePage.browser);
        }
    }
}

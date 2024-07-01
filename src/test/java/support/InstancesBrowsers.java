package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class InstancesBrowsers {
    
    public static WebDriver getInstanceOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        ChromeOptions chromeOptions = new ChromeOptions();

        switch (BasePage.browser.toUpperCase()) {
            case "CHROME":
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--window-size=1920x1080");
                return new ChromeDriver(chromeOptions);

            case "EDGE":
                edgeOptions.addArguments("headless");
                edgeOptions.addArguments("--window-size=1920x1080");
                return new EdgeDriver(edgeOptions);

            case "CHROME_HEADLESS":
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("--remote-allow-origins=*");
                chromeOptions.addArguments("--window-size=1920x1080");
                return new ChromeDriver(chromeOptions);

            case "EDGE_HEADLESS":
                edgeOptions.addArguments("headless");
                edgeOptions.addArguments("--window-size=1920x1080");
                return new EdgeDriver(edgeOptions);

            default:
                throw new IllegalArgumentException("Browser not supported: " + BasePage.browser);
        }
    }
}

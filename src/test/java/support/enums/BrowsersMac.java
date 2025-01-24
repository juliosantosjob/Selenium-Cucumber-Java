package support.enums;

public enum BrowsersMac {
    CHROME("webdriver.chrome.driver", "/usr/local/bin/chromedriver"),
    CHROME_HEADLESS("webdriver.chrome.driver", "/usr/local/bin/chromedriver"),
    FIREFOX("webdriver.gecko.driver", "/usr/local/bin/geckodriver"),
    EDGE("webdriver.edge.driver", "/usr/local/bin/msedgedriver"),
    EDGE_HEADLESS("webdriver.edge.driver", "/usr/local/bin/msedgedriver");

    private final String property;
    private final String path;

    BrowsersMac(String property, String path) {
        this.property = property;
        this.path = path;
    }

    public String getProperty() {
        return property;
    }

    public String getPath() {
        return path;
    }

    public static BrowsersMac getBrowsers(String browser) {
        try {
            return BrowsersMac.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Browser not recognized: " + browser);
        }
    }

    public static String getPropertyDriver(String propertyBrowser) {
        return BrowsersMac.getBrowsers(propertyBrowser)
                .getProperty();
    }

    public static String getPathDriver(String pathBrowser) {
        return BrowsersMac.getBrowsers(pathBrowser)
                .getPath();
    }
}

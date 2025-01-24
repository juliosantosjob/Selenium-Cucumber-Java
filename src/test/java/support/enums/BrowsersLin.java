package support.enums;

public enum BrowsersLin {
    CHROME("webdriver.chrome.driver", "/usr/local/bin/chromedriver"),
    CHROME_HEADLESS("webdriver.chrome.driver", "/usr/local/bin/chromedriver"),
    EDGE("webdriver.edge.driver", "/usr/local/bin/msedgedriver"),
    EDGE_HEADLESS("webdriver.edge.driver", "/usr/local/bin/msedgedriver");

    private final String property;
    private final String path;

    BrowsersLin(String property, String path) {
        this.property = property;
        this.path = path;
    }

    public String getProperty() {
        return property;
    }

    public String getPath() {
        return path;
    }

    public static BrowsersLin getBrowsers(String browser) {
        try {
            return BrowsersLin.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Browser not recognized: " + browser);
        }
    }

    public static String getPropertyDriver(String propertyBrowser) {
        return BrowsersLin.getBrowsers(propertyBrowser)
                .getProperty();
    }

    public static String getPathDriver(String pathBrowser) {
        return BrowsersLin.getBrowsers(pathBrowser)
                .getPath();
    }
}
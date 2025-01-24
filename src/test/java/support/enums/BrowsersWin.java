package support.enums;

public enum BrowsersWin {
    CHROME("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe"),
    CHROME_HEADLESS("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe"),
    EDGE("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe"),
    EDGE_HEADLESS("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");

    private final String property;
    private final String path;

    BrowsersWin(String property, String path) {
        this.property = property;
        this.path = path;
    }

    public String getProperty() {
        return property;
    }

    public String getPath() {
        return path;
    }

    public static BrowsersWin getBrowsers(String browser) {
        try {
            return BrowsersWin.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Browser not recognized: " + browser);
        }
    }

    public static String getPropertyDriver(String propertyDrowser) {
        return BrowsersWin.getBrowsers(propertyDrowser)
                .getProperty().toString();
    }

    public static String getPathDriver(String pathDrowser) {
        return BrowsersWin.getBrowsers(pathDrowser)
                .getPath().toString();
    }
}
package enums;

public enum Browsers {
    CHROME("webdriver.chrome.driver", "drivers/chromedriver.exe"),
    CHROME_HEADLESS("webdriver.chrome.driver", "drivers/chromedriver.exe"),
    FIREFOX("webdriver.gecko.driver", "drivers/geckodriver.exe"),
    EDGE("webdriver.edge.driver", "drivers/msedgedriver.exe"),
    EDGE_HEADLESS("webdriver.edge.driver", "drivers/msedgedriver.exe");

    private final String property;
    private final String path;

    Browsers(String property, String path) {
        this.property = property;
        this.path = path;
    }

    public String getProperty() {
        return property;
    }

    public String getPath() {
        return path;
    }

    public static Browsers getBrowsers(String browser) {
        try {
            return Browsers.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Browser not recognized: " + browser);
        }
    }

    public static String getPropertyDriver(String propertyDrowser) {
        return Browsers.getBrowsers(propertyDrowser)
                .getProperty().toString();
    }

    public static String getPathDriver(String pathDrowser) {
        return Browsers.getBrowsers(pathDrowser)
                .getPath().toString();
    }
}
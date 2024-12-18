package support.enums;

public enum Browsers {
    CHROME("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe"),
    CHROME_HEADLESS("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe"),
    FIREFOX("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe"),
    EDGE("webdriver.edge.driver", "src/test/resourcesdrivers/msedgedriver.exe"),
    EDGE_HEADLESS("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");

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
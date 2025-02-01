package support.enums;

public enum TypeDrivers {
    CHROME("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe", "/usr/local/bin/chromedriver", "/usr/local/bin/chromedriver"),
    CHROME_HEADLESS("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe", "/usr/local/bin/chromedriver", "/usr/local/bin/chromedriver"),
    EDGE("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe", "/usr/local/bin/msedgedriver", "/usr/local/bin/msedgedriver"),
    EDGE_HEADLESS("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe", "/usr/local/bin/msedgedriver", "/usr/local/bin/msedgedriver"),
    FIREFOX("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe", "/usr/local/bin/geckodriver", "/usr/local/bin/geckodriver"),
    FIREFOX_HEADLESS("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe", "/usr/local/bin/geckodriver", "/usr/local/bin/geckodriver");

    private final String property;
    private final String pathWindows;
    private final String pathLinux;
    private final String pathMac;

    TypeDrivers(String property, String pathWindows, String pathLinux, String pathMac) {
        this.property = property;
        this.pathWindows = pathWindows;
        this.pathLinux = pathLinux;
        this.pathMac = pathMac;
    }

    public String getProperty() {
        return property;
    }

    public String getPathWindows() {
        return pathWindows;
    }

    public String getPathLinux() {
        return pathLinux;
    }

    public String getPathMac() {
        return pathMac;
    }

    public static TypeDrivers getBrowser(String browser) {
        try {
            return TypeDrivers.valueOf(browser.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Browser not recognized: " + browser);
        }
    }

    public static String getPropertyDriver(String browser) {
        return TypeDrivers.getBrowser(browser).getProperty();
    }

    public static String getPathWinDriver(String browser) {
        return TypeDrivers.getBrowser(browser).getPathWindows().toString();
    }

    public static String getPathLinuxDriver(String browser) {
        return TypeDrivers.getBrowser(browser).getPathLinux().toString();
    }

    public static String getPathMacDriver(String browser) {
        return TypeDrivers.getBrowser(browser).getPathMac().toString();
    }

    public static String getDriverPathBySystem(String browser) {
        String osName = System.getProperty("os.name").toLowerCase();

        if (osName.contains("win")) {
            return TypeDrivers.getPathWinDriver(browser);
        } else if (osName.contains("nix") || osName.contains("nux")) {
            return TypeDrivers.getPathLinuxDriver(browser);
        } else if (osName.contains("mac")) {
            return TypeDrivers.getPathMacDriver(browser);
        } else {
            throw new UnsupportedOperationException("Operating system not supported: " + osName);
        }
    }
}
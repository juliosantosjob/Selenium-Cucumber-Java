package support;

import java.time.Duration;

import static environments.setup.Env.env;
import static java.lang.System.getProperty;

public class BeforwardRunning extends DriverDefinition {
    private static String getEnv = getProperty("ENV");

    private static String urlBase() {
        if (getEnv == null)
            getEnv = "hmg";

        String getUrl;
        switch (getEnv) {
            case "hmg":
                getUrl = env().getEnv("URL_HOM");
                break;
            case "stg":
                getUrl = env().getEnv("URL_STG");
                break;
            case "hmg-actions":
                getUrl = System.getenv("URL_HOM");
                break;
            case "stg-actions":
                getUrl = System.getenv("URL_STG");
                break;
            default:
                throw new IllegalArgumentException("Invalid environment argument!");
        }
        return getUrl;
    }

    public static void addSettings() {
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(urlBase());
        }
    }
}
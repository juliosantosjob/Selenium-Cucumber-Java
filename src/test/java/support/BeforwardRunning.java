package support;

import java.time.Duration;

import static env.setup.Envs.env;
import static java.lang.System.getProperty;

public class BeforwardRunning extends DriverDefinition {
    private static String getEnv = getProperty("ENV");
    private static String baseUrl;

    private static String urlBase() {
        if (getEnv == null)
            getEnv = "hmg";

        switch (getEnv) {
            case "hmg":
                baseUrl = env().getEnv("URL_HOM");
                break;
            case "stg":
                baseUrl = env().getEnv("URL_STG");
                break;
            case "hmg-actions":
                baseUrl = System.getenv("URL_HOM");
                break;
            case "stg-actions":
                baseUrl = System.getenv("URL_STG");
                break;
            default:
                throw new IllegalArgumentException("Invalid environment argument!");
        }
        return baseUrl;
    }

    public static void addSettings() {
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(urlBase());
        }
    }
}
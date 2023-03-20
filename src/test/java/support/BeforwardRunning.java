package support;

import java.time.Duration;

import static environments.setup.Env.env;
import static java.lang.System.getProperty;

public class BeforwardRunning extends DriverDefinition {
    private String getEnv = getProperty("ENV");
    private String getUrl;

    public static BeforwardRunning beforwardRunning() {
        return new BeforwardRunning();
    }

    private String urlBase() {
        if (getEnv == null)
            getEnv = "hmg";

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

    public void addSettings() {
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(urlBase());
        }
    }
}
package support;

import java.time.Duration;

import static environments.setup.Env.env;
import static java.lang.System.getProperty;

public class BeforwardRunning extends DriverDefinition {
    static String getEnv = getProperty("ENV");
    static String getUrl;

    public static BeforwardRunning beforwardRunning() {
        return new BeforwardRunning();
    }

    public String urlBase() {
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
                throw new IllegalArgumentException("Invalid Environments!");
        }
        return getUrl;
    }

    public void addSettings() {
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get(urlBase());
        }
    }
}
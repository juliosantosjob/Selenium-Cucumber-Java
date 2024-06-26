package support;

import static env.setup.Envs.env;
import static java.lang.System.getProperty;

public class SetURL extends DriverDefinition {
    private static String getEnv = getProperty("ENV");
    private static String baseUrl;

    public static String urlBase() {
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
}
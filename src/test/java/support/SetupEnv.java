package support;

import env.setup.Envs;

public class SetupEnv {
    public static String environment = System.getProperty("ENV", "HMG");

    public static String getURLByEnvironment() {
        switch (environment) {
            case "HMG":
                return Envs.getEnv("URL_HOM");
            case "STG":
                return Envs.getEnv("URL_STG");
            case "HMG-CLOUD":
                return System.getenv("URL_HOM");
            case "STG-CLOUD":
                return System.getenv("URL_STG");
            default:
                throw new IllegalArgumentException("Invalid environment " + environment + " argument!");
        }
    }
}
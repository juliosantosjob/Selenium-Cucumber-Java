package support;

import static java.lang.System.getProperty;

import env.setup.Envs;

public class SetupEnv {
    private static final String ENVIROMENTS = getProperty("ENV", "URL_HOM");

    public static String getURLforEnv() {
        switch (ENVIROMENTS) {
            case "HMG":
                return Envs.getEnv("URL_HOM");
            case "STG":
                return Envs.getEnv("URL_STG");
            case "HMG-CLOUD":
                return System.getenv("URL_HOM");
            case "STG-CLOUD":
                return System.getenv("URL_STG");
            default:
                throw new IllegalArgumentException("Invalid environment " + ENVIROMENTS + " argument!");
        }
    }
}
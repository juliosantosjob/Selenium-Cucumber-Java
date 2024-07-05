package support;

import static java.lang.System.getProperty;

import env.setup.Envs;

public class SetupEnv {
    private static String envParam = getProperty("ENV", "HMG");

    public static SetupEnv setupEnv() {
        return new SetupEnv();
    }

    public String setBaseUrl() {
        switch (envParam) {
            case "HMG":
                return Envs.getEnv("URL_HOM");
            case "STG":
                return Envs.getEnv("URL_STG");
            case "HMG-CLOUD":
                return System.getenv("URL_HOM");
            case "STG-CLOUD":
                return System.getenv("URL_STG");
            default:
                throw new IllegalArgumentException("Invalid environment " + envParam + " argument!");
        }
    }
}
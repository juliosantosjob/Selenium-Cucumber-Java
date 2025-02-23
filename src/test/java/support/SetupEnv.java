package support;

import env.setup.Envs;

public class SetupEnv {

    public static String getURLByEnvironment(String environment) {
        String url = null;

        switch (environment) {
            case "HMG":
                url = (environment == null || environment.isEmpty()) ? System.getenv("URL_HOM") : Envs.getEnv("URL_HOM");
                break;
            case "STG":
                url = (environment == null || environment.isEmpty()) ? System.getenv("URL_STG") : Envs.getEnv("URL_STG");
                break;
            default:
                throw new IllegalArgumentException("Invalid environment: " + environment);
        }

        if (url == null) {
            throw new RuntimeException("URL not found for environment: " + environment);
        }

        return url;
    }
}
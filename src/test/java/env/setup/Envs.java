package env.setup;

import java.io.FileInputStream;
import java.util.Properties;

public class Envs {
    private static String PATH_PROP = "/src/test/java/env/resources/env.properties";
    private static String LOAD_PATH = System.getProperty("user.dir") + PATH_PROP;
    private static Properties prop = new Properties();

    private static Properties loadProp() {
        try {
            prop.load(new FileInputStream(LOAD_PATH));
        } catch (Exception e) {
            System.out.println("**** WARNING: Missing env.properties. Create the file and add base URL on key \"HMG\"! **** " + e);
        }
        return prop;
    }

    public static String getEnv(String env) {
        return loadProp().getProperty(env);
    }
}
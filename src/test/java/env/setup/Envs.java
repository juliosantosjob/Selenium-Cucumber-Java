package env.setup;

import java.io.FileInputStream;
import java.util.Properties;

public class Envs {
    private static String PATH_PROJECT = System.getProperty("user.dir");
    private static String PATH_PROP = "/src/test/java/env/resources/env.properties";
    private static String LOAD_PATH = PATH_PROJECT + PATH_PROP;
    private static Properties prop;

    private static Properties loadProp() {
        try {
            Envs.prop = new Properties();
            Envs.prop.load(new FileInputStream(LOAD_PATH));

        } catch (Exception e) {
            System.out.println("**** WARNING: Missing env.properties. Add base URL! **** " + e);
        }
        return Envs.prop;
    }

    public static String getEnv(String env) {
        return Envs.loadProp().getProperty(env);
    }
    
}
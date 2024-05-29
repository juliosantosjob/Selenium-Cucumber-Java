package env.setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.out;

public class Envs {
    private Properties prop = new Properties();

    public static Envs env() {
        return new Envs();
    }

    private Properties loadProp() {
        try {
            String pathProject = System.getProperty("user.dir");
            InputStream input = new FileInputStream(
                    pathProject + "/src/test/java/env/resources/env.properties");
            prop.load(input);
        } catch (Exception e) {
            out.println("**** WARNING: Unable to load data mass properties file, " +
                    "Create the env.properties file and enter the project base url! **** " + e);
        }
        return prop;
    }

    public String getEnv(String env) {
        return loadProp().getProperty(env);
    }
}
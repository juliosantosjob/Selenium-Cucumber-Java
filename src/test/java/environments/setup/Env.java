package environments.setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.out;

public class Env {
    static Properties prop = new Properties();

    public static Env env() {
        return new Env();
    }

    private static Properties loadProp() {
        try {
            String pathProject = System.getProperty("user.dir");
            InputStream input = new FileInputStream(pathProject + "/src/test/java/environments/resources/Env.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Unable to load data mass properties file!");
        }
        return prop;
    }
    public String getEnv(String env) {
        return loadProp().getProperty(env);
    }
}
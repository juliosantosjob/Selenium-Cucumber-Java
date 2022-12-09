package environments.setup;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.out;

public class DataMass {
    static Properties prop = new Properties();

    public static DataMass dataMass() {
        return new DataMass();
    }

    private static Properties loadProp() {
        try {
            String pathProject = System.getProperty("user.dir");
            InputStream input = new FileInputStream(pathProject + "/src/test/dataMass.properties");
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            out.println("Unable to load data mass properties file!");
        }
        return prop;
    }
    public String getData(String mass) {
        return loadProp().getProperty(mass);
    }
}
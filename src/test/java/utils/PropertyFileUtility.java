package utils;
/*
 * This class contains to read data from properties file
 *
 * @Author Piyal
 * */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
    public String getPropertyFileData(String key) throws IOException {
        FileInputStream fis = new FileInputStream("src/test/resources/Config.properties");
        Properties probj = new Properties();
        probj.load(fis);
        String val = probj.getProperty(key);
        return val;
    }
}

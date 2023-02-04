package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader extends BaseClass {
    static Properties properties;
    /**
     * This method will locate and prepare (load) the Properties file
     * @param filePath specify file path/location here
     */
    public static void loadProperties(String filePath){

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getProperties(String key){
        return properties.getProperty(key);
    }
}

package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLib {

    public static String getKeyFromPropertyFile(String strFilePath, String strKey){

        Properties objProp = null;
        try{
            InputStream objInput = new FileInputStream(strFilePath);
            objProp = new Properties();
            objProp.load(objInput);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return objProp.getProperty(strKey);
    }
}

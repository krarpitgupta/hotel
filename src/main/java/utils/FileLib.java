package utils;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class FileLib {

    /**+
     * It will generate CSV File and Save it in testresult folder
     * @param strFileName : Specify name of file with extension
     * @param objMap : Denotes the Map which data to write in CSV
     */
    public void generateCsvFile(String strFileName, HashMap<String,String> objMap) {

        String strFilePath = System.getProperty("user.dir") + "/src/test/testresult/" + strFileName;

        try{
            FileWriter objFileWriter = new FileWriter(strFilePath, false);
            for(Map.Entry m: objMap.entrySet()){
                objFileWriter.write(m.getKey() + "");
                objFileWriter.write(",");
                objFileWriter.write(m.getValue() + "");
                objFileWriter.write("\r\n");
            }
            objFileWriter.close();
        }
        catch(Exception e){
            System.out.println("Exception in generateCsvFile, Stack Trace is : ");
            e.printStackTrace();
        }
    }


}

package hotelsearch;

import base.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HotelSearchPage;
import utils.DateLib;
import utils.FileLib;
import utils.PropertyLib;
import java.util.HashMap;

public class SearchTest extends BaseTest {

    DateLib objDate;
    FileLib objFile;

    @BeforeTest
    public void initialize(){
        objDate = new DateLib();
        objFile = new FileLib();
    }

    @Test
    public void getListOfHotel() {

        String strDataFilePath, strDestination, strFileName, strCheckInDate, strCheckOutDate;
        int iRating, iResult;

        strDataFilePath = System.getProperty("user.dir") + "/src/test/data/searchData.properties";
        strDestination = PropertyLib.getKeyFromPropertyFile(strDataFilePath,"DESTINATION");
        strFileName = PropertyLib.getKeyFromPropertyFile(strDataFilePath,"RESULT_FILE");
        strCheckInDate = objDate.calculateCheckInDate();
        strCheckOutDate = objDate.calculateCheckOutDate();
        iRating = Integer.parseInt(PropertyLib.getKeyFromPropertyFile(strDataFilePath,"REQ_RATING"));
        iResult = Integer.parseInt(PropertyLib.getKeyFromPropertyFile(strDataFilePath,"NO_RESULT"));

        HotelSearchPage searchPage = new HomePage(driver).searchHotel(strDestination, strCheckInDate, strCheckOutDate);
        searchPage.sortHotelInDescendingPriceRange();
        HashMap<String,String> reqResult = searchPage.findRequiredResult(iRating, iResult);
        objFile.generateCsvFile(strFileName, reqResult);
    }

}

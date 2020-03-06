package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ActionLib;
import utils.WaitLib;
import java.util.HashMap;
import java.util.List;

public class HotelSearchPage {

    private WebDriver driver;
    ActionLib objAction;
    WaitLib objWait;

    private By priceLink = By.xpath("//a[@data-menu='sort-submenu-price']");
    private By highToLowLink = By.xpath("//a[@data-option-id='opt_PRICE_HIGHEST_FIRST']");
    private By propertyGuestReviewLabel = By.cssSelector(".reviews-box.resp-module > strong");

    public HotelSearchPage(WebDriver driver){
        this.driver = driver;
        objAction = new ActionLib(driver);
        objWait = new WaitLib(driver);
    }

    public void clickPriceLink() {
        objAction.clickElement(priceLink);
    }

    public void clickHighToLowLink() {
        objAction.clickElement(highToLowLink);
    }

    public void sortHotelInDescendingPriceRange() {
        clickPriceLink();
        clickHighToLowLink();
        objWait.waitForElementUntilTextFound(priceLink, "Price (high to low)");
    }

    public HashMap<String,String> findRequiredResult(int iRating, int iNoResults) {
        int reqSize = iNoResults, reqElementFoundSize, startIndex = 0, endIndex, i, count = 0;
        float rating;
        String strHotelName, strHotelPrice;
        String strGuestRating[], strHotelNameXpath, strHotelPriceXpath;
        JavascriptExecutor objJse = (JavascriptExecutor)driver;
        List<WebElement> reqElements;
        HashMap<String,String> hotelDetails = new HashMap<String, String>();

        do{
            objJse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            reqElements = driver.findElements(propertyGuestReviewLabel);
            reqElementFoundSize = reqElements.size();
            endIndex = reqElementFoundSize;
            for(i = startIndex; i < endIndex; i++) {

                strGuestRating = reqElements.get(i).getText().split(" ");
                rating = Float.parseFloat(strGuestRating[strGuestRating.length-1]);

                if(rating >= iRating){
                    strHotelNameXpath = "//li[@class='hotel'][" + i + "]//h3[@class='p-name']";
                    strHotelPriceXpath = "//li[@class='hotel'][" + i + "]//a[@class='price-link']//strong";
                    List<WebElement> objPrice = driver.findElements(By.xpath(strHotelPriceXpath));
                    if(objPrice.size() == 0){
                        strHotelPriceXpath = "//li[@class='hotel'][" + i + "]//a[@class='price-link']//ins";
                    }
                    strHotelName = driver.findElement(By.xpath(strHotelNameXpath)).getText();
                    strHotelPrice = driver.findElement(By.xpath(strHotelPriceXpath)).getText();
                    //System.out.println("Guest Rating : " + rating + " Hotel Name : " + strHotelName + " Hotel Price : " + strHotelPrice);
                    if(count != reqSize){
                        hotelDetails.put(strHotelName.replace(",",""), strHotelPrice.replace(",","").replace("£",""));
                    }
                    count++;
                }
            }
            startIndex = endIndex;

        }while(count < reqSize);
        return hotelDetails;
    }



}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionLib;

public class HomePage {

    private WebDriver driver;
    ActionLib objAction;

    private By destinationField = By.id("qf-0q-destination");
    private By destinationSelect = By.cssSelector("tbody.autosuggest-city > tr > td");
    private By checkInField = By.id("qf-0q-localised-check-in");
    private By checkOutField = By.id("qf-0q-localised-check-out");
    private By closeCheckOutCal = By.cssSelector(".widget-overlay-close");
    private By searchButton = By.cssSelector(".cta-strong");

    public HomePage(WebDriver driver){
        this.driver = driver;
        objAction = new ActionLib(driver);
    }

    public void setDestination(String strDestination) {
        objAction.setValue(destinationField, strDestination);
    }

    public void selectDestination(){
        objAction.clickElement(destinationSelect);
    }

    public void setCheckIn(String strDate){
        objAction.setValue(checkInField, strDate);
    }

    public void setCheckOut(String strDate) {
        objAction.setValue(checkOutField, strDate);
    }

    public void closeCalendar() {
        objAction.clickElement(closeCheckOutCal);
    }

    public void clickSearchButton(){
        objAction.clickElement(searchButton);
    }

    public HotelSearchPage searchHotel(String strDestination, String strCheckInDate, String strCheckOutDate) {
        setDestination(strDestination);
        selectDestination();
        setCheckIn(strCheckInDate);
        setCheckOut(strCheckOutDate);
        closeCalendar();
        clickSearchButton();
        return new HotelSearchPage(driver);
    }

}
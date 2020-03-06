package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionLib {

    private WebDriver driver;
    WaitLib objWait;

    public ActionLib(WebDriver driver){
        this.driver = driver;
        objWait = new WaitLib(driver);
    }

    /**+
     * Description : It will click on WebElement
     * @param locator : Specify By Locator
     */
    public void clickElement(By locator){
        objWait.waitForElementBeforeClick(locator);
        driver.findElement(locator).click();
    }

    /**+
     * Description : It will Set Text on WebElement
     * @param locator : Specify By Locator
     * @param strValue : Specify Value
     */
    public void setValue(By locator, String strValue){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(strValue);
    }


}

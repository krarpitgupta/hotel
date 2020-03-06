package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitLib {

    private WebDriver driver;
    WebDriverWait wait;
    private String strWait = PropertyLib.getKeyFromPropertyFile(System.getProperty("user.dir") + "/src/test/globalConfig.properties","GLOBAL_WAIT");

    public WaitLib(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Integer.parseInt(strWait));
    }

    /**+
     * It will wait for element till it became clickable
     * @param element Specify Element
     * @return Required Element
     */
    public WebElement waitForElementBeforeClick(By element){
        WebElement reqElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        return reqElement;
    }

    /**+
     * It will wait until particular text found
     * @param element Specify Element
     * @param strText Text you are Searching for
     */
    public void waitForElementUntilTextFound(By element, String strText){
        wait.until(ExpectedConditions.textToBePresentInElementLocated(element, strText));
    }

}

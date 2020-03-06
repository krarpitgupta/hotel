package base;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.HomePage;
import utils.PropertyLib;

public class BaseTest {

    public WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver(getChromeOptions());
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void goHome(){
        String strURL = PropertyLib.getKeyFromPropertyFile(System.getProperty("user.dir") + "/src/test/globalConfig.properties","APP_URL");
        driver.get(strURL);
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

}
package wm;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import setup.DriverSetup;
import setup.Utils;

/**
 * Created by s.lugovskiy on 06.03.2015 10:41.
 */
public abstract class BaseTest {

    private WebDriver driver;
    private Utils utils;

    BaseTest(){
        driver = DriverSetup.getDriver();
        utils = new Utils(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Utils getUtils() {
        return utils;
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}

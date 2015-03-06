package wm;


import org.junit.BeforeClass;
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
    private DriverSetup setup;

    @BeforeClass
    public void init(){
        setup = new DriverSetup();
        driver = setup.getDriver();
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
        driver.quit();
    }
}

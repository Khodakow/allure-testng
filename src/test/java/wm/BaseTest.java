package wm;


import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import setup.DriverSetup;
import setup.Utils;

import java.lang.reflect.Method;

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

    @BeforeMethod
    public void logMethodName(Method method){
        System.out.println("==================================================================");
        System.out.println("TEST STARTED: "+method.getName());
    }

    @AfterMethod
    public void logMethodNameAfter(Method method){
        System.out.println("TEST ENDED: "+method.getName());
        System.out.println("==================================================================");
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

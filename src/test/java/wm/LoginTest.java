package wm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.dashboard.DashboardPage;
import pages.front.FrontPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.DriverSetup;
import setup.Utils;

@Test@Listeners(AllureOnFailListener.class)
public class LoginTest {


    private Utils utils;
    private FrontPage front;
    private DashboardPage dashboard;
    private Webmaster wm;

    @BeforeClass
    public void setUp(){
        WebDriver driver = DriverSetup.getDriver("firefox");
        utils = new Utils(driver);
        front = new FrontPage(driver);
        dashboard = new DashboardPage(driver);
        wm = new Webmaster();
        utils.openMainPage();
    }

    @Test
    @Severity(value = SeverityLevel.CRITICAL)
    @Features("Webmaster Authorization")
    @Stories("correct credentials")
    public void loginTest(){
        front.login(wm);
        dashboard.isOnDashboard();
    }



    @AfterClass
    public void quit(){
        utils.close();
    }





}

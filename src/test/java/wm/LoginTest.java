package wm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.dashboard.DashboardPage;
import pages.front.FrontPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.listener.AllureOnFailListener;

@Test
@Listeners(AllureOnFailListener.class)
public class LoginTest extends BaseTest {



    private FrontPage front;
    private DashboardPage dashboard;
    private Webmaster wm;
    private Utils utils;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        super.init();
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new DashboardPage(driver);
        wm = new Webmaster();
        utils.openMainPage();
        front.login(wm);
    }

    @BeforeMethod
    public void waitPageLoad(){
        dashboard.waitSpinner();
    }


    @Test
    @Stories("авторизация вма с правильными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    public void loginTest() throws InterruptedException {
        dashboard.isOnDashboard();
        dashboard.waitSpinner();
    }

    @Test
    @Stories("проверка ссылки из блока Топовые предложения")
    @Severity(value = SeverityLevel.CRITICAL)
    public void hotOfferTest(){
        dashboard.stopSlider();
    }


    @AfterMethod
    public void goBack(){
        dashboard.clickLogo();
    }



}

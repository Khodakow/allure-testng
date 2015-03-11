package wm.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.dashboard.DashboardPage;
import pages.front.FrontPage;
import pages.offercard.OfferCardPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.BaseTest;

@Test
@Features("Авторизация ВМа")
//@Listeners(AllureOnFailListener.class)
public class LoginTest extends BaseTest {



    private FrontPage front;
    private DashboardPage dashboard;
    private OfferCardPage card;
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
        card = new OfferCardPage(driver);
        wm = new Webmaster();
        utils.openMainPage();
        front.login(wm);
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
        dashboard.isOnDashboard();
        dashboard.stopSlider();
        dashboard.goToFirstHotOffer();
        card.isOnDashboardTab();
    }


    @AfterMethod
    public void goBack(){
        dashboard.clickLogo();
    }



}

package wm.carcas;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.wm.dashboard.DashboardPage;
import pages.wm.front.FrontPage;
import pages.wm.offercard.OfferCardPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Ошибки в консоли")
//@Listeners(AllureOnFailListener.class)
public class CarcasMainPageTest extends BaseTest {



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

    }



    @Test
    @Stories(value = "проверка консоли браузера на наличие ошибок на главной")
    @Severity(value = SeverityLevel.NORMAL)
    public void carcasMainPageTest() throws InterruptedException {

       utils.checkConsoleLog();


    }







}

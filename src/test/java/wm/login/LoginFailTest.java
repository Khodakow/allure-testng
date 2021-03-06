package wm.login;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.front.FrontPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.listener.AllureOnFailListener;

@Test
@Features("Авторизация ВМа")
@Listeners(AllureOnFailListener.class)
public class LoginFailTest extends BaseTest {

    private FrontPage front;
    private WmDashboardPage dashboard;
    private Webmaster wm;
    private Utils utils;
    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        super.init();
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);
        wm = new Webmaster("webmaster","azaza");
        utils.openMainPage();
    }

    @Test
    @Stories("авторизация вма с неправильными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    public void wrongLoginTest() throws InterruptedException {
        front.login(wm);
        dashboard.isNotOnDashboard();
    }








}

package mgr;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mgr.dashboard.DashboardPage;
import pages.mgr.users.UsersPage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import roles.Manager;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Финансы")
public class FinanceTest extends BaseTest {



    private FrontPage front;
    private Manager mgr;
    private Utils utils;
    private WebDriver driver;
    private Spinners spin;
    private DashboardPage dashboard;
    private UsersPage users;

    @BeforeClass
    public void setUp(){
        super.init();
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        mgr = new Manager();
        spin = new Spinners(driver);
        dashboard = new DashboardPage(driver);
        users = new UsersPage(driver);
        utils.openMainPage();
        front.login(mgr);
    }


    @Test
    @Stories("Сравнение показателей финансовой сводной и начислений и выплат")
    @Severity(value = SeverityLevel.CRITICAL)
    public void financeTest() throws InterruptedException {
        dashboard.waitDashboard();
        dashboard.goToUsers();
        users.setBalance("100","");
        users.setHold("3","3");
        users.clickSearch();
        users.clickFirstSudo();




    }


}

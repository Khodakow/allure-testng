package mgr;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mgr.dashboard.MgrDashboardPage;
import pages.mgr.users.UsersPage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.LeftMenuPage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.office.payments.PaymentsPage;
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
    private MgrDashboardPage mgrdashboard;
    private UsersPage users;
    private WmDashboardPage wmdashboard;
    private PaymentsPage payments;
    private LeftMenuPage leftmenu;
    @BeforeClass
    public void setUp(){
        super.init();
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        mgr = new Manager();
        spin = new Spinners(driver);
        mgrdashboard = new MgrDashboardPage(driver);
        wmdashboard = new WmDashboardPage(driver);
        payments = new PaymentsPage(driver);
        leftmenu = new LeftMenuPage(driver);
        users = new UsersPage(driver);
        utils.openMainPage();
        front.login(mgr);

    }


    @Test
    @Stories("Сравнение показателей финансовой сводной и начислений и выплат")
    @Severity(value = SeverityLevel.CRITICAL)
    public void financeTest() throws InterruptedException {
        mgrdashboard.waitDashboard();
        mgrdashboard.goToUsers();
        users.setBalance("100","");
        users.setHold("3","3");
        users.clickSearch();
        users.clickFirstSudo();
        Float i = wmdashboard.getHoldCommision();
        leftmenu.clickPayments();
        Float j = payments.getHoldCommision();
        payments.checkValuesAreEquals(i,j);





    }


}

package pages.dashboard;

import org.openqa.selenium.WebDriver;
import pages.Spinners;
import pages.dashboard.elements.Graph;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by s.lugovskiy on 04.03.2015 10:59.
 */
public class DashboardPage {

    private Graph graph;
    private WebDriver driver;
    private Spinners spin;

    public DashboardPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
    }

    @Step
    public void isOnDashboard(){
        assertTrue(driver.getCurrentUrl().contains("office/dashboard"));
    }

    @Step
    public void isNotOnDashboard(){
        assertFalse(driver.getCurrentUrl().contains("office/dashboard"));
    }

    @Step
    public void waitSpinner(){
        spin.waitSpinner();
    }







}

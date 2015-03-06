package pages.dashboard;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.Spinners;
import pages.dashboard.elements.HotOffers;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by s.lugovskiy on 04.03.2015 10:59.
 */
public class DashboardPage extends BasePage{


    private WebDriver driver;
    private Spinners spin;
    private HotOffers hot;

    public DashboardPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
    }

    @FindBy(xpath = "//a[contains(@class,'logotype')]")
    private Link logo;

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

    @Step("Останавливаем слайдер через джаваскрипт")
    public void stopSlider() {
       evaluateJavascript("_('#hotOffersSlider').pause(true)");
    }


    @Step
    public void clickLogo(){
        logo.click();
        spin.waitSpinner();
    }


    @Step
    public void goToFirstHotOffer(){
        hot.clickFirstSwitch();
        spin.waitSpinner();
    }







}

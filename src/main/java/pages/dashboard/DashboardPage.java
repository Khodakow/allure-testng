package pages.dashboard;

import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import pages.Spinners;
import pages.WebElementHelper;
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
    private WebElementHelper helper;

    public DashboardPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }

    @FindBy(xpath = "//a[contains(@class,'logotype')]")
    private Link logo;

    @Step("ВМ должен быть на сводной")
    public void isOnDashboard(){
        helper.fluentWait(By.xpath("//h2[contains(@class,'_overview_text')]"));
        helper.fluentWait(By.xpath("//img[@class='offer-screen']"));
        assertTrue(driver.getCurrentUrl().contains("office/dashboard"));
    }

    @Step("не должен быть на сводной")
    public void isNotOnDashboard(){
        assertFalse(driver.getCurrentUrl().contains("office/dashboard"));
    }

    @Step("ожидание загрузки")
    public void waitSpinner(){
        spin.waitSpinner();
    }

    @Step("останавливаем слайдер через джаваскрипт")
    public void stopSlider() {
        evaluateJavascript("_('#hotOffersSlider').pause(true)");
    }


    @Step("клик лого")
    public void clickLogo(){
        logo.click();
        spin.waitSpinner();
    }


    @Step("клик по первому офферу из топ предложений")
    public void goToFirstHotOffer(){
        hot.clickFirstSwitch();
        hot.clickTopOffer();
        spin.waitSpinner();
    }







}

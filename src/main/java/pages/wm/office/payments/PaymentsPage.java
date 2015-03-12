package pages.wm.office.payments;

import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.office.dashboard.elements.HotOffers;
import pages.wm.office.elements.LeftMenu;
import pages.wm.office.payments.elements.PayoutInfo;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class PaymentsPage extends BasePage{
    private WebDriver driver;
    private Spinners spin;
    private HotOffers hot;
    private PayoutInfo payout;
    private WebElementHelper helper;
    private LeftMenu leftmenu;


    public PaymentsPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }





    @Step("Получение данных c вкладки финансы и выплаты")
    public Float getHoldCommision(){
        return payout.getCommision();
    }
}

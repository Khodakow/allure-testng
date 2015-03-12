package pages.wm.office.payments.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by a.hodakov on 11.03.2015.
 */
@Name("Таблица выплат")
@Block(@FindBy(id = "table_wm.payout_info"))
public class PayoutInfo extends HtmlElement{

    @FindBy(xpath = "//td[@class='hold_amount']")
    private WebElement holdamount;
    @FindBy(xpath = "//td[@class='on_adv_payment']")
    private WebElement onadvpayment;

    @Step
    @Attachment
    public float getCommision() {

        Float floatholdamount = Float.parseFloat(holdamount.getText().replaceAll("'",""));
        Float floatonadvpayment = Float.parseFloat(onadvpayment.getText().replaceAll("'",""));
        return floatholdamount+floatonadvpayment;
    }

}

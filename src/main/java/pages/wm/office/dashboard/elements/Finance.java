package pages.wm.office.dashboard.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Финансовая сводная")
@Block(@FindBy(id = "mainSummary"))
public class Finance extends HtmlElement {

    @FindBy(xpath = ".//div[2]/div[11]/div[2]/nobr/div")
    private WebElement commision;

    @Step
    @Attachment
    public float getCommision() {
        return Float.parseFloat(commision.getText().replaceAll("’",""));
    }
}

package pages.dashboard.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Top Dashboard Graph")
@Block(@FindBy(id = "section_graph"))
public class Graph extends HtmlElement {

    @Step
    public boolean topGraphIsVisible(){
        return this.isDisplayed();
    }

}

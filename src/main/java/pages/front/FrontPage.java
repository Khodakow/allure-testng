package pages.front;

import org.openqa.selenium.WebDriver;
import pages.front.elements.PopupLoginForm;
import roles.User;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by s.lugovskiy on 04.03.2015 10:59.
 */
public class FrontPage {

    private PopupLoginForm popupLoginForm;

    public FrontPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
    }

    @Step
    public void login(User user){
        popupLoginForm.fillLoginForm(user.getName(), user.getPassword());
        popupLoginForm.submitForm();
    }





}

package pages.front;

import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.front.elements.PopupLoginForm;
import roles.User;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by s.lugovskiy on 04.03.2015 10:59.
 */
public class FrontPage {

    private PopupLoginForm popupLoginForm;
    private WebElementHelper helper;

    public FrontPage(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        helper = new WebElementHelper(driver);
    }

    @Step("заполняем форму авторизации в попапе")
    public void login(User user){
        popupLoginForm.fillLoginForm(user.getName(), user.getPassword());
        popupLoginForm.submitForm();
    }
}

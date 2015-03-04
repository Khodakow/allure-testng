package pages.front;

import org.openqa.selenium.WebDriver;
import pages.front.elements.PopupLoginForm;
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

    @Step(value = "авторизация")
    public void login(String user,String password){
        popupLoginForm.fillLoginForm(user,password);
        popupLoginForm.submitForm();
    }





}

package pages.wm.front.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by s.lugovskiy on 04.03.2015 11:15.
 */
@Name("Popup login form")
@Block(@FindBy(xpath = "//div[@id='popup-login']"))
public class PopupLoginForm extends HtmlElement {


    @Name("enter button")
    @FindBy(xpath="//a[@id='popup-login-link' and ancestor::div[@class='link relative' and ancestor::li[@class='login']]]")
    private Link enter;

    @Name("login popup input")
    @FindBy(name = "nick")
    private TextInput loginInput;

    @Name("password popup input")
    @FindBy(name = "passwd")
    private TextInput passwordInput;

    @Name("submit")
    @FindBy(className = "submit")
    private WebElement submit;


    @Step("заполняем форму авторизации")
    public void fillLoginForm(String user,String password){
        enter.click();
        loginInput.sendKeys(user);
        passwordInput.sendKeys(password);
    }

    @Step("отправляем форму")
    public void submitForm(){
        submit.click();
    }



}

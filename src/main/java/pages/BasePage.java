package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by s.lugovskiy on 06.03.2015 16:01.
 */
public class BasePage{

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public Object  evaluateJavascript(String script){
        return ((JavascriptExecutor)driver).executeScript(script);
    }
}

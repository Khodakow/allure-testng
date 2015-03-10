package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by s.lugovskiy on 06.03.2015 16:01.
 */
public class BasePage{

    private WebDriver driver;
    private String baseUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.baseUrl = System.getProperty("baseUrl");
    }

    @Step
    public Object  evaluateJavascript(String script){
        return ((JavascriptExecutor)driver).executeScript(script);
    }


    @Step
    public void goToSection(String url) {
        String testUrl = baseUrl + url;
        String newtestUrl = testUrl.replaceAll("//","/");
        driver.get(newtestUrl);
    }


}

package pages.wm;

import net.thucydides.core.annotations.findby.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by s.lugovskiy on 06.03.2015 16:01.
 */
public class BasePage{

    private WebDriver driver;
    private String baseUrl;
    private WebElementHelper helper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.baseUrl = System.getProperty("baseUrl");
        this.helper = new WebElementHelper(driver);
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


    @Step("ждем загрузку сводных показателей")
    public void waitDashboard(){
        System.out.println("waiting for (//h2[contains(@class,'_overview_text')])[1]");
        helper.fluentWait(By.xpath("(//h2[contains(@class,'_overview_text')])[1]"));
    }


}

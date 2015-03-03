package pages;

import com.applitools.eyes.Eyes;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;

/**
 * Created by s.lugovskiy on 27.11.2014 13:25.
 */
public class Elements extends PageObject{
    private final String host;
    private WebDriver driver;
    private Eyes eyes;

    public Elements(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.host = System.getProperty("baseUrl");
    }
    public Elements(WebDriver driver, Eyes eyes) {
        super(driver);
        this.driver = driver;
        this.host = System.getProperty("baseUrl");
    }

    @FindBy(xpath = "//div[@id='multiselect-0']")
    private WebElement multi1;

    @FindBy(xpath = "//div[@id='multiselect-0']/div[@class='multiselect-popup']")
    private WebElement multi1Popup;



    @Step
    public void goToElementsPage(){
        String host = System.getProperty("baseUrl");
        driver.get(host);
    }

    @Step
    public void goToMultiselect(){
        driver.get(host+"controls/multiselect");
    }

    @Step
    public void checkFirstMultiselect() {
        assertTrue(multi1.isDisplayed());
    }

    @Step
    public void clickFirstMultiselect() {
        script("$('div[class*=\"multiselect-button\"]:eq(0)').click()");
        waitFor(multi1Popup);
        assertTrue(multi1Popup.isDisplayed());
    }


    @Step
    @Attachment
    public String waitFor(WebElement elem){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(elem));
        return elem.toString();
    }

    @Step
    public void script(String script){
        evaluateJavascript(script);
    }
}

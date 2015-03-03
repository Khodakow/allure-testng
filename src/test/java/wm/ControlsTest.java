package wm;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Elements;
import ru.yandex.qatools.allure.annotations.Attachment;
import setup.DriverSetup;
import setup.WebDriverSteps;

@Test
public class ControlsTest {


    private WebDriver driver;
    private WebDriverSteps steps;
    private Elements elements;


    @BeforeClass
    public void setUp(){
        this.driver = DriverSetup.getDriver("chrome");
        this.steps = new WebDriverSteps(driver);
        this.elements = new Elements(driver);
        steps.openMainPage();
        elements.goToMultiselect();
    }

    @Test
    public void firstMultiselectTest(){
        elements.checkFirstMultiselect();
        makeAttach();
    }

    @Test
    public void firstMultiselectClickTest(){
        elements.clickFirstMultiselect();
        makeAttach();
    }


    @AfterClass
    public void quit(){
        steps.quit();
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            makeAttach();
        }
    }

    @Attachment
    public byte[] makeAttach() {
        return steps.takeScreenShoot();
    }


}

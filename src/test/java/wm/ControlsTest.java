package wm;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Elements;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import setup.DriverSetup;
import setup.WebDriverSteps;

import static org.testng.Assert.assertTrue;

@Test@Listeners(AllureOnFailListener.class)
public class ControlsTest {


    private WebDriverSteps steps;
    private Elements elements;


    @BeforeClass
    public void setUp(){
        WebDriver driver = DriverSetup.getDriver("chrome");
        this.steps = new WebDriverSteps(driver);
        this.elements = new Elements(driver);
        steps.openMainPage();
        elements.goToMultiselect();
    }

    @Test
    @Features("Feature 1")
    @Stories("Story 1")
    public void test1(){
        assertTrue(true);
    }

    @Test
    @Features("Feature 2")
    @Stories("Story 1")
    public void test2(){
        elements.goToElementsPage();
    }

    @Test
    @Features("Feature 2")
    @Stories("Story 2")
    public void test3(){
        steps.openMainPage();
        assertTrue(false);
    }


    @AfterClass
    public void quit(){
        steps.quit();
    }





}

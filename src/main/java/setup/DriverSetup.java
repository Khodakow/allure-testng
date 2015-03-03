/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s.lugovskiy
 */
public class DriverSetup {
    private static String remoteUrl = System.getProperty("remoteUrl");


    @Step
    @Attachment
    public static WebDriver getDriver(String browser){
        WebDriver driver = null;
        DesiredCapabilities capabilities;
        switch (browser) {
            case "phantomjs":
                capabilities = DesiredCapabilities.phantomjs();
                break;
            case "chrome":
                capabilities = DesiredCapabilities.chrome();
                break;
            default:
                capabilities = DesiredCapabilities.firefox();
                break;
        }
        try {
            driver = new RemoteWebDriver(new URL(remoteUrl), capabilities);
        } catch (MalformedURLException ex) {
            Logger.getLogger(DriverSetup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return driver;
    }

}

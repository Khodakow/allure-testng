package pages;

import com.google.common.base.Predicate;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.concurrent.TimeUnit;


/**
 * Created by s.lugovskiy on 06.03.2015 13:14.
 */
public class Spinners extends HtmlElement{

    private WebDriver driver;

    public Spinners(WebDriver driver) {
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
    }

    private boolean checkOpacitySpinnerJquery(){
        boolean check;
        check = tableIsReady() && chartIsReady() && deltachartIsReady();
        return check;
    }

    private boolean checkSpinnerJquery(){
        boolean check = false;
        Long spinner;
        spinner = (Long)((JavascriptExecutor)driver).executeScript("return $('.spinner-icon').length");
        if(spinner == 0){check = false;}
        else {check = true;}
        return check;

    }

    private boolean tableIsReady(){
        boolean contextCheck = true;
        boolean cityCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        cityCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return typeof(CityAds) == 'undefined'");
        if(!contextCheck && !cityCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.table) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.table.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("table ready at ||||"+ driver.getCurrentUrl() +"|||| : "+check);
        return check;

    }

    private boolean mapIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.map) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.map.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("map ready: "+check);
        return check;
    }

    private boolean chartIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.chart) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.chart.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("chart ready: at ||||"+ driver.getCurrentUrl() +"|||| "+check);
        return check;
    }

    private boolean deltachartIsReady(){
        boolean contextCheck = true;
        boolean check = true;
        contextCheck = (Boolean)((JavascriptExecutor)driver).executeScript("return CityAds.context.current==null");
        if(!contextCheck){
            check =  (Boolean)((JavascriptExecutor)driver).executeScript("return typeof (CityAds.context.current.requesterInterface.requesters.delta_chart) == 'undefined';");
            if(!check){
                try {
                    int requestId = ((Long) this.evaluateJavascript("return CityAds.context.current.requesterInterface.requesters.delta_chart.req_id[0]")).intValue();
                    System.out.println("-------->>>>   Request ID = " + requestId);
                }
                catch(Exception e) {
                }
            }
        }
        System.out.println("delta chart ready: at"+ driver.getCurrentUrl() +" "+check);
        return check;
    }
    
    private Object  evaluateJavascript(String script){
        return ((JavascriptExecutor)driver).executeScript(script);
    }

    public void waitSpinner(){
        new FluentWait<WebDriver>(driver).
                withTimeout(160, TimeUnit.SECONDS).
                pollingEvery(500, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        System.out.println("small spinner at ||||"+ driver.getCurrentUrl() +"|||| ready: "+!checkSpinnerJquery());
                        return !checkSpinnerJquery();
                    }
                });


        new FluentWait<WebDriver>(driver).
                withTimeout(120, TimeUnit.SECONDS).
                pollingEvery(500, TimeUnit.MILLISECONDS).
                ignoring(NoSuchElementException.class).
                until(new Predicate<WebDriver>(){
                    public boolean apply(WebDriver driver){
                        return checkOpacitySpinnerJquery();
                    }
                });

    }
}

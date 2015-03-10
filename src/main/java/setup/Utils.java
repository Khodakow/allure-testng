package setup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.Augmenter;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.testng.Assert.assertFalse;


public class Utils {

    public WebDriver driver;
    public Utils(WebDriver driver) {
        this.driver = driver;
    }



    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenShoot() {
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            String nameScreenshot = getFileName(DataGenerator.getRandomNameWithDate());
            String path = getPath(nameScreenshot);
            File newScreen = new File(path);
            FileUtils.copyFile(screenshot, newScreen);
            System.out.println(newScreen);

            BufferedImage bImage = ImageIO.read(screenshot);
            byte[] imageInByteArray;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bImage, "png", baos);
                imageInByteArray = baos.toByteArray();
                baos.flush();
         
            return imageInByteArray;
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

     public void close() {
        String curUrl = driver.getCurrentUrl();
        driver.quit();
       }

    @Step("переход на главную страницу приложения")
    @Attachment
    public String openMainPage(){
        String host = System.getProperty("baseUrl");
        driver.get(host);
        driver.manage().window().maximize();
        return driver.getCurrentUrl();
    }

    private static String getFileName(String nameTest) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
        Date date = new Date();
        return dateFormat.format(date) + "_" + nameTest + ".png";
    }

    private static String getPath(String nameTest) throws IOException {
        File directory = new File(".");
        return directory.getCanonicalPath() + "/target/allure-results/" + getFileName(nameTest);
    }

    @Step("Проверяем логи консоли браузера")
    public void checkConsoleLog(){
        List<String> l = get_all_logs();
        check_array_has_errors(l);

    }

    @Step
    public List<String> get_all_logs(){
        List<String> l = new ArrayList<String>();
        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            System.out.println("Console output: "+logEntry.getMessage());
            l.add(logEntry.getMessage());
        }
        return l;
    }

    @Step
    public void check_array_has_errors(List<String> list){
        assertFalse(list.size() > 0,"Проверяем что в логах консоли нет сообщений уровня SEVERE " + list);
    }

}

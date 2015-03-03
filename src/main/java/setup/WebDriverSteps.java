package setup;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverSteps {

    public static WebDriver driver;
    public WebDriverSteps(WebDriver driver) {
        WebDriverSteps.driver = driver;
    }



    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] takeScreenShoot() {
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
            Logger.getLogger(WebDriverSteps.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }


    public void quit() {
        driver.quit();
    }

    @Step
    public void openMainPage(){
        String host = System.getProperty("baseUrl");
        driver.get(host);
        driver.manage().window().maximize();
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

}

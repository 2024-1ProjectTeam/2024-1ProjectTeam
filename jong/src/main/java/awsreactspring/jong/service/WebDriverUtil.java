package awsreactspring.jong.service;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

@Component
public class WebDriverUtil {
    private static String WebDriverId = "webdriver.chrome.driver";
    private static String WebDriverPath = "C:/chromedriver-win64/chromedriver-win64/chromedriver.exe";

    public static WebDriver getChromeDriver() {
        if(ObjectUtils.isEmpty(System.getProperty(WebDriverId))) {
            System.setProperty(WebDriverId, WebDriverPath);
        }

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=ko");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(chromeOptions);

        return driver;
    }

    public static void quit(WebDriver driver){
        if(!ObjectUtils.isEmpty(driver)){
            driver.quit();
        }
    }

    public static void close(WebDriver driver){
        if(!ObjectUtils.isEmpty(driver)){
            driver.close();
        }
    }
}

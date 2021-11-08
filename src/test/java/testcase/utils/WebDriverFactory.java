package testcase.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {   // class coming utility class


    public static WebDriver getDriver(String browserType) { //method
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
        }else if (browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return  new FirefoxDriver();

        }else{
            System.out.println("Invalid Browser type " + browserType);
            return null;  // null means no obj
        }
    }
}
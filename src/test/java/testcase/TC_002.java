package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcase.utils.WebDriverFactory;

import java.util.Locale;

public class TC_002 {
    public static void main(String[] args) throws InterruptedException {

        /**
         * Practice website link: http://practice.cybertekschool.com/forgot_password
         * User story:
         * As a user, I want to re-set my password. Acceptance Criteria(AC):
         * 1. "Forgot Password" Header should be displayed on top of page
         * 2. There should be a text box / (email input box) beneath "E-mail" message
         * 3. "Retrieve Password" Button should be displayed under Text Box
         * 4. A tool tip should displaying "please Fill out this Field" message when user submit empty email
         * 5. A tool tip should displaying "please Match the require format" Message When User Submit invalid Email format -
         * Only one @ symbol and a valid email domain like .com, .net , .io .org
         * 6. "your Email has been Sent!" Should be displayed when user enters correct email format for a password Retrieval
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement checkHeader = driver.findElement(By.tagName("h2"));

        if (checkHeader.isDisplayed()){
            System.out.println("Pass, Header is displayed on top of page");
        }else{
            System.out.println("Fail,Header is not displayed on top of page ");
        }

        //2. There should be a text box / (email input box) beneath "E-mail" message

        WebElement email = driver.findElement(By.xpath("//label[@for='email']"));
             if (email.isDisplayed()){
                 System.out.println("Pass");
             }else{
                 System.out.println("Fail");
             }

       //3. "Retrieve Password" Button should be displayed under Text Box
           WebElement retrieveButton = driver.findElement(By.xpath("//button[@id='form_submit']"));

             System.out.println(retrieveButton.isDisplayed() ? "Pass, Retrieve Password button is displayed" :
                  "Fail, Retrieve Password button is not displayed");

        // 4. A tool tip should displaying "please Fill out this Field" message when user submit empty email

            WebElement emailEmpty = driver.findElement(By.xpath("//input[@type='text']"));
            emailEmpty.sendKeys("");
            retrieveButton.click();

            if (emailEmpty.isDisplayed()){
                System.out.println("Pass");
            }else{
                System.out.println("Fail");
            }

        //5. A tool tip should displaying "please Match the require format" Message When User Submit invalid Email format -
        //Only one @ symbol and a valid email domain like .com, .net , .io .org

        WebElement  mathRequire= driver.findElement(By.xpath("//input[@type='text']"));
        emailEmpty.sendKeys("leylaNajafzade");
        retrieveButton.click();

        if (mathRequire.isDisplayed()){
            System.out.println("Successfully");
        }else{
            System.out.println("Fail");
        }

        mathRequire.clear();
        Thread.sleep(2000);

       //6."your Email has been Sent!" Should be displayed when user enters correct email format for a password Retrieval

        WebElement sentEmail= driver.findElement(By.xpath("//input[@type='text']"));
        emailEmpty.sendKeys("leyla.necefzade@gmail.com");
        retrieveButton.click();

        WebElement message = driver.findElement(By.tagName("h4"));
        System.out.println("Message is:  " + message.getText());
        if (message.isDisplayed()){
            System.out.println("Pass,your email has been send");
        }else {
            System.out.println("Fail");
        }







    }
}

package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testcase.utils.WebDriverFactory;

import java.util.List;

public class TC_001 {
    public static void main(String[] args) {

        /**
         * Assignment 1 :
         * Practice website link: http://practice.cybertekschool.com/download
         * User story:
         * As a user, I want to download files so that i can save them in my local device. Acceptance Criteria(AC):
         * 1. "File Downloader" header should be displayed
         * 2. All the required files should be displayed on the page
         */

         WebDriver driver = WebDriverFactory.getDriver("chrome");

         driver.manage().window().maximize();

         driver.get("http://practice.cybertekschool.com/download");

           //<h3>File Downloader</h3>
           WebElement fileDownloader = driver.findElement(By.tagName("h3"));

           //1. "File Downloader" header should be displayed
           if (fileDownloader.isDisplayed()){
               System.out.println("Pass");
           }else{
               System.out.println("Fail");
           }

      //  2. All the required files should be displayed on the page
          WebElement elementOne = driver.findElement(By.xpath("//a[@href='download/junit-4.13-beta-3.jar']"));

          WebElement elementTwo = driver.findElement(By.xpath("//a[@href='download/b10 all test cases,code.docx']"));

          WebElement elementThree = driver.findElement(By.xpath("//a[@href='download/Afar.jpg']"));

          WebElement elementFour = driver.findElement(By.xpath("//a[@href='download/some-file.txt']"));

         if (elementOne.isDisplayed() && elementTwo.isDisplayed() &&
                 elementThree.isDisplayed() && elementFour.isDisplayed()){

             System.out.println("Pass");
         }else{
             System.out.println("Fail");
         }

    }
}

package Selenium_TestNG;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class MessageNotSent_TestNG {
    public static WebDriver driver;
  @Test
  public void f() {

      //Click on the Message icon on the top right corner of the page
      driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/a")).click();

      //Click on the send new message after clicking on message icon on the top right corner of the page
      driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/div/h4[1]/a")).click();

      //Type the username you are not connected with to search for him and make sure it the username is not found in order to test the negativity of the send message feature
      driver.findElement(By.id("token-input-to")).sendKeys("Youssef Abdulaziz");

      //Wait 5 seconds until search is done and the username you are connected with and willing to send a message to is available
      try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

      //Type the subject of the message you are sending
      driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/form/div[2]/div/input")).sendKeys("Very Important");

      //Type the message you are willing to send
      driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/form/div[3]/div/textarea")).sendKeys("I want to meet you at the office on Thursday");

      //Click Send button to try to send the message to the user who is not connected with us(Ahmed Korim account)
      driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/div/button[1]")).click();

      //Wait 0.5 seconds until the error message pop up as the server is sometimes slow
      try {             Thread.sleep(500);         } catch (InterruptedException e) {             e.printStackTrace();         }

      //Checking the error message is present that indicates the "TO" field is empty as the user "Youssef Abdulaziz" is not connected with us(Ahmed Korim account)
      boolean check_present = driver.findElement(By.cssSelector("li.notify-single-item")).isDisplayed();
      if(check_present == true)
      {
          System.out.print("True");
      }
      else
          System.out.print("False");


      //Finally you must Close and Quit the Browser
      //driver.close();
      //driver.quit();
  }
  
  @BeforeMethod
  public void beforeMethod() {
	// System Property for Chrome Driver
      System.setProperty("webdriver.chrome.driver", "A:\\study\\SQA\\chromedriver.exe");

      // Instantiate a ChromeDriver class to establish a connection
      driver = new ChromeDriver();

      //Puts an implicit wait, will wait for 10 seconds before throwing exception
      driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

      //Launch Website
      driver.navigate().to("https://www.jobzella.com/");

      //Maximize the Browser
      driver.manage().window().maximize();

      //Click on Log in button in the top right corner of the website home page
      driver.findElement(By.xpath("/html/body/header/div/button")).click();

      //Type the email in the username or email field
      driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/div[1]/div/div/form/div[1]/input")).sendKeys("ahmedkorim25@hotmail.com");

      //Type the password in the password field
      driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/div[1]/div/div/form/div[2]/input")).sendKeys("grouted@25");

      //Click on Log in button on the form
      driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/div[1]/div/div/form/button[2]")).click();

          //give some time for loading
          try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

          //get text on main page after login which is the timeline
          String success = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div/div[1]/div[1]/div[2]/ul/li[1]/a")).getText();


          if(success.equals("My Timeline")) {
              System.out.println("Login successfull!");
          }
          else
              System.out.println("Login Failed :(");


  }
  

  @AfterMethod
  public void afterMethod() {
      driver.close();
      driver.quit();
  }

}

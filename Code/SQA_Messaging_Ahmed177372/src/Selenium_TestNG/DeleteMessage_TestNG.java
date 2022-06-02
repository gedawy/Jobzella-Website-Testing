package Selenium_TestNG;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DeleteMessage_TestNG {
    public static WebDriver driver;
  @Test
  public void f() {
	  
	  //Click on the Message icon on the top right corner of the page
      driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/a")).click();

      //Click on the "See All Messages" after clicking on message icon on the top right corner of the page
      driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/div/h4[2]/a")).click();

      //click on sent button
      driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/nav/ul/li[2]/a")).click();

      //Wait 5 seconds until the sent section load
      try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

      //Checking if the message is sent or not
      String user = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div/a")).getText();

      String subject = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/h5")).getText();

      String message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/p")).getText();

      if (user.equals("Omar ElGedawy") && subject.equals("Very Important") && message.equals("I want to meet you at the office on Thursday")) {
          System.out.println("message sent:");
          System.out.println("user: " + user);
          System.out.println("subject: " + subject);
          System.out.println("message: " + message);
      }
      else {
          System.out.println("message doesn't match the sent message");
      }

      //This click on trash icon button (Delete)
      driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[3]/div/ul/li[3]/a")).click();

      //This click on Yes to delete the message
      driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/button[1]")).click();

      //click on Trash button in the left of the page
      driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/nav/ul/li[3]")).click();

      //Wait 5 seconds until the sent section load
      try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

      //Checking if the message is sent or not
      String user1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div/a")).getText();

      String subject1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/h5")).getText();

      String message1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/p")).getText();

      if (user1.equals("Omar ElGedawy") && subject1.equals("Very Important") && message1.equals("I want to meet you at the office on Thursday")) {
          System.out.println("message deleted:");
          System.out.println("user: " + user1);
          System.out.println("subject: " + subject1);
          System.out.println("message: " + message1);
      }
      else {
          System.out.println("message in the trash section doesn't match the message in the sent section");
      }

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

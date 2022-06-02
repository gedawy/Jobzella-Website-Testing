package lll;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class ApplyError_TestNG {
	
	public static WebDriver driver;
  @Test
  public void f() {
	  try {

          driver.findElement(By.id("search-input-field")).click();
          driver.findElement(By.id("search-input-field")).sendKeys("Maintenance Engineer");
          driver.findElement(By.cssSelector(".headerSearch__submit > .fa")).click();
          driver.findElement(By.cssSelector(".cards__gridItem:nth-child(2) a:nth-child(1) > .ng-binding")).click();

          Thread.sleep(7000);

          String hndle = "";
          for (String handle : driver.getWindowHandles()) {
              //System.out.println(handle1);
              hndle = handle;
          }
          driver.switchTo().window(hndle);

          //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "1");
          //driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");

          driver.findElement(By.xpath("//*[@id=\"apply_btn\"]")).click();

          driver.findElement(By.xpath("//*[@id=\"change_info-mobile\"]/div[2]/a")).click();

          driver.findElement(By.id("exampleInputnumber")).click();

          driver.findElement(By.id("exampleInputnumber")).clear();

          driver.findElement(By.id("exampleInputnumber")).sendKeys("someone");

          WebElement numerror = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div/div[2]/div/div[2]/section[1]/form/div[1]/div/i"));

          Actions action = new Actions(driver);

          action.moveToElement(numerror).perform();

          //Wait 5 seconds until search is done and the username you are connected with and willing to send a message to is available
          try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

          boolean check_present = driver.findElement(By.cssSelector("div.tooltip-inner")).isDisplayed();
          if(check_present == true)
          {
              System.out.println("Invalid Phone Number");
          }
          else
          {
              System.out.println("False");
          }

          driver.findElement(By.cssSelector(".qc-auto-applyJobEdit > .fa")).click();

          driver.findElement(By.id("exampleInputemail")).click();

          driver.findElement(By.id("exampleInputemail")).clear();

          driver.findElement(By.id("exampleInputemail")).sendKeys("3344");

          WebElement emailerror = driver.findElement(By.xpath("//*[@id=\"change_info-email\"]/div[1]/div/i"));

          Actions action1 = new Actions(driver);

          action1.moveToElement(emailerror).perform();

          //Wait 5 seconds until search is done and the username you are connected with and willing to send a message to is available
          try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

          boolean check_present1 = driver.findElement(By.cssSelector("div.tooltip-inner")).isDisplayed();
          if(check_present1 == true)
          {
              System.out.println("Invalid Email Address");
          }
          else
          {
              System.out.println("False");
          }

          driver.findElement(By.xpath("//*[@id=\"change_info-address\"]/div[2]/a")).click();

          driver.findElement(By.xpath("//*[@id=\"exampleInputadress\"]")).clear();

          driver.findElement(By.xpath("//*[@id=\"exampleInputadress\"]")).sendKeys("1234");

          driver.findElement(By.xpath("//*[@id=\"change_info-address\"]/div[2]/button")).click();

          driver.findElement(By.xpath("//*[@id=\"global_apply\"]")).click();

          //driver.close();
          //driver.quit();

      }catch(Exception e) {
          System.out.println(e);
      }
  }
  @BeforeMethod
  public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Users\\Youssef Abdulaziz\\Downloads\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.jobzella.com");

		// maximize page
		driver.manage().window().maximize();

		try {
			// select and click on the login button
			driver.findElement(By.xpath("/html/body/header/div/button")).click();

			// select and enter user email address
			driver.findElement(By.cssSelector("input#username.form-control.input-sm"))
					.sendKeys("youssef.n.abdulaziz@gmail.com");

			// select and enter user password
			driver.findElement(By.cssSelector("input.password.form-control.input-sm")).sendKeys("gamedgamedD1");

			// select and click on popup login button
			driver.findElement(By.xpath("//*[@id=\"login-header\"]/button[2]")).click();

			// give some time for loading
			Thread.sleep(1000);

			// get text from user dashboard after logged in
			String success = driver
					.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div/div[1]/div[1]/div[2]/ul/li[1]/a")).getText();

			if (success.equals("My Timeline")) {
				System.out.println("Login successfull!");
			} else
				System.out.println("Login Failed :(");

		} catch (Exception e) {

		}
  }

  @AfterMethod
  public void afterMethod() {
  }
//driver.close();
}

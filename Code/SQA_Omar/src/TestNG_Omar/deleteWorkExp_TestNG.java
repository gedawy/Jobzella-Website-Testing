package TestNG_Omar;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class deleteWorkExp_TestNG {
  public static WebDriver driver;
  @Test
  public void f() {
	  
	//Initiate a javascript executer to be able to execute the javascript scroll script
      JavascriptExecutor js = (JavascriptExecutor) driver;
      
      try {
			//click on profile word on navigation bar
			driver.findElement(By.cssSelector("a#dLabel.siteHeader__secondMenu--listItemLink.has-subMenu")).click();
			
			//click on edit profile option from drop-down
			driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div/ul/li[2]/div/ul/li[2]/a")).click();
			
			//scroll down to experiences using javascript executer
			js.executeScript("window.scrollBy(0,500)");
			
			//wait 3 seconds for experiences section to load
			Thread.sleep(3000);
			
			//check precondition: There must be at least one work experience
			boolean existing = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[1]/p[1]/strong")).isDisplayed();

			//if there is a work experience in the work experience section, continue the deletion process
			if(existing) {
			
				//click on delete button
				driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[2]/small[1]")).click();
	
				//wait for 3 seconds to see the coming confirmation message
				Thread.sleep(5000);
				
	        	//click on delete button in the confirm deletion pop-up
				driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/button[1]")).click();
	
				//wait for 5 seconds to commit the result
				Thread.sleep(5000);
				
				//scroll back up by 500 units to see the complete result
				js.executeScript("window.scrollBy(0,-500)");
	
				//retrieve the text currently written under the work experience section 
	        	String displayed = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/span")).getText();
	        	
	        	//the anticipated value for the retrieved text should be: There are no experiences
	        	String predicted = "There are no experiences";
	        	
	        	//compare the retrieved with the anticipated value
	        	if(displayed.equals(predicted)) {
	        		System.out.println("The deletion of the work experience was done successfully");
	        	}
	        	else {
	        		System.out.println("A error occurred with deletion");
	        	}
      	
			}
      }catch(Exception e) {
      	
      }
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	//load the webdriver
	System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
	
	//set the driver as a chrome driver of google chrome
	driver = new ChromeDriver();
	
	//manage timeout if happened
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	//navigate to jobzella
	driver.navigate().to("https://www.jobzella.com");
	
	
	//maximize page 
	driver.manage().window().maximize();
	
	try {
		//click on the login button on top right corner
		driver.findElement(By.xpath("/html/body/header/div/button")).click();
				
		//target username field in pop-up and type username
		driver.findElement(By.cssSelector("input#username.form-control.input-sm")).sendKeys("Ummourah");

		//target password field in pop-up and type password
		driver.findElement(By.xpath("//*[@id=\"loginModal\"]/div/div/div[2]")).findElement(By.xpath("//*[@id=\"login-header\"]/div[2]/input")).sendKeys("iwillrockyou123");
		
		//click on the login button in pop-up
		driver.findElement(By.xpath("//*[@id=\"loginModal\"]/div/div/div[2]")).findElement(By.xpath("//*[@id=\"login-header\"]/button[2]")).click();
		
		//give some time for loading
		Thread.sleep(1000);
		
		//get text on main page after login which is the timeline
		String success = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div/div[1]/div[1]/div[2]/ul/li[1]/a")).getText();
		
		//make sure that the work timeline is there, if so, then the user has logged in successfully
		if(success.equals("My Timeline")) {
			System.out.println("Login successfull!");
		}
		else 
			System.out.println("Login Failed :(");
			
	}catch(Exception e) {
		
	}
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
	  driver.quit();
  }

}

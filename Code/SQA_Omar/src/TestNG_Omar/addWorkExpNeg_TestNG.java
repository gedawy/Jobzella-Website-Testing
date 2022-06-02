package TestNG_Omar;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class addWorkExpNeg_TestNG {
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
			
			//scroll down to experiences
			js.executeScript("window.scrollBy(0,600)");
			
			//wait 3 seconds for the experiences section to load
			Thread.sleep(3000);
			
			//click on add new button to add new experience
			driver.findElement(By.xpath("//*[@id=\"addNewSeekereExp\"]")).click();
      	
			//wait for 3 seconds to load add new experiences form
			Thread.sleep(3000);
			
			//write title of the work experience
			driver.findElement(By.xpath("//*[@id=\"exp-title\"]")).sendKeys("Junior Software Engineer");

			//write company name of the work experience
			driver.findElement(By.xpath("//*[@id=\"exp-comp\"]")).sendKeys("Override");
			
			//select company industry from drop-down list, select the text option Computer Software industry
			WebElement company = driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[3]/select"));
			Select com_dropdown = new Select(company);
			com_dropdown.selectByVisibleText("Computer Software");
      	
			//write company location, write fifth settlement	
			driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[4]/input")).sendKeys("fifth settlement");

			//select job role from drop-down list
			WebElement job = driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[5]/select"));
			Select job_dropdown = new Select(job);
			job_dropdown.selectByVisibleText("Technical");
			
			
			//select start month of work experience from drop-down list of months, select month number 6
			WebElement month_start = driver.findElement(By.xpath("//*[@id=\"period_from_month\"]"));
			Select month_dropdown = new Select(month_start);
			month_dropdown.selectByVisibleText("6");
			
			//select start year of work experience from drop-down list of years, select year 2016
			WebElement year_start = driver.findElement(By.xpath("//*[@id=\"period_from_year\"]"));
			Select year_dropdown = new Select(year_start);
			year_dropdown.selectByVisibleText("2016");
			
			//wait for 3 seconds to let the 2 other month/year drop-down load
			Thread.sleep(3000);
			
			//select end month of the work experience from drop-down list of months, select month number 4
			WebElement month_end = driver.findElement(By.xpath("//*[@id=\"period_to_month\"]"));
			Select emonth_dropdown = new Select(month_end);
			emonth_dropdown.selectByVisibleText("4");
      	
			//select end year of the work experience from drop-down list of years, select year 2015
			WebElement year_end = driver.findElement(By.xpath("//*[@id=\"period_to_year\"]"));
			Select eyear_dropdown = new Select(year_end);
			eyear_dropdown.selectByVisibleText("2015");
			
			
			//write description to the description of the work experience text field
			driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[7]/textarea")).sendKeys("Under training");
			
			//wait for 8 seconds
			Thread.sleep(8000);
			
			//click the save button

			//check if the save button is enabled, if not enabled, then the system handled wrong date
			boolean enabled = driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[8]/input")).isEnabled();
			
			if(!enabled) {
				System.out.println("TEST CASE SUCCEEDED: The save button is disabled");
			}
			else {
				System.out.println("TEST CASE FAILED: did not prevent work experience from recent (new) date/to less recent (old) date problem");
			}
			
			
			WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/div[4]/div[1]/div[2]/div/form/div[6]/div/div/div[2]/div/div/div[2]/i"));

			//Creating object of an Actions class
			Actions action = new Actions(driver);

			//Performing the mouse hover action on the x symbol in order for the error message to appear and thus capture it
			action.moveToElement(ele).perform();
			
			
			//Thread.sleep(4000);
			
			//check if error message is displayed
			boolean error = driver.findElement(By.cssSelector("div.tooltip-inner")).isDisplayed();

			//if there is error message print error message !, else print NO errors found !
			if(error) {
				System.out.println("error message !");
			}
			else { 
				System.out.println("NO error found !");
			}
			
			//click on profile word again
			driver.findElement(By.cssSelector("a#dLabel.siteHeader__secondMenu--listItemLink.has-subMenu")).click();
			
			//click on edit profile
			driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div/ul/li[2]/div/ul/li[2]/a")).click();
			
			//scroll down to experiences
			js.executeScript("window.scrollBy(0,600)");
			Thread.sleep(3000);
			
			//check if there was no work experience added, if displayed message is the anticipated "There are no experiences" then no work experience was added as system prevented 
			String displayed = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/span")).getText();
      	String predicted = "There are no experiences";
      	
      	//if message displayed is equal to 'There is no experiences added' then print SUCCESS, else print There must be something wrong
      	if(displayed.equals(predicted)) {
      		System.out.println("SUCCESS: There is no experenices added");
      	}
      	else {
      		System.out.println("The must be something wrong");
      	}

		}
		catch(Exception e) {
			System.out.println(e);
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

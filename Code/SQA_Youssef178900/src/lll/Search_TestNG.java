package lll;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class Search_TestNG {
	public static WebDriver driver;
  @Test
  public void f() {
	  
	  try {
      	driver.findElement(By.id("search-input-field")).click();
      	driver.findElement(By.id("search-input-field")).sendKeys("Awlad Ragab");
      	
      	driver.findElement(By.xpath("//*[@id=\"headerSearch__dropDownBtn\"]")).click();
      	
      	driver.findElement(By.xpath("//*[@id=\"search\"]/div/div/div[1]/ul/li[2]/a")).click();
          
  		driver.findElement(By.cssSelector(".headerSearch__submit > .fa")).click();
  		

  		

      	
      	WebElement selectcountry = driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/form[5]/div/div[1]/div[1]/div/div[3]/div/div[1]/div/select"));
          Select countryselect = new Select(selectcountry);
          countryselect.selectByVisibleText("Egypt");
          
   
  
  		
  	  	WebElement selectcity = driver.findElement(By.xpath("/html/body/div[2]/div/div[4]/form[5]/div/div[1]/div[1]/div/div[3]/div/div[2]/div/select"));
          Select cityselect = new Select(selectcity);
          cityselect.selectByVisibleText("Cairo");
      	
          
          driver.findElement(By.cssSelector("#filter-companies .col-lg-3:nth-child(2) .col-xs-6:nth-child(2) label:nth-child(2)")).click();
          driver.findElement(By.cssSelector("#filter-companies .btn:nth-child(1)")).click();

          Thread.sleep(3000);
          
          String searchtextcheck = driver.findElement(By.cssSelector(".companiesSearchResults > .tabPanelContent__status")).getText();
  		if (searchtextcheck.equals("1 Companies Found")){
  			System.out.println("Found Company success!");
  		}else {
  			System.out.println("Not found company!");
  		}
  		
  		
          boolean searchresultdisplayed = driver.findElement(By.xpath("//*[@id=\"cards_container\"]/div/div[2]/div")).isDisplayed();
          if(searchresultdisplayed == true)
          {
              System.out.println("Found Search Result");
          }
          else
          {
              System.out.println("Not Found Search Result");
          }
  		
          
          String searchresultname = driver.findElement(By.xpath("//*[@id=\"cards_container\"]/div/div[2]/div/div[1]/h3/a")).getText();
  		if (searchresultname.equals("Awlad Ragab")){
  			System.out.println("Found Company Name success!");
  		}else {
  			System.out.println("Not found company Name!");
  		}
  		 
  		
  		
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

}

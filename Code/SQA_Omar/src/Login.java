import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {
	//Omar
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
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
	
}

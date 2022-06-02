package lll;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver","D:\\Users\\Youssef Abdulaziz\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.jobzella.com");
		
		
		//maximize page
		driver.manage().window().maximize();
		
		try {
			//select and click on the login button
			driver.findElement(By.xpath("/html/body/header/div/button")).click();
					
			//select and enter user email address
			driver.findElement(By.cssSelector("input#username.form-control.input-sm")).sendKeys("youssef.n.abdulaziz@gmail.com");

			//select and enter user password
			driver.findElement(By.cssSelector("input.password.form-control.input-sm")).sendKeys("gamedgamedD1");
			
			//select and click on popup login button
			driver.findElement(By.xpath("//*[@id=\"login-header\"]/button[2]")).click();
			
			//give some time for loading
			Thread.sleep(1000);
			
			//get text from user dashboard after logged in
			String success = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div/div[1]/div[1]/div[2]/ul/li[1]/a")).getText();
			
			
			if(success.equals("My Timeline")) {
				System.out.println("Login successfull!");
			}
			else 
				System.out.println("Login Failed :(");
				
		}catch(Exception e) {
			
		}
	}
	
}
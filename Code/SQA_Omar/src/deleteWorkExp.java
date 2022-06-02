import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class deleteWorkExp{
	
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException{
		
		//run the login
		Login.main(args);
		
		//take the driver of the login to continue after login
		driver = Login.driver;
		
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
			Thread.sleep(6000);
			
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
				Thread.sleep(8000);
				
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

}

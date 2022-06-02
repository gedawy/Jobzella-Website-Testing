import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class editWorkExp{
	
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
			
			//scroll down to experiences section
			js.executeScript("window.scrollBy(0,700)");
			
			//wait 3 seconds for the experiences section to load
			Thread.sleep(3000);
			
			//get text of the existing work experience to make sure there is a work experience to edit
			String existing = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[1]/p[1]/strong")).getText();
			
			//if the text retrieved is not null, it means there exists a work experience in the work experiences section
			if(existing != null) {
				System.out.println("Precondition satisfied: There is one job experience");
			}
			
			//click on the edit button on the top right of the work experience
			driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[2]/small[2]")).click();
        	
			//wait for 3 seconds for the editable form to load
			Thread.sleep(3000);
			
			//clear existing and write new/edited title
			driver.findElement(By.xpath("//*[@id=\"exp-title\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"exp-title\"]")).sendKeys("Team Leader Software Engineer");

			//clear existing and write new/edited location
			driver.findElement(By.xpath("//*[@id=\"saveSeekerExp\"]/div[4]/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"saveSeekerExp\"]/div[4]/input")).sendKeys("Nasr City");
			
			//wait for 3 seconds
			Thread.sleep(3000);

			//scroll down to see more of the editable form
			js.executeScript("window.scrollBy(0,300)");
			
			//wait for 3 seconds to load the new part of form
			Thread.sleep(3000);
			
			//clear existing and write edited description
			driver.findElement(By.xpath("//*[@id=\"saveSeekerExp\"]/div[7]/textarea")).clear();;
			driver.findElement(By.xpath("//*[@id=\"saveSeekerExp\"]/div[7]/textarea")).sendKeys("Responsible for writing the test plan");
			
			//click on the save button of the edit form
			driver.findElement(By.xpath("//*[@id=\"saveSeekerExp\"]/div[8]/input")).click();
			
			//wait for 8 seconds to commit the entered data
			Thread.sleep(9000);
			
			//scroll back up to see the committed result after edit
			js.executeScript("window.scrollBy(0,-400)");
			
			//start asserting and retrieving current values
			String title = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[1]/p[1]/strong")).getText();
			String location = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[3]/p/span/strong")).getText();
			String desc = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[6]/p/span")).getText();

			//wait for 6 seconds after values retrieve
			Thread.sleep(8000);
			
			System.out.println("Edit work experience testcase");
			System.out.println("***************************");
			//System.out.println(title+location+desc);	

			//assert that the committed values in the edited fields are the same as the values entered in those fields
			if (title.equals("Team Leader Software Engineer") && location.equals("Nasr City") && desc.equals("Responsible for writing the test plan")) {
				System.out.println("Update Done, work experience edited:");
				System.out.println("Edited Title: " + title);
				System.out.println("Edited Location: " + location);
				System.out.println("Edited Description: " + desc);
			}
			else {
				System.out.println("Entered values dont match check values.");	
			}
        	
        }
        catch(Exception e) {
			System.out.println(e);	

        }
	}

}

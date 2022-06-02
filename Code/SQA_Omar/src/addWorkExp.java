import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class addWorkExp{
	
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
			
			//scroll down to experiences with javascript executer
			js.executeScript("window.scrollBy(0,500)");
			
			//wait 3 seconds for the experiences section to load
			Thread.sleep(3000);
			
			//click on add new button to add new experience
			driver.findElement(By.xpath("//*[@id=\"addNewSeekereExp\"]")).click();
        	
			//wait for 3 seconds to load add new experiences form
			Thread.sleep(3000);
			
			//write title of the work experience
			driver.findElement(By.xpath("//*[@id=\"exp-title\"]")).sendKeys("Senior Software Engineer");

			//write company name of the work experience
			driver.findElement(By.xpath("//*[@id=\"exp-comp\"]")).sendKeys("Google");
			
			//select company industry from drop-down list, select the text option Computer Software industry
			WebElement company = driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[3]/select"));
			Select com_dropdown = new Select(company);
			com_dropdown.selectByVisibleText("Computer Software");
        	
			//write company location, write Maadi	
			driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[4]/input")).sendKeys("Maadi");

			//select job role from drop-down list
			WebElement job = driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[5]/select"));
			Select job_dropdown = new Select(job);
			job_dropdown.selectByVisibleText("Technical");
			
			
			//select start month of work experience from drop-down list of months, select month number 5
			WebElement month_start = driver.findElement(By.xpath("//*[@id=\"period_from_month\"]"));
			Select month_dropdown = new Select(month_start);
			month_dropdown.selectByVisibleText("5");
			
			//select start year of work experience from drop-down list of years, select year 2017
			WebElement year_start = driver.findElement(By.xpath("//*[@id=\"period_from_year\"]"));
			Select year_dropdown = new Select(year_start);
			year_dropdown.selectByVisibleText("2017");
			
			//wait for 3 seconds to let the 2 other month/year drop-down load
			Thread.sleep(3000);
			
			//select end month of the work experience from drop-down list of months, select month number 7
			WebElement month_end = driver.findElement(By.xpath("//*[@id=\"period_to_month\"]"));
			Select emonth_dropdown = new Select(month_end);
			emonth_dropdown.selectByVisibleText("7");
        	
			//select end year of the work experience from drop-down list of years, select year 2020
			WebElement year_end = driver.findElement(By.xpath("//*[@id=\"period_to_year\"]"));
			Select eyear_dropdown = new Select(year_end);
			eyear_dropdown.selectByVisibleText("2020");
			
			//write description to the description of the work experience text field
			driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[7]/textarea")).sendKeys("Responsible for the integration of the software units");
			
			//click the save button of the add new experience form
			driver.findElement(By.xpath("//*[@id=\"insertSeekerExp\"]/div[8]/input")).click();
			
			//wait for 8 seconds to close the input form and commit the submitted input
			Thread.sleep(8000);
			
			//scroll a little up to see all the result
			js.executeScript("window.scrollBy(0,-400)");
			
			
			//start asserting and retrieve all the entered/submitted inputs in the add new experience form
			
			//retrieve title
			String title = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[1]/p[1]/strong")).getText();
			//retrieve company name
			String company_name = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[1]/p[2]/strong")).getText();
			//retrieve location
			String location = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[3]/p/span/strong")).getText();
			//retrieve industry
			String industry = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[1]/p[2]/span[1]")).getText();
			//retrieve duration
			String duration = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[4]/p/span[2]")).getText();
			//retrieve role
			String role = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[5]/p/span[2]")).getText();
			//retrieve description
			String desc = driver.findElement(By.xpath("//*[@id=\"seeker-job-exp\"]/div/div/div/div[6]/p/span")).getText();

			//split duration by space to split months and years and store the in an array to target specific elements later
			String[] durArr = duration.split(" ");
			
			//wait for 4 seconds after retrieve
			Thread.sleep(4000);
			
			System.out.println("Add new work experience testcase");
			System.out.println("***************************");
			
			//check if the committed data is the same as the data entered
			if (title.equals("Senior Software Engineer") && location.equals("Maadi") && company_name.equals("Google") && industry.equals("Computer Software") && durArr[0].equals("May") && durArr[1].equals("2017") && durArr[3].equals("July") &&  durArr[4].equals("2020") && role.equals("Technical") && desc.equals("Responsible for the integration of the software units")) {
				System.out.println("Update Done, new experience added:");
				System.out.println("Title: " + title);
				System.out.println("Company: " + company_name);
				System.out.println("Company Industry: " + industry);
				System.out.println("duration: " + duration);
				System.out.println("role: " + role);
				System.out.println("Description: " + desc);
			}
			else {
				System.out.println("Entered values dont match check values.");	
			}
			

        }catch(Exception e) {
        	System.out.println(e);
        }
	}

}

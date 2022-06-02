import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class editProfileInfo{

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
			
			//scroll down to personal info section
			js.executeScript("window.scrollBy(0,1700)");
			Thread.sleep(3000);
			
			// click on edit link on the top right of personal info section
			driver.findElement(By.xpath("//*[@id=\"personal_info\"]/div[1]/small")).click();
			
			
			//Thread.sleep(1000);

			// select Male from gender drop-down menu of personal info section
			WebElement dropgender = driver.findElement(By.xpath("//*[@id=\"info-gender-edit\"]"));
			Select gender_drpdown = new Select(dropgender);
			gender_drpdown.selectByVisibleText("Male");
			
			
			//select Egypt from Nationality drop-down menu of personal info section
			WebElement dropNation = driver.findElement(By.xpath("//*[@id=\"info-nationality-edit\"]"));
			Select nation_drpdown = new Select(dropNation);
			nation_drpdown.selectByVisibleText("Egypt");
			
		
			//select 16 from day drop-down menu of the personal info section
			WebElement dropDay = driver.findElement(By.xpath("//*[@id=\"info-birth-day-edit\"]"));
			Select day_drpdown = new Select(dropDay);
			day_drpdown.selectByVisibleText("16");
			

			//select 4 from month drop-down menu of the personal info section
			WebElement dropMonth = driver.findElement(By.xpath("//*[@id=\"info-birth-month-edit\"]"));
			Select month_drpdown = new Select(dropMonth);
			month_drpdown.selectByVisibleText("4");
			

			//select 1999 from year drop-down menu of the personal info section
			WebElement dropYear = driver.findElement(By.xpath("//*[@id=\"info-birth-year-edit\"]"));
			Select year_drpdown = new Select(dropYear);
			year_drpdown.selectByVisibleText("1999");
			

			//select Egypt from Country drop-down menu of the personal info section
			WebElement dropCountry = driver.findElement(By.xpath("//*[@id=\"country\"]"));
			Select country_drpdown = new Select(dropCountry);
			country_drpdown.selectByVisibleText("Egypt");
						

			//select No visa from Visa Status drop-down menu of the personal info section
			WebElement dropVisa = driver.findElement(By.xpath("//*[@id=\"info-visa-edit\"]"));
			Select visa_drpdown = new Select(dropVisa);
			visa_drpdown.selectByVisibleText("No Visa");
			

			//select 0 from Number of Dependants drop-down menu of the personal info section
			WebElement dropDep = driver.findElement(By.xpath("//*[@id=\"info-dependants-edit\"]"));
			Select dep_drpdown = new Select(dropDep);
			dep_drpdown.selectByVisibleText("0");
			

			//select Single status from Marital Status drop-down menu of the personal info section
			WebElement dropMar = driver.findElement(By.xpath("//*[@id=\"info-marital-edit\"]"));
			Select mar_drpdown = new Select(dropMar);
			mar_drpdown.selectByVisibleText("Single");
			
			//wait for 2 seconds to load the cities of Egypt in the cities drop-down menu of the personal info section
			Thread.sleep(2000);
			
			//select Cairo from the City drop-down menu of the personal info section
			WebElement dropCity = driver.findElement(By.xpath("//*[@id=\"city\"]"));
			Select city_drpdown = new Select(dropCity);
			city_drpdown.selectByVisibleText("Cairo");

			
			//click the save button after editing personal information
			driver.findElement(By.xpath("//*[@id=\"personal_info_data\"]/div[6]/input")).click();
			
			//wait for 8 seconds for the entered edited values to be committed 
			Thread.sleep(8000);
			
			//assert the update was committed
			//retrieve each edited value
			String gender = driver.findElement(By.xpath("//*[@id=\"info-gender\"]")).getText();
			String birth = driver.findElement(By.xpath("//*[@id=\"info-birth\"]")).getText();
			String nation = driver.findElement(By.xpath("//*[@id=\"info-nationality\"]")).getText();
			String country = driver.findElement(By.xpath("//*[@id=\"info-country\"]")).getText();
			String city = driver.findElement(By.xpath("//*[@id=\"info-city\"]")).getText();
			String visa = driver.findElement(By.xpath("//*[@id=\"info-visa\"]")).getText();
			String dep = driver.findElement(By.xpath("//*[@id=\"info-dependants\"]")).getText();
			String marital = driver.findElement(By.xpath("//*[@id=\"info-marital\"]")).getText();
			
			//wait for 4 seconds after retrieve
			Thread.sleep(4000);
			
			System.out.println("Edit personal info testcase");
			System.out.println("***************************");
			
			//check if the committed/current values are the same as the values entered
			if (gender.equals("Male") && birth.equals("1999-04-16") && nation.equals("EGYPT") && country.equals("EGYPT") && city.equals("Cairo") && visa.equals("No Visa") && dep.equals("No Dependant") && marital.equals("Single")) {
				System.out.println("Update Done, new profile info:");
				System.out.println("Gender: " + gender);
				System.out.println("Birthday: " + birth);
				System.out.println("Nationlity: " + nation);
				System.out.println("Country: " + country);
				System.out.println("city: " + city);
				System.out.println("visa status: " + visa);
				System.out.println("Num of dependants: " + dep);
				System.out.println("Marital status: " + marital);
			}
			else {
				System.out.println("Entered values dont match check values.");	
			}
							
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
}

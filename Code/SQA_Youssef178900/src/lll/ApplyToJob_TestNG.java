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

public class ApplyToJob_TestNG {
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
				// System.out.println(handle1);
				hndle = handle;
			}
			driver.switchTo().window(hndle);

			// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "1");
			// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "2");

			driver.findElement(By.xpath("//*[@id=\"apply_btn\"]")).click();

			driver.findElement(By.xpath("//*[@id=\"change_info-mobile\"]/div[2]/a")).click();
			driver.findElement(By.id("exampleInputnumber")).click();
			driver.findElement(By.cssSelector(".qc-auto-applyJobMobileSave")).click();

			driver.findElement(By.cssSelector(".qc-auto-applyJobEdit > .fa")).click();
			driver.findElement(By.id("exampleInputemail")).click();
			driver.findElement(By.cssSelector(".qc-auto-applyJobSave")).click();

			driver.findElement(By.cssSelector(".qc-auto-applyJobAddressEdit > .fa")).click();
			driver.findElement(By.id("exampleInputadress")).click();
			driver.findElement(By.cssSelector(".qc-auto-applyJobAddressSave")).click();

			WebElement selectcv = driver.findElement(
					By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div/div/div[2]/div/div[2]/section[4]/p/select"));
			Select cvselect = new Select(selectcv);
			cvselect.selectByVisibleText(
					"copy-of-beige-and-black-refined-collage-step-by-step-skincare-instagram-storypdf");
			driver.findElement(By.id("global_apply")).click();
			Thread.sleep(5000);
			String testresult = driver
					.findElement(By
							.xpath("//*[@id=\"wrap\"]/div/div/div[1]/div[1]/div[1]/div[1]/div/div[2]/div[2]/div[1]/a"))
					.getText();
			if (testresult.equals("Already Applied")) {
				System.out.println("Already Applied to Job!");
			} else {
				System.out.println("Not Applied to Job!");
			}

			// driver.close();
			// driver.quit();

		} catch (Exception e) {
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
		//driver.close();
	}

}

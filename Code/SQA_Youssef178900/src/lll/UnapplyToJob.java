package lll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class UnapplyToJob {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

        Login.main(args);

        driver = Login.driver;
        
        try {
        	driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div/ul/li[4]/div/a")).click();
        	driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div/ul/li[4]/div/ul/li[1]/a")).click();
        	driver.findElement(By.xpath("/html/body/div[2]/section/div/section[1]/div/div[2]/div/div/div/article/div/div[4]/a")).click();
    		Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/section/div/section[1]/div/div[2]/div/div/div/article/div/div[1]/div/a[2]")).click();
        	Thread.sleep(1000);
        	driver.findElement(By.xpath("/html/body/div[2]/section/div/section[1]/div/div[1]/ul/li[1]/a")).click();
        	Thread.sleep(3000);
        	
        	String unappliedtojob = driver.findElement(By.xpath("/html/body/div[2]/section/div/section[1]/div/div[1]/ul/li[1]/a/span[2]")).getText();
    		if (unappliedtojob.equals("0")){
    			System.out.println("Unapplied to job successfuly");
    		}else {
    			System.out.println("Unapplied to job unsuccessfuly");
    		}
        	
        	
        	
        	
        }catch(Exception e) {
            System.out.println(e);
        }
	}
}

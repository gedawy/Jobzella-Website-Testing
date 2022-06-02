package lll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Search {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

        Login.main(args);

        driver = Login.driver;
        
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
}}

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Login {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        // System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "A:\\study\\SQA\\chromedriver.exe");

        // Instantiate a ChromeDriver class to establish a connection
        driver = new ChromeDriver();

        //Puts an implicit wait, will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Launch Website
        driver.navigate().to("https://www.jobzella.com/");

        //Maximize the Browser
        driver.manage().window().maximize();

        //Click on Log in button in the top right corner of the website home page
        driver.findElement(By.xpath("/html/body/header/div/button")).click();

        //Type the email in the username or email field
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/div[1]/div/div/form/div[1]/input")).sendKeys("ahmedkorim25@hotmail.com");

        //Type the password in the password field
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/div[1]/div/div/form/div[2]/input")).sendKeys("grouted@25");

        //Click on Log in button on the form
        driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/div[1]/div/div/form/button[2]")).click();

            //give some time for loading
            Thread.sleep(1000);

            //get text on main page after login which is the timeline
            String success = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div/div[1]/div[1]/div[2]/ul/li[1]/a")).getText();


            if(success.equals("My Timeline")) {
                System.out.println("Login successfull!");
            }
            else
                System.out.println("Login Failed :(");


    }

}

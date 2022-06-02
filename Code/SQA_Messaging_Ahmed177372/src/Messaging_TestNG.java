import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class Messaging_TestNG {
    public static WebDriver driver;
    @Test
    public void f() {
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/a")).click();

        //Click on the send new message after clicking on message icon on the top right corner of the page
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/div/h4[1]/a")).click();

        //Type the username you are connected with to search for him and make sure he is connected and available in the list
        driver.findElement(By.id("token-input-to")).sendKeys("Omar Elgedawy");

        //Wait 5 seconds until search is done and the username you are connected with and willing to send a message to is available
        try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

        //Choose the username you are willing to send a message to
        driver.findElement(By.xpath("/html/body/div[6]")).click();

        //Type the subject of the message you are sending
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/form/div[2]/div/input")).sendKeys("Very Important");

        //Type the message you are willing to send
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/form/div[3]/div/textarea")).sendKeys("I want to meet you at the office on Thursday");

        //Click Send button to send the message to the user
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/div/button[1]")).click();

        //Checking if the message is sent or not
        String user = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div/a")).getText();

        String subject = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/h5")).getText();

        String message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/p")).getText();

        if (user.equals("Omar ElGedawy") && subject.equals("Very Important") && message.equals("I want to meet you at the office on Thursday")) {
            System.out.println("message sent:");
            System.out.println("user: " + user);
            System.out.println("subject: " + subject);
            System.out.println("message: " + message);
        }
        else {
            System.out.println("message doesn't match the sent message");
        }


        //Finally you must Close and Quit the Browser
        //driver.close();
        //driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //get text on main page after login which is the timeline
        String success = driver.findElement(By.xpath("//*[@id=\"wrap\"]/div[1]/div/div[1]/div[1]/div[2]/ul/li[1]/a")).getText();


        if(success.equals("My Timeline")) {
            System.out.println("Login successfull!");
        }
        else
            System.out.println("Login Failed :(");


    }


    @AfterMethod
    public void afterMethod() {
        driver.close();
        driver.quit();
    }

}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MessageNotSent {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        Login.main(args);

        // Instantiate a ChromeDriver class to establish a connection
        driver = Login.driver;

        //Click on the Message icon on the top right corner of the page
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/a")).click();

        //Click on the send new message after clicking on message icon on the top right corner of the page
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/div/h4[1]/a")).click();

        //Type the username you are not connected with to search for him and make sure it the username is not found in order to test the negativity of the send message feature
        driver.findElement(By.id("token-input-to")).sendKeys("Youssef Abdulaziz");

        //Wait 5 seconds until search is done and the username you are connected with and willing to send a message to is available
        try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

        //Type the subject of the message you are sending
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/form/div[2]/div/input")).sendKeys("Very Important");

        //Type the message you are willing to send
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/form/div[3]/div/textarea")).sendKeys("I want to meet you at the office on Thursday");

        //Click Send button to try to send the message to the user who is not connected with us(Ahmed Korim account)
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[5]/div/div/div/div[2]/div/div/button[1]")).click();

        //Wait 0.5 seconds until the error message pop up as the server is sometimes slow
        try {             Thread.sleep(500);         } catch (InterruptedException e) {             e.printStackTrace();         }

        //Checking the error message is present that indicates the "TO" field is empty as the user "Youssef Abdulaziz" is not connected with us(Ahmed Korim account)
        boolean check_present = driver.findElement(By.cssSelector("li.notify-single-item")).isDisplayed();
        if(check_present == true)
        {
            System.out.print("True");
        }
        else
            System.out.print("False");



        //Finally you must Close and Quit the Browser
        //driver.close();
        //driver.quit();
    }
}


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Messaging extends Login{
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        Login.main(args);

        // Instantiate a ChromeDriver class to establish a connection
        driver = Login.driver;

        //Click on the Message icon on the top right corner of the page
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
}


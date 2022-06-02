import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RestoreMessage {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        Login.main(args);

        // Instantiate a ChromeDriver class to establish a connection
        driver = Login.driver;

        //Click on the Message icon on the top right corner of the page
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/a")).click();

        //Click on the "See All Messages" after clicking on message icon on the top right corner of the page
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div/div/div/div[2]/ul/li[2]/div/div/h4[2]/a")).click();

        //click on Trash button in the left of the page
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/nav/ul/li[3]")).click();

        //Wait 5 seconds until the trash section load
        try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

        //Checking if the message is sent or not
        String user = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div/a")).getText();

        String subject = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/h5")).getText();

        String message = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/p")).getText();

        if (user.equals("Omar ElGedawy") && subject.equals("Very Important") && message.equals("I want to meet you at the office on Thursday")) {
            System.out.println("message deleted:");
            System.out.println("user: " + user);
            System.out.println("subject: " + subject);
            System.out.println("message: " + message);
        }
        else {
            System.out.println("message in the trash section doesn't match the message in the sent section");
        }

        //This click on restore icon button (Restore)
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[3]/div/ul/li[1]/a")).click();

        //This click on Yes to restore the message to the sent section
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/div/button[1]")).click();

        //click on sent button
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[1]/div[2]/nav/ul/li[2]")).click();

        //Wait 5 seconds until the sent section load
        try {             Thread.sleep(5000);         } catch (InterruptedException e) {             e.printStackTrace();         }

        //Checking if the message is sent or not
        String user1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[1]/div/div/div/a")).getText();

        String subject1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/h5")).getText();

        String message1 = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div[2]/div/p")).getText();

        if (user1.equals("Omar ElGedawy") && subject1.equals("Very Important") && message1.equals("I want to meet you at the office on Thursday")) {
            System.out.println("message sent:");
            System.out.println("user: " + user1);
            System.out.println("subject: " + subject1);
            System.out.println("message: " + message1);
        }
        else {
            System.out.println("message doesn't match the sent message");
        }



            //Close and Quit the Browser
        //driver.close();
        //driver.quit();
    }
}


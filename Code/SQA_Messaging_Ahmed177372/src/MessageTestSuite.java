import org.openqa.selenium.WebDriver;

public class MessageTestSuite {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        //running all tests in test suite
        //running messaging test case
        Messaging.main(args);

        //running messaging test case
        DeleteMessage.main(args);

        //running messaging test case
        RestoreMessage.main(args);

        //running messaging test case
        MessageNotSent.main(args);
}
}

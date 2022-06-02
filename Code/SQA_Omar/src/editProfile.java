import org.openqa.selenium.WebDriver;

public class editProfile {
	public static void main(String[] args) throws InterruptedException{
		//Run all as test suite
		try {
			
			editProfileInfo.main(args);
			addWorkExp.main(args);
			editWorkExp.main(args);
			deleteWorkExp.main(args);
			addWorkExpNeg.main(args);
				
		}catch(Exception e) {System.out.println(e);}
		 
	}
	
}

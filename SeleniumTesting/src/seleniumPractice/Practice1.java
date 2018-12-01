package seleniumPractice;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Practice1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL;
		WebDriver driver;
		

		URL = whatURL();
		driver= URLOpener (URL);
		correctURL(URL,driver);
		
		


	}
	
	
	
	
	public static String whatURL () {
		String URL;
		System.out.println ("What website?");
		Scanner sc = new Scanner (System.in);
		URL = sc.nextLine();
		sc.close();
		return URL;
		
	}
	
	public static WebDriver URLOpener (String URL) {
		WebDriver driver = new ChromeDriver();
		driver.get(URL);
		return driver;
				
	}
	
	public static void correctURL (String URL, WebDriver driver) {
		driver.get(URL);
		try{
		  Assert.assertEquals(URL, driver.getCurrentUrl());
		  System.out.println("Navigated to correct webpage");
		}
		catch(Throwable pageNavigationError){
		  System.out.println("Didn't navigate to correct webpage");
		}
	}
	
	public static void correctPageTitle (String URL, WebDriver driver) {
		String expectedTitle = "Google";
		try{
		  Assert.assertEquals(expectedTitle, driver.getTitle());
		  System.out.println("Navigated to correct webpage");
		}
		catch(Throwable pageNavigationError){
		  System.out.println("Didn't navigate to correct webpage");
		}
	}

}



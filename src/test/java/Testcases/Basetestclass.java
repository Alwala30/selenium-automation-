package Testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Basetestclass {
	WebDriver driver;
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@BeforeClass
	public void setup()
	{
	  driver=new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.get("https://prebooking.kawasaki-india.com/bike/klx230");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	  driver.manage().window().maximize();

	}
	

}

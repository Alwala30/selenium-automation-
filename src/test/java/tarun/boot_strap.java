package tarun;

import java.awt.Window;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import sun.net.ftp.FtpDirEntry.Type;

public class boot_strap {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//ChromeOptions options =new ChromeOptions();
		//options.addArguments("--headless=new");
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		/*Actions act =new Actions(driver);
		WebElement mousehover= driver.findElement(By.xpath("//button[contains(text(),'Point Me')]"));
		WebElement Laptops= driver.findElement(By.xpath("//a[text()='Laptops']"));
		WebElement tri=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		WebElement source=driver.findElement(By.xpath("//p[text()='Drag me to my target']"));
		WebElement target=driver.findElement(By.xpath("//div[contains(@class,'ui-widget-header ui-droppable')]"));
		WebElement udemy=driver.findElement(By.xpath("//a[text()='Udemy Courses']"));
		act.moveToElement(mousehover).moveToElement(Laptops).build().perform();
		act.doubleClick(tri).perform();
		act.dragAndDrop(source, target).perform();
		act.keyDown(Keys.CONTROL).click(udemy).perform();
		Set<String> list=driver.getWindowHandles();
		List<String> list1=new ArrayList<>(list);
		driver.switchTo().window(list1.get(1));
		
		Thread.sleep(1000);
		driver.switchTo().window(list1.get(0));
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File Target =new File(System.getProperty("user.dir")+"\\screenshot\\s1.png");
		src.renameTo(Target);*/
		
		String act_title=driver.getTitle();
		if(act_title.equals("Automation Testing Practice"))
		{
		  System.out.println("Test Passed");
		}
		else
		{
			System.out.println("Test Failed");
			
		
		}
		//File Target =new File(System.getProperty("user.dir")+"\\tarun\\screen.png");
		//src.renameTo(Target);
		WebElement ele=driver.findElement(By.xpath("//h2[text()='Upload Files']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",ele);
		js.executeScript("document.body.style.zoom='90%'");
		
	    driver.findElement(By.xpath("//input[contains(@id,'multipleFilesInput')]")).sendKeys("C:\\Users\\tarun\\Downloads\\Day-31.txt" + "\n" + "C:\\Users\\tarun\\Downloads\\Day-26.txt");
	    
	}

}
;
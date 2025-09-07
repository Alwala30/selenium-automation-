package tarun;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class newwin {

	public static <Softassert> void main(String[] args) {
		
		
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://testautomationpractice.blogspot.com/");
        driver.navigate().refresh();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mm.amp.vg/#dashboard/sales");
        List<String> list=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window((list.get(1)));
        
        driver.switchTo().window((list.get(0)));
        /*driver.findElement(By.xpath("//input[@id='email']")).sendKeys("tarun@mm");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Alwala@14");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
      
        JavascriptExecutor js =(JavascriptExecutor)driver;
        //js.executeScript("arguments[0].scrollIntoView();",ele)
        js.executeScript("document.body.style.zoom='50%'");*/
        WebElement ele=driver.findElement(By.xpath("//select[contains(@id, 'country')]"));
        Select dropdown=new Select(ele);
        dropdown.selectByValue("france");
        
        
      
       
        
     
        
        
        
;

	}

}

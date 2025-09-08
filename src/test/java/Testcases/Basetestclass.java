package Testcases;

import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Basetestclass {
	WebDriver driver;
	public Properties p;

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public String Takescreenshot(String tname)

	{
		if (driver == null) {
			System.out.println("Driver is null, cannot capture screenshot");
			return System.getProperty("user.dir") + "\\screenshot\\dummy.png";
	    
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		Date dt = new Date();
		String timestamp = df.format(dt);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String TargetFilepath = System.getProperty("user.dir") + "\\screenshot\\" + tname + "_" + timestamp + ".png";
		File TargetFile = new File(TargetFilepath);
		src.renameTo(TargetFile);
		return TargetFilepath;

	}

	@BeforeClass
	@Parameters({ "browser" })
	public void setup(String br) throws Exception

	{
		FileReader file = new FileReader("./src//test//java//utilities//config.properties");
		p = new Properties();
		p.load(file);

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid browser");
			return;

		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("myurl"));
		driver.manage().window().maximize();

	}

}

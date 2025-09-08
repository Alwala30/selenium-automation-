package Testcases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pageobject.Homepage;
import utilities.writedataexcel;

public class TC_001 extends Basetestclass {
	public Properties p;

	@Test

	public void main() throws IOException, InterruptedException

	{
		try {
		FileReader file = new FileReader("./src//test//java//utilities//config.properties");
		p = new Properties();
		p.load(file);

		Homepage hp = new Homepage(driver);

		int sum = 0;

		hp.click_enquire();
		Thread.sleep(5000);
		hp.clickDealership();
		Thread.sleep(5000);
		List<WebElement> states = driver.findElements(By.xpath(p.getProperty("a")));
		for (int j = 0; j < states.size(); j++) {
			states = driver.findElements(By.xpath(p.getProperty("b")));

			WebElement state = states.get(j);
			String statename = state.getText();
			state.click();

			List<WebElement> dealers = driver.findElements(By.xpath(p.getProperty("c")));
			int r = dealers.size();
			System.out.println("Total count of dealers" + " " + r + " , " + "state:" + statename);

			for (int i = 0; i < dealers.size(); i++) {
				int stalecount = 0;
				boolean clicked = false;

				while (stalecount < 3 && !clicked) {
					try {
						dealers = driver.findElements(By.xpath(p.getProperty("d")));
						WebElement dealer = dealers.get(i);
						dealer.click();
						clicked = true;
					} catch (StaleElementReferenceException e) {
						System.out.println("stale elem retry");
						stalecount++;
						Thread.sleep(2000);
					} catch (Exception e) {
						System.out.println("no elem found");
						break;
					}

				}
				Thread.sleep(1000);
				String add = driver.findElement(By.xpath(p.getProperty("e"))).getText();
				System.out.println("Address:" + add);
				String tel = driver.findElement(By.xpath(p.getProperty("f"))).getText();
				System.out.println("Telephone:" + tel);
				String email = driver.findElement(By.xpath(p.getProperty("g"))).getText();
				System.out.println("email:" + email);
				sum = sum + r;

				hp.clickDealership();
			}
			hp.click_back();
		}
		System.out.println("Total no. of Dealers are:" + sum);

	}
		catch (Exception e)
		{
			System.out.println(e);
		}
		}

}

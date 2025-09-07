package Testcases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pageobject.Homepage;
import utilities.excelutilty;

public class TC_001 extends Basetestclass {

	@Test

	public void main() throws IOException, InterruptedException

	{
		Homepage hp = new Homepage(driver);
		
		try {
			hp.click_enquire();
			Thread.sleep(5000);
			hp.clickDealership();
			Thread.sleep(5000);
			WebElement states = driver.findElement(By.xpath("//button[text()='Andhra Pradesh']"));
			states.click();

			List<WebElement> dealers = driver
					.findElements(By.xpath("//div[contains(@class,'lg:bg-kawasaki')]/div/button"));
			System.out.println("Total count of dealers" + dealers.size());

			for (int i = 0; i < dealers.size(); i++) {
				   int stalecount = 0;
                   boolean clicked = false;
				while (stalecount < 3 && !clicked) {
					try {
						dealers = driver
								.findElements(By.xpath("//div[contains(@class,'lg:bg-kawasaki')]/div/button"));
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
				
				hp.clickDealership();
			}
			// hp.click_back();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

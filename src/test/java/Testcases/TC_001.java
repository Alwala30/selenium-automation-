package Testcases;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Pageobject.Homepage;
import utilities.excelutilty;

public class TC_001 extends Basetestclass {

	@Test

	public void main() throws IOException, InterruptedException

	{ 
		Homepage hp = new Homepage(driver);
		 int sum=0;
		
		try {
			hp.click_enquire();
			Thread.sleep(5000);
			hp.clickDealership();
			Thread.sleep(5000);
			List<WebElement>states=driver.findElements(By.xpath("//div[contains(@class,'lg:bg-kawasaki')]/div/div/button[contains(@class,'text-left p-[0.55vw]')]"));
			for (int j = 0; j < states.size(); j++)
			{
			  states=driver.findElements(By.xpath("//div[contains(@class,'lg:bg-kawasaki')]/div/div/button[contains(@class,'text-left p-[0.55vw]')]"));
			  
			  WebElement state=states.get(j);
			  String statename=state.getText();
			  state.click();

			List<WebElement> dealers = driver
					.findElements(By.xpath("//div[contains(@class,'lg:bg-kawasaki')]/div/button"));
			System.out.println("Total count of dealers" + " "  +  dealers.size() +" "+  "state:"+ statename);

			for (int i = 0; i < dealers.size(); i++) {
				   int stalecount = 0;
                   boolean clicked =false;
                   
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
				Thread.sleep(1000);
				String add=driver.findElement(By.xpath("//div[contains(@class,'bg-neutral-50 p-6 lg:p-[1.67vw]') ]/div[1]/p")).getText();
				System.out.println("Address:" + add);
				String tel =driver.findElement(By.xpath("//div[contains(@class,'bg-neutral-50 p-6 lg:p-[1.67vw]') ]/div[2]/p")).getText();
				System.out.println("Telephone:" + tel);
				String email=driver.findElement(By.xpath("//div[contains(@class,'bg-neutral-50 p-6 lg:p-[1.67vw]') ]/div[3]/p")).getText();
				System.out.println("email:" + email);
				sum=sum + dealers.size();
				
				
				hp.clickDealership();
			}
			    hp.click_back();
			}
			System.out.println("Total no. of Dealers are:"+sum);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

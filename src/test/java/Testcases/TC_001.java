package Testcases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
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
	  Homepage hp =new Homepage(driver);
	  hp.click_enquire();
	  Thread.sleep(5000);
	  hp.clickDealership();
	  Thread.sleep(5000);
	 
	  
	for(int i=0;i<3;i++)
	  {
	   try {
	  WebElement states=driver.findElement(By.xpath("//button[text()='Andhra Pradesh']"));
	       }
	   catch(Exception e)
	       { 
		   continue;
	       }
	  
	  };
	  
	  WebElement states=driver.findElement(By.xpath("//button[text()='Andhra Pradesh']"));
	states.click();
		  
       List<WebElement> dealers=driver.findElements(By.xpath("//div[contains(@class,'lg:bg-kawasaki')]/div/button"));

		  
		  for(WebElement dealer:dealers)
		  {
			  dealer.click();
			  String FilePath = System.getProperty("user.dir"+"\\TestData\\myfile.xlsx");
			  String add=driver.findElement(By.xpath("//div[contains(@class,'flex items-start gap-2.5 lg:gap-[0.7vw]')]/p")).getText();
			  String tel=driver.findElement(By.xpath("//img[contains(@alt,'telephone')]/following::span[text()='(Sales)']")).getText();
			  excelutilty data =new excelutilty();
			  data.setCellData(FilePath, add, tel);
			  hp.clickDealership();
			  break;
			  
		  }
		  hp.click_back();
		  ;
	  }
		  
	}	  
	    
    
			  
		  
	  
	  
    	
	
	
    

	
	
	
	


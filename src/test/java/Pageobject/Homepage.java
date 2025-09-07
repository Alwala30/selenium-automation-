package Pageobject;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Homepage extends CommonPage    //constructor

{
  public Homepage(WebDriver driver)	
  {
	  super(driver);
  }


  @FindBy (xpath="//div[@class='text-left']/button")   //Locators
   WebElement EnquireNow;
  
  @FindBy (xpath="//div[contains(@class,'col-span-1')]/div/button")
   WebElement Dealership;
  
  @FindBy (xpath="//div[contains(@class,'lg:bg-kawasaki')]/div/div/button[contains(@class,'text-left p-[0.55vw]')]")
  List<WebElement> States;
  
  @FindBy(xpath="//div[contains(@class,'lg:bg-kawasaki')]/div/button")
  List<WebElement> dealers;
  
  @FindBy (xpath="//span[contains(@class,'font-semibold font-accent uppercase')]")
   WebElement back;

  
  //Action Methods
  
  public void click_enquire()
  {
 	 EnquireNow.click();

  }
  
  public void click_back()
  {
 	 back.click();

  }

  public void clickDealership()
  {
	  Dealership.click();
	  
  }

  

}
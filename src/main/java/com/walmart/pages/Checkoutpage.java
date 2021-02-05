package com.walmart.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.walmart.Base.Baseclass;

public class Checkoutpage extends Baseclass{

	
	@FindBy(xpath="//button[contains(text(),'Checkout')]")//optional ph no field
	WebElement checkoutbtn;
	
	@FindBy(xpath="//button[@class='e5qqw234 css-1gezpl6 edzik9p0']")
	WebElement incitem;
	
	@FindBy(xpath="//button[@class='e5qqw233 css-1xgiecc edzik9p0']")//optional ph no field
	WebElement decitem;
	
	@FindBy(xpath="//button[@class='css-d4je81 ei50f4d14']")
	WebElement removeitem;
	
	@FindBy(xpath="//button[@class='css-vfxkzw edzik9p0']")
	WebElement proceedcheckout;
	
	public Checkoutpage()  {
		PageFactory.initElements(driver, this);//above all pagefactory initialization with this driver	
	}
	public String validateCheckoutpagepagetitle() {
		return driver.getTitle();
	}
	public String validateCheckoutpage() {
		checkoutbtn.click();
		incitem.click();
		decitem.click();
		removeitem.click();
		proceedcheckout.click();
		return null;	
	}		
	}

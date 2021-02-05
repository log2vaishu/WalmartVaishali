package com.walmart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.walmart.Base.Baseclass;

public class Addresspage extends Baseclass{

	@FindBy(xpath="//a[contains(text(),'Addresses')]")
	WebElement Addresses;
	
	@FindBy(xpath="//*[@id='shipping-first-name']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id='shipping-last-name']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id='shipping-address1']")
	WebElement Addrline1;
	
	@FindBy(xpath="//*[@id='shipping-address2']")
	WebElement Addrline2;
	
	@FindBy(linkText="//*[@id='shipping-city']")
	WebElement city;
	
	@FindBy(linkText="//*[@id='provinces']")
	WebElement province;
	
	@FindBy(xpath="//*[@id='shipping-postal-code']")
	WebElement postalcode;
	
	@FindBy(linkText="//*[@id='shipping-phone']")
	WebElement phone;
	
	@FindBy(linkText="//*[@id='save-address-btn']")
	WebElement savebtn;
	//*[@id="my-account-content"]/section/section[1]/div/h1
	@FindBy(linkText="//h1[contains(text(),'Addresses')]")
	WebElement titleaddress;
	
	public Addresspage()  {
		PageFactory.initElements(driver, this);	
	}
	public String validateAddresspagetitle() throws InterruptedException {
		Addresses.click();
		Thread.sleep(2000);
		return driver.getTitle();
	}

public boolean validateaddresstitle() throws InterruptedException {
		
		Thread.sleep(2000);	
		return titleaddress.isDisplayed();
	}

public void Address(String ftname,String ltname,String ph_no,String add1,String add2,String cty,String pcode,String prvnc) throws InterruptedException {
	
		Thread.sleep(2000);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		Addrline1.sendKeys(add1);
		Addrline1.sendKeys(add2);//optional
		phone.sendKeys(ph_no);
		city.sendKeys(cty);
		province.sendKeys(prvnc);//select province to click
		postalcode.sendKeys(pcode);
		savebtn.click();
	}	
}

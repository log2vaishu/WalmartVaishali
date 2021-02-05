package com.walmart.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.walmart.Base.Baseclass;

public class Searchpage extends Baseclass {
	
	@FindBy(xpath="//*[@class='e1xoeh2i1 css-ymj5ct eesbt950']")
	WebElement searchtext;
	
	@FindBy(xpath="//a[@class='css-n8po8v e1m8uw912']")
	WebElement click1stitem;
	
	@FindBy(xpath="//button[contains(text(),'Add to cart')]")
	WebElement insideaddtocart;
	// id=*[@id='search_a']
	@FindBy(xpath="//*[@class='css-f72ea9 e1xoeh2i4']")
	WebElement searchbtn;
	
	@FindBy(xpath="//label[contains(text(),'Category')]")
	WebElement category;
	
	@FindBy(xpath="//label[contains(text(),'Brand')]")
	WebElement Brand;
	
	@FindBy(xpath="//label[contains(text(),'Product Type')]")
	WebElement prodtype;
	
	@FindBy(xpath="//div[contains(text(),'Best Match')]")
	WebElement sortby;
	
	@FindBy(xpath="//*[contains(text(),'Price: Low to High')]")
	WebElement lowtohigh;
	
	@FindBy(xpath="//*[@class='css-1baqlt1 edzik9p0']")
	WebElement addtocart;
	//checkout
	@FindBy(xpath="//button[contains(text(),'Checkout')]")//optional ph no field
	WebElement checkoutbtn;
	
	@FindBy(xpath="//button[@class='e5qqw234 css-1gezpl6 edzik9p0']")
	WebElement incitem;
	
	@FindBy(xpath="//button[@class='e5qqw233 css-1xgiecc edzik9p0']")//optional ph no field
	WebElement decitem;
	
	@FindBy(xpath="//button[@class='css-d4je81 ei50f4d14']")
	WebElement removeitem;
	
	@FindBy(xpath="//button[contains(text(),'Proceed to checkout')]")
	WebElement proceedcheckout;
	
	public Searchpage()  {
		PageFactory.initElements(driver, this);//above all pagefactory initialization with this driver
	}
	public String validateSearchpagetitle() {
		return driver.getTitle();
	}
	public String validateSearchpage(String search) throws InterruptedException {
		searchtext.sendKeys(search);
		searchbtn.click();
		Thread.sleep(3000);
		category.click();
		prodtype.click();
		sortby.click();
		lowtohigh.click();
		return search;
	}	
	public String validateCheckoutpage(String search) throws InterruptedException {
		searchtext.sendKeys(search);
		searchbtn.click();
		Thread.sleep(3000);
		click1stitem.click();
		Thread.sleep(2000);
		insideaddtocart.click();
		Thread.sleep(2000);
		checkoutbtn.click();
		Thread.sleep(3000);
		incitem.click();
		Thread.sleep(1000);
		decitem.click();
		Thread.sleep(1000);
		removeitem.click();
		Thread.sleep(1000);
		proceedcheckout.click();
		return null;
	
}
}
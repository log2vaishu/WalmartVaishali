package com.walmart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.walmart.Base.Baseclass;

public class Myrecommendationpage extends Baseclass{
	
	@FindBy(xpath="//a[contains(text(),'My Recommendations')]")
	WebElement myrecmlink;
	
	@FindBy(xpath="//*[contains(text(),'Recommendations for')]")
	WebElement titlepage;
	
	@FindBy(xpath="//*[@id=\"thumb-6000202198562\"]/a/div[2]/div[2]/img")
	WebElement image;
	
	@FindBy(xpath="//*[@id=\"thumb-6000202198562\"]/div/button/span")
	WebElement productdetail;
	
	@FindBy(xpath="//*[@class='btn-txt' and contains(text(),'Add to cart')]")
	WebElement addtocart;
	
	public Myrecommendationpage() {
		PageFactory.initElements(driver, this);//above all pagefactory initialization with this driver
	}
	public String validatemyrecommendationpagetitle() throws InterruptedException {
		myrecmlink.click();
		Thread.sleep(5000);
		return driver.getTitle();
	}
	public String validatemyrecommendationvaishupagetitle() throws InterruptedException {
		titlepage.isDisplayed();
		Thread.sleep(2000);
		return driver.getTitle();
	}		
	public Checkoutpage validateimage() throws InterruptedException {
		 image.isDisplayed();
		 productdetail.isDisplayed();
		addtocart.click();
		return new Checkoutpage();
	}	
}

package com.walmart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.walmart.Base.Baseclass;

public class Mylistpage  extends Baseclass{
	
	// page factory or Obj repository
	
	@FindBy(xpath="//a[contains(text(),'Communication Preferences')]")
	WebElement CommuPreflink;
	//*[contains(text(),'My lists') and @class='eqw0yc05 css-y9g50w elkyjhv0']
	@FindBy(xpath="//a[contains(text(),'My lists')]")
	WebElement Mylistlink;
	
	@FindBy(xpath="//*[contains(text(),'Search for items you’d like to add to your list')]")
	WebElement title;
	//create new list
	@FindBy(xpath="//*[@id='save-list-input']")
	WebElement searchlistitem;
	
	@FindBy(xpath="//*[@id='save-list-button']")
	WebElement createlistbtn;
	//settings to rename list name 
	@FindBy(xpath="//button[@class='list-landing-settings']")
	WebElement settingsbtn;
	
	@FindBy(xpath="//*[@id='tab-1611010195184-0']")
	WebElement renamelist;
	
	@FindBy(xpath="//*[@id='panel-1611010195184-0']/div/input")
	WebElement enternewnamelist;
	
	@FindBy(xpath="//*[@id='panel-1611010195184-0']/div/button")
	WebElement savebtn;
	//delete list
	@FindBy(xpath="//*[@id='tab-1611010195184-1']")
	WebElement deletelistbtn;
	
	@FindBy(xpath="//*[@id='panel-1611010195184-1']/div/button[2]")
	WebElement deletebtn;
	
	@FindBy(xpath="//*[@id='panel-1611010195184-1']/div/button[1]")
	WebElement cancelbtn;
	//search input field
	@FindBy(xpath="//input[@name='embedded-search-form-input']")
	WebElement editsearch;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	WebElement searchbtn;
	
	public Mylistpage() {
		PageFactory.initElements(driver, this);//above all pagefactory initialization with this driver

	}
	public String validateMylistpagetitle() throws InterruptedException {
		CommuPreflink.click(); 
		Thread.sleep(3000);
		Mylistlink.click();
		 Thread.sleep(3000);
		return driver.getTitle();
		}
	public boolean validatetitleofMylistpage() throws InterruptedException {//actual title
		return title.isDisplayed();
		}
	
	public  void listcreate(String itemname,String newname,String searchnewitem) throws InterruptedException {
		
		searchlistitem.sendKeys(itemname);
		createlistbtn.click();
		settingsbtn.click();
		renamelist.click();
		enternewnamelist.sendKeys(newname);
		savebtn.click();
		deletelistbtn.click();
		deletebtn.click();
		//cancelbtn.click();
		editsearch.sendKeys(searchnewitem);
		searchbtn.click();	
		}	
}

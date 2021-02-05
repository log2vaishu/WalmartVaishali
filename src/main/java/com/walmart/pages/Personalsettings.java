package com.walmart.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.walmart.Base.Baseclass;

public class Personalsettings extends Baseclass{
	
	@FindBy(xpath="//a[contains(text(),'Personal Settings')]")//title page
	WebElement personalsettings;
	
	@FindBy(xpath="//h1[contains(text(),'Personal Settings')]")//title page
	WebElement title;
	
	//personal info
	@FindBy(xpath="//*[@id='set-edit-info']")
	WebElement editinfobtn;
	
	@FindBy(xpath="//*[@id='update-details-btn']")
	WebElement saveinfobtn;
	
	@FindBy(xpath="//*[@id='unset-edit-info']")
	WebElement cancelinfobtn;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@name='lastName']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement postalcode;
	//*[@id="phone"]
	@FindBy(xpath="//*[@id='phone']")
	WebElement phone;
	
	//email
	@FindBy(xpath="//*[@id='set-edit-email']")
	WebElement editemailbtn;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement email;
	
	@FindBy(xpath="//*[@id='email-password']")
	WebElement emailpswd;
	
	@FindBy(xpath="//*[@id='update-email-btn']")
	WebElement saveemailbtn;
	
	@FindBy(xpath="//*[@id='unset-edit-email']")
	WebElement cancelemailbtn;
	
	//password
	@FindBy(xpath="//*[@id='set-edit-password']")
	WebElement editpasswordbtn;
	
	@FindBy(xpath="//*[@id='oldPassword']")
	WebElement currentpswd;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement newpswd;
	
	@FindBy(xpath="//*[@id='confirmPassword']")
	WebElement confirmpswd;
	
	@FindBy(xpath="//*[@id='update-passwd-btn']")
	WebElement savepswdbtn;
	
	@FindBy(xpath="//*[@id='unset-edit-password']")
	WebElement cancelpswdbtn;
	
	//language preferrence
	
	@FindBy(xpath="//*[@id='set-edit-language']")
	WebElement editlanguagebtn;
	
	@FindBy(xpath="//*[@class='indent' and contains(text(),'English')]")
	WebElement languagechoose;
	
	@FindBy(xpath="//*[@id='update-language-btn']")
	WebElement savelanguagebtn;
	
	@FindBy(xpath="//*[@id='unset-edit-language']")
	WebElement cancellanguagebtn;
	
	//Associate Account
	
	@FindBy(xpath="//*[@id='add-associate']/a")
	WebElement link;
	
	@FindBy(xpath="//*[@id='win']")
	WebElement WIN;
	
	@FindBy(xpath="//*[@id='associate-change']/fieldset/label[4]/input")
	WebElement Discountcard;

	@FindBy(xpath="//input[@name='agree']")
	WebElement checkbox;
	
	@FindBy(xpath="//*[@id='update-associate-btn']")
	WebElement savebtn;
	
	@FindBy(xpath="//*[@id='unset-edit-associate']")
	WebElement cancelbtn;
	
	public Personalsettings()  {
		PageFactory.initElements(driver, this);	
	}
	public String validatePersonalsettingpagetitle() throws InterruptedException {
		personalsettings.click();
		Thread.sleep(3000);
		return driver.getTitle();
	}

public boolean validatePersonalsettinginsidetitle() throws InterruptedException {
	
	return title.isDisplayed();
	}

public void Personalinfo(String ftname,String ltname,String ph_no,String pcode) throws InterruptedException  {
	
		editinfobtn.click();
		Thread.sleep(2000);
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		phone.sendKeys(ph_no);
		postalcode.sendKeys(pcode);
		saveinfobtn.click();
		Thread.sleep(2000);
		//cancelinfobtn.click();
	}
public void Email(String eml,String pwd) throws InterruptedException {
	
	
	editemailbtn.click();
	Thread.sleep(3000);
	email.sendKeys(eml);
	emailpswd.sendKeys(pwd);
	//saveemailbtn.click();
	Thread.sleep(2000);
	cancelemailbtn.click();
    }

public void password(String old,String newpwd,String confirm) throws InterruptedException {
	
	editpasswordbtn.click();
	Thread.sleep(2000);
	currentpswd.sendKeys(old);
	newpswd.sendKeys(newpwd);
	confirmpswd.sendKeys(confirm);
	//savepswdbtn.click();
	Thread.sleep(2000);
	cancelpswdbtn.click();
}
public void language() throws InterruptedException {
	
	
	editlanguagebtn.click();
	Thread.sleep(2000);
	languagechoose.click();
	//savelanguagebtn.click();
	Thread.sleep(2000);
	cancellanguagebtn.click();
}
public void associate(String Win,String Cardno) throws InterruptedException {
	
	 link.click();
	 Thread.sleep(2000);
	 WIN.sendKeys(Win);
	 Discountcard.sendKeys(Cardno);
	 checkbox.click();
	 //savebtn.click();
	 Thread.sleep(2000);
	 cancelbtn.click();
}
}

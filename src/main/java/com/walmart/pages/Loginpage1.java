package com.walmart.pages;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.walmart.pages.MyAccountpage;
import com.walmart.Base.Baseclass;

public class Loginpage1 extends Baseclass{
	
	// page factory or Obj repository
	
	@FindBy(xpath="//*[@id=\"sparklogo_Layer_1\"]")
	WebElement walmartlogo;
	
	@FindBy(xpath="//span[contains(text(),'My account')]")
	WebElement myaccountlink;
	
	@FindBy(linkText="Sign in")
	WebElement signinlink;
	
	//dirct sign in:
	@FindBy(xpath="//input[@id='username']")
	WebElement emailid;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement pswd1;
	
	//join now:
	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement signinlinkbtn;
	
	@FindBy(linkText="Join now")
	WebElement joinnowlink;
	
	@FindBy(xpath="//*[@id='firstName']")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id='lastName']")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id='phoneNumber']")//optional ph no field
	WebElement phno;
	
	@FindBy(xpath="//*[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement pswd;
	
	@FindBy(xpath="//input[@id='marketingPreference']") //optional checkbox
	WebElement chbox1;
	
	@FindBy(xpath="//input[@id='TAndC']")
	WebElement chbox2;
	
	@FindBy(xpath="//button[@class='css-vfxkzw edzik9p0']")
	WebElement createaccountbtn;

	//create method now:
	public Loginpage1() {
		//super();
		PageFactory.initElements(driver, this);//above all pagefactory initialization with this driver
	}
	
	public String validateloginpagetitle1() {
			return driver.getTitle();
		}
	
	public boolean validatelogo() {
			return walmartlogo.isDisplayed();
		}
	
	public MyAccountpage login(String ftname,String ltname,String ph_no,String Email,String pwd) throws InterruptedException {
		 Actions action=new Actions(driver);
			
			action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'My account')]"))).build().perform();
			
			Thread.sleep(2000); //to add wait time
			joinnowlink.click();
			firstname.sendKeys(ftname);
			lastname.sendKeys(ltname);
			phno.sendKeys(ph_no);
			email.sendKeys(Email);
			pswd.sendKeys(pwd);
			chbox1.click();
			chbox2.click();
			createaccountbtn.click();
			
			return new MyAccountpage();
		}

	public MyAccountpage signin(String usnm, String pd) throws InterruptedException {
  /*  Actions action=new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'My account')]"))).build().perform();
		//.build and .perform is used to implement action.
		//Thread.sleep(2000); //to add wait time
		
		WebDriverWait wt = new WebDriverWait(driver, 30);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign in")));
	   driver.findElement(By.linkText("Sign in")).click();  */
		
		driver.findElement(By.xpath("//*[contains(text(),'My account')]")).click();
		Thread.sleep(2000);
		emailid.sendKeys(usnm);
		pswd1.sendKeys(pd);
		signinlinkbtn.click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[contains(text(),'My account')]")).click();
		
		return new MyAccountpage();
		
	}
	
}

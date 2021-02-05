package com.walmart.testcases;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.walmart.Base.Baseclass;
import com.walmart.pages.Loginpage1;
import com.walmart.pages.MyAccountpage;
import com.walmart.testutil.Testutil;

public class Loginpagetest extends Baseclass{
	
	Loginpage1 loginpage;
	MyAccountpage myaccountpage;
	Testutil testutil;
	
	public Loginpagetest() {     //constructor created immediately after class creation
		super();                //before initialization1 you have to call parent class by super
	}
@BeforeTest
	public void setup() throws IOException {    //call browser setup method from baseclass
	initialization1();
		loginpage=new Loginpage1();
		myaccountpage= new MyAccountpage();
		
}
@Test(priority=1)
	public void loginpageTitleTest() {//gives you title
		String title=loginpage.validateloginpagetitle1();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping Canada:Everyday Low Prices at Walmart.ca!");
}
@Test(priority=2)
	public void loginpageLogoTest() {
	boolean logo=loginpage.validatelogo();
	Assert.assertTrue(logo);	
} 
/*@Test(priority=3)
	public void loginTest() throws InterruptedException {//it call myaccountpage class
		myaccountpage=loginpage.login("Vaishali","Gajjar","6393188565", prop.getProperty("username"), prop.getProperty("password"));
		//username=email here
		System.out.println("login successful");
} */
@Test(priority=4)
public void signinTest() throws InterruptedException  {//it call myaccountpage class
	myaccountpage=loginpage.signin(prop.getProperty("username"), prop.getProperty("password"));
	//username=email here
	//driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[5]/div/label")).click();
	System.out.println("login successful");
}
@AfterTest
	public void teardown() {
		driver.close();
}
}



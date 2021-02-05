package com.walmart.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.walmart.Base.Baseclass;
import com.walmart.pages.Loginpage1;
import com.walmart.pages.MyAccountpage;
import com.walmart.pages.Mylistpage;
import com.walmart.testutil.Testutil;
public class MylistTest extends Baseclass{
	Mylistpage mylistpage;
	Loginpage1 loginpage;
	MyAccountpage myaccountpage;
	CommunicationPreferencespage communicationpreferencespage;
	Testutil testutil;
	
	public  MylistTest() {     //constructor created immediately after class creation
		super();                //before initialization1 you have to call parent class by super
	}
@BeforeTest
	public void setup() throws InterruptedException, IOException {    //call browser setup method from baseclass
	initialization1();
		mylistpage=new Mylistpage();
		loginpage=new Loginpage1();	
		myaccountpage=loginpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		driver.findElement(By.xpath("//*[contains(text(),'My account')]")).click();
		//driver.findElement(By.xpath("//span[@class='sign-in-message']")).click();
		myaccountpage=new MyAccountpage();
		testutil = new Testutil();
		myaccountpage=new MyAccountpage();
}
@Test(priority=1)
	public void MylistpageTitleTest() throws InterruptedException {//gives you title
		String title=mylistpage.validateMylistpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "Walmart Canada");
}
@Test(priority=2)
	public void MylistpageLogoTest() throws InterruptedException {//actual title display
	boolean logo=mylistpage.validatetitleofMylistpage();
	//Assert.assertTrue(logo);	
} 
@Test(priority=3)
public void wincardTest() throws InterruptedException  {//it call myaccountpage class
	mylistpage.listcreate("babyfood", "kids", "toys");
	System.out.println("list created successfully");
}
@AfterTest
	public void teardown() {
		driver.close();
}
}

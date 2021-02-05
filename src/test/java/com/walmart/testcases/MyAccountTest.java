package com.walmart.testcases;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import com.walmart.pages.MyAccountpage;
import com.walmart.pages.Orderhistorypage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.walmart.Base.Baseclass;
import com.walmart.pages.Addresspage;
import com.walmart.pages.Loginpage1;
import com.walmart.pages.Mainpage;

import com.walmart.testutil.Testutil;

public class MyAccountTest extends Baseclass{
	Loginpage1 loginpage;
	MyAccountpage myaccountpage;
	Testutil testutil;
	Mainpage mainpage;

	public MyAccountTest(){     //constructor created immediately after class creation
		super();                //before initialization1 you have to call parent class by super
	}
@BeforeTest
	public void setup() throws InterruptedException, IOException {    //call browser setup method from baseclass
		initialization1();
		loginpage=new Loginpage1();	
		myaccountpage=loginpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		driver.findElement(By.xpath("//*[contains(text(),'My account')]")).click();
		//driver.findElement(By.xpath("//span[@class='sign-in-message']")).click();
		myaccountpage=new MyAccountpage();
		testutil = new Testutil();
		myaccountpage=new MyAccountpage();
		mainpage=new Mainpage();
}
@Test(priority=1)
	public void myaccountpageTitleTest() {//gives you title
		String title=myaccountpage.validatemyaccountpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "Walmart Canada");
}
@Test(priority=2)
public void promocodeTest() {
	Orderhistorypage title=myaccountpage.validatemyaccountpagepromocode();
	System.out.println(title);
	myaccountpage.validatemyaccountpagepromocodeenter("123456");
}
@Test(priority=3)
public void LogoutTest() {
	myaccountpage.signout();
}
@Test(priority=4)
public void searchmainpageTest() {//it call myaccountpage class & also go to mainpage walmart.ca
Mainpage search=myaccountpage.Mainpage();
System.out.println(search);
}
@AfterTest
	public void teardown() { 
		driver.close();
}

}

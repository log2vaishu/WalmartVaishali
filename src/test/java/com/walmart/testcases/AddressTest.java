package com.walmart.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.walmart.Base.Baseclass;
import com.walmart.pages.Addresspage;
import com.walmart.pages.Loginpage1;
import com.walmart.pages.MyAccountpage;
import com.walmart.pages.Mylistpage;
import com.walmart.testutil.Testutil;

public class AddressTest extends Baseclass{
	Addresspage address;
	Loginpage1 loginpage;
	MyAccountpage myaccountpage;
	Testutil testutil;
	
	public AddressTest() {     //constructor created immediately after class creation
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
		address=new Addresspage();
}
@Test(priority=1)
	public void AddressTitleTest() throws InterruptedException {//gives you title
		String title=address.validateAddresspagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping Canada:Everyday Low Prices at Walmart.ca!");
}
@Test(priority=2)
	public void AddresspagetitleTest() throws InterruptedException {
	boolean logo=address.validateaddresstitle();
	   Assert.assertTrue(logo);	
} 
@Test(priority=3)
public void AddresssigninTest() throws InterruptedException  {//it call myaccountpage class
	address.Address("Jatin", "Gajjar","6393188565", "Unit-103","286 Chandler Dr", "Kitchener", "N2E3J8", "Canada");
	//username=email here
	System.out.println("Address successfully saved");
}

@AfterTest
	public void teardown() {
		driver.close();
}
}


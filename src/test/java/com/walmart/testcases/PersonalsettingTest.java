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
import com.walmart.pages.Personalsettings;
import com.walmart.testutil.Testutil;

public class PersonalsettingTest extends Baseclass{
	Personalsettings Personalsetting;
	Loginpage1 loginpage;
	MyAccountpage myaccountpage;
	Testutil testutil;
	
	public PersonalsettingTest() {     //constructor created immediately after class creation
		super();                //before initialization1 you have to call parent class by super
	}
@BeforeTest
	public void setup() throws InterruptedException, IOException {    //call browser setup method from baseclass
	initialization1();
		loginpage=new Loginpage1();
		Personalsetting =new Personalsettings();
		myaccountpage=loginpage.signin(prop.getProperty("username"), prop.getProperty("password"));
		driver.findElement(By.xpath("//*[contains(text(),'My account')]")).click();
		//driver.findElement(By.xpath("//span[@class='sign-in-message']")).click();
		myaccountpage=new MyAccountpage();
		testutil = new Testutil();
}
@Test(priority=1)
	public void PersonalsettingpageTitleTest() throws InterruptedException {//gives you title
		String title=Personalsetting.validatePersonalsettingpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, " Walmart Canada");
}
@Test(priority=2)
	public void PersonalsettingpageLogoTest() throws InterruptedException  {
	boolean logo=Personalsetting.validatePersonalsettinginsidetitle();
	Assert.assertTrue(logo);	
} 
@Test(priority=3)
	public void PersonalinfoTest() throws InterruptedException {

	Personalsetting.Personalinfo("Vaishali", "Gajjar", "6393188565", "N2E3J8");
	
	System.out.println("Personal info done successfully");
}
@Test(priority=4)
public void emailTest() throws InterruptedException  {
	Personalsetting.Email("vjg@123", "hivaishu123");
	System.out.println("email successful");
}

@Test(priority=5)
public void passwordTest() throws InterruptedException  {
	Personalsetting.password("hivaishu123", "hivaishu@123", "hivaishu@123");
	System.out.println("password set successful");
}

@Test(priority=6)
public void languageTest() throws InterruptedException  {
	Personalsetting.language();
	System.out.println("language selected successful");
}

@Test(priority=7)
public void wincardTest() throws InterruptedException  {//it call myaccountpage class
	Personalsetting.associate("dhf#$%^d23", "abcD123");
	System.out.println("email successful");
}
@AfterTest
	public void teardown() {
		driver.close();
}

}

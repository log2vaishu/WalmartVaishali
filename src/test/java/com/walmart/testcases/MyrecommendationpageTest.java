package com.walmart.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.walmart.Base.Baseclass;
import com.walmart.pages.Checkoutpage;
import com.walmart.pages.Loginpage1;
import com.walmart.pages.MyAccountpage;
import com.walmart.pages.Myrecommendationpage;
import com.walmart.testutil.Testutil;

public class MyrecommendationpageTest extends Baseclass{
	Checkoutpage checkoutpage;
	Myrecommendationpage myrecommendation;
	Loginpage1 loginpage;
	MyAccountpage myaccountpage;
	Testutil testutil;
	
	public MyrecommendationpageTest() {
		super();
		
	}
@BeforeTest
	public void setup() throws InterruptedException, IOException   {    //call browser setup method from baseclass
		initialization1();
			loginpage=new Loginpage1();
			checkoutpage=new Checkoutpage();
			myaccountpage=loginpage.signin(prop.getProperty("username"), prop.getProperty("password"));
			driver.findElement(By.xpath("//*[contains(text(),'My account')]")).click();
			//driver.findElement(By.xpath("//span[@class='sign-in-message']")).click();
			myaccountpage=new MyAccountpage();
			testutil = new Testutil();
}
@Test(priority=1)
	public void myrecommendationpageTitleTest() throws InterruptedException {//gives you title
		String title=myrecommendation.validatemyrecommendationpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "My Recommendations Walmart Canada");
}
@Test(priority=2)
public void myrecommendationTest() throws InterruptedException {//it call myarecommendationpage class
	String title=myrecommendation.validatemyrecommendationvaishupagetitle();
	System.out.println(title);
}
@Test(priority=3)
public void myrecommendationimageTest() throws InterruptedException  {//it call myarecommendationpage class
	myrecommendation.validateimage();
}
@AfterTest
	public void teardown() {
		driver.close();
}

}
	

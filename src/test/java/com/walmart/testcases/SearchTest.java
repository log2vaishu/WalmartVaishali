package com.walmart.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.walmart.Base.Baseclass;
import com.walmart.pages.Checkoutpage;
import com.walmart.pages.Loginpage1;
import com.walmart.pages.MyAccountpage;
import com.walmart.pages.Myrecommendationpage;
import com.walmart.pages.Searchpage;
import com.walmart.testutil.Testutil;

public class SearchTest extends Baseclass{
	Searchpage search;
	Loginpage1 loginpage;
	MyAccountpage myaccountpage;
	Checkoutpage checkoutpage;
	Testutil testutil;
	
	public SearchTest() {
		super();
	}
	@BeforeTest
	public void setup() throws IOException  {    //call browser setup method from baseclass
		initialization1();
		//loginpage=new Loginpage1();
		// checkoutpage=new Checkoutpage();
		search=new Searchpage();
}
@Test(priority=1)
	public void SearchpageTitleTest() {//gives you title
		String title=search.validateSearchpagetitle();
		System.out.println(title);
		Assert.assertEquals(title, "Online Shopping Canada:Everyday Low Prices at Walmart.ca!");
}
@Test(priority=2)
public void SearchpageTest() throws InterruptedException {//it call searchpage class
	String title=search.validateSearchpage("Apple");  //search item
	System.out.println(title);
	System.out.println("Search done");
}
@Test(priority=3)
public void checkoutpageTest() {//it call myaccountpage class
	String title=checkoutpage.validateCheckoutpage();
	System.out.println(title);
	System.out.println("checkout done");
}
@AfterTest
	public void teardown() {
		driver.close();
}

}



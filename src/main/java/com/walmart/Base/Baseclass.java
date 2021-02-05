package com.walmart.Base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.chainsaw.Main;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.walmart.testutil.Testutil;
import com.walmart.testutil.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver; //global variables:making them static means we can use them in other classes too
	public static Properties prop; // global variable:static can be used with classname
	
	public static EventFiringWebDriver e_driver;////we will specify variable for event driver & listeners
	public static WebEventListener eventListener;
	
	//step 1
	public  Baseclass() {//constructor
		try {
			prop = new Properties();//config.properties location (path)provide below
			FileInputStream file=new FileInputStream("D:\\eclipse-workspace\\WalmartProject\\src\\main\\java\\com\\walmart\\config\\config.properties");
		prop.load(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		
		} catch(IOException e) {
		e.printStackTrace();
	}
}
	/*public static void main(String[] args) {
		initialization1();
	}*/
		//step 2
		public static void initialization1() throws IOException {    //browser setup method
				
		//read properties from config file
			String Browsername=prop.getProperty("browser");
			System.out.println(Browsername);
		    System.out.println(prop.getProperty("url"));
			if (Browsername.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver","D:\\vaishu SW QA\\geckodriver.exe");//firefox
			     driver = new FirefoxDriver(); //launch firefox		
			}
			else if(Browsername.equals("Chrome")) {
				//System.setProperty("webdriver.chrome.driver","D:\\vaishu SW QA\\chromedriver.exe");
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}
		
		//WebEventListener class created inside all project base package where we create testutil class
			e_driver=new EventFiringWebDriver(driver);
			WebEventListener eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver=e_driver;
			
		//we will specify common features
			driver.manage().window().maximize(); 
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);//time can be changes according to page, so we will put static variable in testutil.java class
			driver.get(prop.getProperty("url")); //prop is defined at global level so we can use it anywhere
	}

}

package com.walmart.testutil;
import java.io.File;
import java.io.IOException;
import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.walmart.Base.Baseclass;


public class Testutil extends Baseclass {

		public Testutil()  {
		super();
		// TODO Auto-generated constructor stub
	}
		public static long PAGE_LOAD_TIMEOUT=20;
		public static long IMPLICIT_WAIT=10;
		
		public void switchtoframe() {
			//driver.switchTo().frame(0);
			driver.switchTo().frame(driver.findElement(By.id("google_ads_iframe_10337976/en/gm/homepage_0__container__")));
			
		}	public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // This line is for WebDriver
			
			String currentDir =System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")); //Add throw declaration

		}
	}



package com.walmart.testcases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	@Test
	public void extentreport() {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("extent .html");
	spark.config().setTheme(Theme.DARK);
	//spark.config().setTheme(Theme.STANDARD);
	spark.config().setDocumentTitle("Walmart Extent Report");
	ExtentTest test = extent.createTest("Walmart Test");
	ExtentTest node = test.createNode("Node");
	node.pass("All testcases Pass");
	node.fail("some Fail");
	node.info("working properly");
	test.pass("started successfully");
	test.info("working");
    test.fail("failed plz check");
    
    Throwable t = new RuntimeException("A runtime exception");
    ExtentTest test1 = extent.createTest("MyFirstTest");
    test.pass("Text details");
    test.log(Status.PASS, "Text details");
    test1.pass("pass");
    //test1.log(Status.FAIL, t);


 // reference image saved to disk
 test1.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());

 // base64
 test1.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());

	// fluent
	ExtentTest node1 = extent.createTest("MyFirstTest") .createNode("Node")   .pass("Pass");

	//ExtentKlovReporter klov = new ExtentKlovReporter("MyProject")  .initWithDefaultSettings();
	extent.attachReporter(spark);
	//extent.createTest("MyFirstTest")
	 // .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
	//extent.flush();

	
extent.flush();

	
	}

}

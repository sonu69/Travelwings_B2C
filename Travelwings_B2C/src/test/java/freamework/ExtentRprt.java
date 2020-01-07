package freamework;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.Helper;

public class ExtentRprt {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	
	
	@BeforeClass
	public void beforeclass() {
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/sonu"+".html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@Test
	public void tc1() {
		test = extent.createTest("Name", "My name");
		System.out.println("sonu kumar");
	}
	
	
	@Test
	public void tc2() {
		test = extent.createTest("Name", "My brother1");
		System.out.println("Ravi  kumar");
	}
	
	
	@Test
	public void tc3() {
		test = extent.createTest("Name", "My brother1");
		System.out.println("Parveen kumar");
	}
	
	
	@Test
	public void tc4() {
		test = extent.createTest("Name", "Father");
		System.out.println("Hrishikesh singh kumar");
	}
	
	
	@Test
	public void tc5() {
		test = extent.createTest("Name", "My Mother");
		System.out.println("Madhu rani");
	}

	@AfterMethod
	public void teardown() {
		extent.flush();
	}

}

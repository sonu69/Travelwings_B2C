package freamework;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import pages.FlightResult_Page;
import pages.Itinerary_Page;
import pages.PaymentMethods_Page;
import pages.SearchWidget_Page;
import pages.TravellerDetails_Page;
import utils.Baseclass;
import utils.Helper;


public class Framework1 extends Baseclass{
	private WebDriver driver;
	SearchWidget_Page sp;
	FlightResult_Page fr;
	Itinerary_Page it;
	TravellerDetails_Page tv;
	PaymentMethods_Page pm;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest logger;

	@BeforeClass
	public void browserfactory() {
		driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://newuat.travelwings.com/");
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/sonu"+".html"));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@Test(description="search widget page")
	public void tc1() throws InterruptedException {

		logger = extent.createTest("Search Widget Page");
		sp = new SearchWidget_Page(driver);
		sp.add_origin();
		sp.add_destination();
		sp.addDepartureDate();
		sp.addReturnDate();
		sp.addTraveller();
		fr = sp.search_submit();
	}


	@Test(description="Flight result page")
	public void tc2() throws InterruptedException {
		logger = extent.createTest("Flight result page");
		it = fr.flight_select();
	}

	@Test(description="Itinerary page")
	public void tc3(){
		logger = extent.createTest("Itinerary page");
		it.continue_itinerary();
		tv = it.guest_user();
		tv.add_pax();
		pm = tv.continue_button();
	}

	@AfterMethod
	public void teardown(ITestResult result) throws Exception {
//		if(result.getStatus()==ITestResult.FAILURE) {
//			String temp = Helper.getScreenshot(driver);
//			logger.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS) {
//			String temp = Helper.getScreenshot(driver);
//			logger.pass("Pass", MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
//		}
		Helper.getScreenshot(driver);
		extent.flush();
	}

}

package freamework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FlightResult_Page;
import pages.Itinerary_Page;
import pages.PaymentMethods_Page;
import pages.SearchWidget_Page;
import pages.TravellerDetails_Page;
import utils.Baseclass;

public class Framework1 extends Baseclass{
	private WebDriver driver;
	SearchWidget_Page sp;
	FlightResult_Page fr;
	Itinerary_Page it;
	TravellerDetails_Page tv;
	PaymentMethods_Page pm;
	
	@BeforeClass
	public void browserfactory() {
		driver = getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://newuat.travelwings.com/");	
	}
	
	@Test
	public void tc1() throws InterruptedException {
		sp = new SearchWidget_Page(driver);
		sp.add_origin();
		sp.add_destination();
		sp.addDepartureDate();
		
		sp.addTraveller();
		fr = sp.search_submit();
		it = fr.flight_select();
		it.continue_itinerary();
		tv = it.guest_user();
		tv.add_pax();
		pm = tv.continue_button();
	
	}
	
	
	

}

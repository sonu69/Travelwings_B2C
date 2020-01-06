package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchWidget_Page {

	private WebDriver driver;

	@FindBy(id="pills-flights-tab") WebElement flight;

	@FindBy(id="pills-hotels-tab") WebElement hotel;

	@FindBy(id="origin_0") WebElement origin;

	@FindBy(id="destination_0") WebElement destination;

	@FindBy(id="journeyDate_0") WebElement journeydate;

	@FindBy(id="returnDate_0") WebElement returndate;

	@FindBy(id="onwardCabinClass") WebElement onwardclass;

	@FindBy(id="returnCabinClass") WebElement returnclass;

	@FindBy(xpath="//span[@class='traveler-text']") WebElement traveller;
	
	@FindBy(xpath="//div[@ng-show='flight.openTraveller']/div[@class='cancel']") WebElement cancel_traveller;

	@FindBy(xpath="//button[@class='bttn-primary']") WebElement search_flight;

	@FindBy(xpath="//span[@data-ng-bind='headerCurrency']") WebElement country_select;

	@FindBy(id="userSelectedCountry_title") WebElement select_country;

	@FindBy(id="currency_title") WebElement select_currency;

	@FindBy(id="userName") WebElement my_Account;

	@FindBy(xpath="//a[@href='/login']") WebElement login;

	@FindBy(xpath="//a[@href='/signup']") WebElement sign_up;

	@FindBy(xpath="//span[text()='Non Stop']") WebElement non_stop;

	@FindBy(xpath="//span[text()='Multi-city route']") WebElement multicity;

	@FindBy(id="AdvacedSearch") WebElement advance_search;

	@FindBy(xpath="//input[@ng-model='inputValue']") WebElement preferred_airlines;


	public SearchWidget_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public boolean verify_title() {
		String title = driver.getTitle();
		boolean status = title.contains("Travelwings");
		return status;
	}

	

	
	
	public void add_origin() {
		String org = "Delhi";
		origin.sendKeys(org);
		Actions act = new Actions(driver);
		WebElement origin_add=driver.findElement(By.xpath("//div[@class='ctyname' and contains(text(),'"+org+"')]"));
		act.moveToElement(origin_add).build().perform();
		origin_add.click();
		
		
	}


	public void add_destination() {
		String dept = "Dubai";
		destination.sendKeys(dept);
		WebElement dest_add=driver.findElement(By.xpath("//div[@class='ctyname' and contains(text(),'"+dept+"')]"));
		Actions act = new Actions(driver);
		act.moveToElement(dest_add).build().perform();
		dest_add.click();
	}
	
	
	
	
	public void addDepartureDate() {
		String day = "22";
		String month = "March";
		String year = "2020";

		journeydate.click();

		for(int i=0;i<12;i++) {
			String cal_month = driver.findElements(By.xpath("//span[@class='ui-datepicker-month']")).get(0).getText();
			String cal_year = driver.findElements(By.xpath("//span[@class='ui-datepicker-year']")).get(0).getText();
			if(cal_month.equalsIgnoreCase(month) && cal_year.equalsIgnoreCase(year)) {
				WebElement cal_day = driver.findElements(By.xpath("//a[text()='"+day+"']")).get(0);
				if(cal_day.isDisplayed()&&cal_day.isEnabled()) {
					cal_day.click();
				}
				break;
			}else {
				WebElement next_button = driver.findElement(By.xpath("//a[@title='Next']"));
				next_button.click();
			}
		}
	}

	
	public void addReturnDate() {
		String day = "26";
		String month = "March";
		String year = "2020";

		returndate.click();

		for(int i=0;i<12;i++) {

			String cal_month = driver.findElements(By.xpath("//span[@class='ui-datepicker-month']")).get(0).getText();
			String cal_year = driver.findElements(By.xpath("//span[@class='ui-datepicker-year']")).get(0).getText();

			if(cal_month.equalsIgnoreCase(month) && cal_year.equalsIgnoreCase(year)) {

				WebElement cal_day = driver.findElements(By.xpath("//a[text()='"+day+"']")).get(0);
				if(cal_day.isDisplayed()&&cal_day.isEnabled()) {
					cal_day.click();
				}
				break;
			}else {
				WebElement next_button = driver.findElement(By.xpath("//a[@title='Next']"));
				next_button.click();
			}
		}
	}

	
	public void addOnwardClass() {
		onwardclass.click();
		String departclass="Economy";
		driver.findElements(By.xpath("//span[@data-ng-bind='cabin' and text()='"+departclass+"']")).get(0).click();
	}
	
	
	public void addReturnClass() {
		onwardclass.click();
		String returnclass="Economy";
		driver.findElements(By.xpath("//span[@data-ng-bind='cabin' and text()='"+returnclass+"']")).get(0).click();
	}


	public void addTraveller() {
		int a = 1;
		int c = 1;
		int f = 1;
		
		driver.findElement(By.xpath("//span[@class='traveler-text']")).click();
		
		for(int i=1;i<a;i++) {
			driver.findElement(By.xpath("//button[@data-ng-click='flight.addAdult()']")).click();
		}
		
		for(int i=0;i<c;i++) {
			driver.findElement(By.xpath("//button[@data-ng-click='flight.addChild()']")).click();
		}
		
		for(int i=0;i<f;i++) {
			driver.findElement(By.xpath("//button[@data-ng-click='flight.addInfant()']")).click();
		}
		
		cancel_traveller.click();
		
	}

	
	public FlightResult_Page search_submit(){
		search_flight.click();
		return new FlightResult_Page(driver);
	}
	

	public Login_Page click_login() {		
		if(my_Account.isDisplayed() && my_Account.isEnabled()) {
			my_Account.click();
		}
		login.click();
		return new Login_Page();
	}
	
	
	public SignUp_Page click_signup() {		
		if(my_Account.isDisplayed() && my_Account.isEnabled()) {
			my_Account.click();
	}
		sign_up.click();
		return new SignUp_Page();
	}
	
	
	
	
	
	
	
	
	
	
}

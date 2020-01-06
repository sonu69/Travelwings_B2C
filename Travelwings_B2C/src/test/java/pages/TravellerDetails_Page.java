package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TravellerDetails_Page {

	private WebDriver driver;

	@FindBy(xpath="//h6[contains(text(),'Adult')]") List <WebElement> adults;

	@FindBy(xpath="//h6[contains(text(),'Child')]") List <WebElement> childs;

	@FindBy(xpath="//h6[contains(text(),'Infant')]") List <WebElement> infants;

	@FindBy(xpath="//select[@name='Title']") List <WebElement> titles;

	@FindBy(xpath="//div[text()='First Name']/../div/input") List <WebElement> firstname;

	@FindBy(xpath="//div[text()='Last Name']/../div/input") List <WebElement> lastname;

	@FindBy(xpath="//input[@data-ng-model='booking.dob[$index]']") List <WebElement> dob;

	@FindBy(xpath="//div[@class='col-sm-8 type ng-scope']/input[2]") List <WebElement> phone;

	@FindBy(xpath="//input[@data-ng-model='booking.selectedTraveller[$index].passportNo']") List <WebElement> passport;

	@FindBy(xpath="//input[@data-ng-model='booking.passportExpireDate[$index]']") List <WebElement> exp_date;

	@FindBy(xpath="//select[@id='countryId']") List <WebElement> nationality;

	@FindBy(xpath="//button[text()='CONTINUE' and @class='bttn-yellow']") WebElement continue_button;


	public TravellerDetails_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public void add_pax() {
		
		List<WebElement> adults = driver.findElements(By.xpath("//h6[contains(text(),'Adult')]"));
		
		List<WebElement> childs = driver.findElements(By.xpath("//h6[contains(text(),'Child')]"));
		
		List<WebElement> infants = driver.findElements(By.xpath("//h6[contains(text(),'Infant')]"));
		
		List<WebElement> titles= driver.findElements(By.xpath("//select[@name='Title']"));
		
		List<WebElement> firstname = driver.findElements(By.xpath("//div[text()='First Name']/../div[2]/input"));
				
		List<WebElement> lastname = driver.findElements(By.xpath("//div[text()='Last Name']/../div[2]/input"));

		List<WebElement> dob = driver.findElements(By.xpath("//input[@data-ng-model='booking.dob[$index]']"));
		
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='col-sm-8 type ng-scope']/input[2]"));
		
		List<WebElement> passport = driver.findElements(By.xpath("//input[@data-ng-model='booking.selectedTraveller[$index].passportNo']"));
		
		List<WebElement> exp_date = driver.findElements(By.xpath("//input[@data-ng-model='booking.passportExpireDate[$index]']"));
		
		List <WebElement> nationality = driver.findElements(By.xpath("//select[@id='countryId']"));
		
		
		int adult_size = adults.size();
		int child_size = childs.size();
		int infant_size = infants.size();
		
		
		for(int i=0;i<adult_size;i++) {
			
			if(i>=1) {
			adults.get(i).click();
			}
			
			
			Select sl = new Select(titles.get(i));
			String title = "Mr.";
			sl.selectByVisibleText(title);
			
			String first_name = "Sonu";
			firstname.get(i).sendKeys(first_name);
			String last_name = "Kumar";
			lastname.get(i).sendKeys(last_name);

			
			String dob1 = "03071991";
			
			dob.get(i).sendKeys(dob1);
			
			String phone_number = "9905040207";
			phone.get(0).sendKeys(phone_number);

			String passport_exp = "J892305";
			passport.get(i).sendKeys(passport_exp);
			
			String exp = "12122020";
			exp_date.get(i).sendKeys(exp);

			Select nation = new Select(nationality.get(i));
			String country = "India";
			nation.selectByVisibleText(country);
			
		}
		
		int m =adult_size;
		for(int j=0;j<child_size;j++) {
			
			childs.get(j).click();
			
			Select sl = new Select(titles.get(j+m));
			String title = "Master";
			sl.selectByVisibleText(title);
			
			String first_name = "Shameek";
			firstname.get(j+m).sendKeys(first_name);
			
			String last_name = "Vats";
			lastname.get(j+m).sendKeys(last_name);
			
			String date = "05022015";
			
			dob.get(j+m).sendKeys(date);

			String passport_exp = "J892305";
			passport.get(j+m).sendKeys(passport_exp);

			String expiry_date = "12122020";
			
			exp_date.get(j+m).sendKeys(expiry_date);


			Select nation = new Select(nationality.get(j+m));

			String country = "India";

			nation.selectByVisibleText(country);
			
		}
		
		
		int l =adult_size+child_size;
		for(int k=0;k<infant_size;k++) {
			
			infants.get(k).click();
			
			Select sl = new Select(titles.get(k+l));
			String title = "Master";
			sl.selectByVisibleText(title);
			
			String first_name = "Tushare";
			firstname.get(k+l).sendKeys(first_name);
			String last_name = "Vats";
			lastname.get(k+l).sendKeys(last_name);
			
			String date = "17112018";			
			dob.get(k+l).sendKeys(date);

			String passport_exp = "J892305";
			passport.get(k+l).sendKeys(passport_exp);

			String expiry_date = "12122020";
			
			exp_date.get(k+l).sendKeys(expiry_date);


			
			Select nation = new Select(nationality.get(k+l));
			String country = "India";
			nation.selectByVisibleText(country);
			
		}
	}


	
	
	
	public void adult_Details() {

		for(int i=0;i<adult_size();i++) {

			if(i>=1) {
				adults.get(i).click();
			}

			Select sl = new Select(titles.get(i));
			String title = "Mr.";
			sl.selectByVisibleText(title);

			String f_name = "sonu";
			firstname.get(i).sendKeys(f_name);

			String l_name = "kumar";
			lastname.get(i).sendKeys(l_name);


			dob.get(i).isDisplayed();
			String a_dob="03071991";
			dob.get(i).sendKeys(a_dob);

			if(phone.get(i).isDisplayed()) {
			String a_phone="9905040207";
			phone.get(i).sendKeys(a_phone);
			}

			if(passport.get(i).isDisplayed()) {
			String a_passport="J892305";
			passport.get(i).sendKeys(a_passport);
			}

			if(exp_date.get(i).isDisplayed()) {
			String a_expdate="03072025";
			exp_date.get(i).sendKeys(a_expdate);
			}

			if(nationality.get(i).isDisplayed()) {
			String a_nationality="India";
			Select sl_nat = new Select(nationality.get(i));
			sl_nat.selectByVisibleText(a_nationality);
			}
			
		}
	}


	public void child_Details() {

		for(int i=0;i<child_size();i++) {

			childs.get(i).click();
			
			Select sl = new Select(titles.get(0));
			String title = "Master";
			sl.selectByVisibleText(title);

			String f_name = "Tushare";
			firstname.get(0).sendKeys(f_name);

			String l_name = "Vats";
			lastname.get(0).sendKeys(l_name);


			dob.get(0).isDisplayed();
			String a_dob="17111991";
			dob.get(0).sendKeys(a_dob);

			if(phone.get(0).isDisplayed()) {
			String a_phone="990504207";
			phone.get(0).sendKeys(a_phone);
			}

			if(passport.get(0).isDisplayed()) {
			String a_passport="J892305";
			passport.get(0).sendKeys(a_passport);
			}

			if(exp_date.get(0).isDisplayed()) {
			String a_expdate="17112025";
			exp_date.get(0).sendKeys(a_expdate);
			}

			if(nationality.get(0).isDisplayed()) {
			String a_nationality="India";			
			Select sl_nat = new Select(nationality.get(0));
			sl_nat.selectByVisibleText(a_nationality);
			}
		}
	}
	
	
	public void infant_Details() {

		for(int i=0;i<adult_size();i++) {
			
			infants.get(i).click();

			Select sl = new Select(titles.get(0));
			String title = "Master";
			sl.selectByVisibleText(title);

			String f_name = "Shameek";
			firstname.get(0).sendKeys(f_name);

			String l_name = "Vats";
			lastname.get(0).sendKeys(l_name);


			dob.get(0).isDisplayed();
			String a_dob="05021990";
			dob.get(0).sendKeys(a_dob);

			if(phone.get(0).isDisplayed()) {
			String a_phone="9905040207";
			phone.get(0).sendKeys(a_phone);
			}

			if(passport.get(0).isDisplayed()) {
			String a_passport="J892305";
			passport.get(0).sendKeys(a_passport);
			}

			if(exp_date.get(0).isDisplayed()) {
			String a_expdate="05022025";
			exp_date.get(0).sendKeys(a_expdate);
			}

			if(nationality.get(0).isDisplayed()) {
			String a_nationality="India";
			Select sl_nat = new Select(nationality.get(0));
			sl_nat.selectByVisibleText(a_nationality);
			}
			
		}
	}
	

	public int adult_size() {
		return adults.size();
	}

	public int child_size() {
		return childs.size();
	}

	public int infant_size() {
		return infants.size();
	}





	public PaymentMethods_Page continue_button() {
		continue_button.click();
		return new PaymentMethods_Page(driver);
		
	}

}

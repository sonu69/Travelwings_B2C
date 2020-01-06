package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Itinerary_Page {

	private WebDriver driver;
	
	@FindBy(xpath="//button[contains(@class,'bttn-yellow yellow-button')]")  WebElement continue_button;
	
	@FindBy(xpath="//div[@class='user-name']/input") WebElement guest_email;
	
	@FindBy(xpath="//button[text()='CONTINUE']") List <WebElement> guest_continue;
	
	@FindBy(xpath="div[@class='user-name']/input") WebElement username;
	
	@FindBy(xpath="//div[@class='user-name ng-scope']/input") WebElement password;
	
	@FindBy(xpath="//button[@id='submit-form']") WebElement registered_continue;
	
	public Itinerary_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public String page_title() {
		String title = driver.getTitle();
		return title;
	}
	
	
	public void continue_itinerary() {
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();",continue_button);
	}
	
	
	public TravellerDetails_Page guest_user() {
		guest_email.sendKeys("sonu.kumar@techtreeit.com");
		guest_continue.get(0).click();
		return new TravellerDetails_Page(driver);
	}
	
	
	public TravellerDetails_Page registered_user() {
		username.sendKeys("");
		password.sendKeys("");
		registered_continue.click();
		return new TravellerDetails_Page(driver);
	}
	
	
	
}

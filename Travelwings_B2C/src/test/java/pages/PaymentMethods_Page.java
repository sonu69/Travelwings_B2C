package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PaymentMethods_Page {
	
	private WebDriver driver;
	
	@FindBy(name="cardNumber") WebElement card_number;
	
	@FindBy(name="cardHolderName") WebElement card_name;
	
	@FindBy(id="cvvNumber") WebElement cvv;
	
	@FindBy(name="expMonth") WebElement exp_month;
	
	@FindBy(name="expYear") WebElement exp_year;
	
	@FindBy(name="checkbox") WebElement terms;
	
	@FindBy(xpath="//button[contains(text(),'MAKE PAYMENT')]") WebElement make_payment;
	
	
	public PaymentMethods_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	public BookingConfirmation_Page payment_action() {
		
		card_number.sendKeys("4000000000000051");
		
		card_name.sendKeys("john doe");
		
		cvv.sendKeys("111");
		
		Select slm = new Select(exp_month);
		slm.selectByVisibleText("12");
		
		Select sly = new Select(exp_year);
		sly.selectByVisibleText("2020");
		
		terms.click();
		
		make_payment.click();
		
		return new BookingConfirmation_Page();
		
	}
	
	

}

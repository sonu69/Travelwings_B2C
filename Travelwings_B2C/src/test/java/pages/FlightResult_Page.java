package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FlightResult_Page {

	private WebDriver driver;

	public FlightResult_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}


	public Itinerary_Page flight_select() throws InterruptedException {
	
		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[text()='Select']"));
		
		select_buttons.get(0).click();
		
//		for(int i=0;i<10;i++) {
//			JavascriptExecutor js = ((JavascriptExecutor) driver);
//			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//			Thread.sleep(1000);
//		}
//
//
//		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[text()='Select']"));
//
//		String flightname = "Spicejet";
//
//		List <WebElement> flights_name= driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
//
//		for(int j=0;j<flights_name.size();j++) {
//
//			if(flightname.equalsIgnoreCase(flights_name.get(j).getText())) {
//
//				select_buttons.get(j).click();
//				break;
//
//			}
//
//			else if(j==flights_name.size()-1) {
//				System.out.println("unable to find flight");
//			}
//		}

		return new Itinerary_Page(driver);
	}

}

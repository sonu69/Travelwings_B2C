package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SearchWidget_Page;

public class SearchWidgets_Page {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		 WebDriver driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.get("https://test.techtreeit.in/");
		 
		driver.findElement(By.id("origin_0")).sendKeys("del");
		Actions act = new Actions(driver);
		
		WebElement origin_add=driver.findElement(By.xpath("//div[@class='ctyname' and text()='New Delhi (DEL)']"));
		act.moveToElement(origin_add).build().perform();
		origin_add.click();
		
		driver.findElement(By.id("destination_0")).sendKeys("dxb");
		WebElement dest_add=driver.findElement(By.xpath("//div[@class='ctyname' and text()='Dubai (DXB)']"));
		act.moveToElement(dest_add).build().perform();
		dest_add.click();

		SearchWidget_Page sw = new SearchWidget_Page(driver);
		sw.addDepartureDate();
		sw.addReturnDate();
		sw.addTraveller();
		sw.search_submit();
		
		Thread.sleep(50000);
		
		for(int i=0;i<10;i++) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);
		}


		List<WebElement> select_buttons=driver.findElements(By.xpath("//button[@class='bttn-search']"));
		
		String flightname = "SpiceJet";
		
		List <WebElement> flights_name= driver.findElements(By.xpath("//p[@class='travel-company-name ng-binding']"));
		
		for(int j=0;j<flights_name.size();j++) {

			if(flightname.equalsIgnoreCase(flights_name.get(j).getText())) {

				select_buttons.get(j).click();
				break;
				
			}
			
			else if(j==flights_name.size()-1) {
				System.out.println("unable to find flight");
			}
		
			
			
			

		}
	}


}

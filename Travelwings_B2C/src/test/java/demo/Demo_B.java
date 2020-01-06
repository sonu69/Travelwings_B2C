package demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Demo_B {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://test.techtreeit.in/");
		
		int a = 5;
		int c = 5;
		int f = 3;
		
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
		
		driver.findElement(By.xpath("//div[@ng-show='flight.openTraveller']/div[@class='cancel']")).click();
		
		driver.findElement(By.xpath("//button[@class='bttn-primary']")).click();
		

	}
}
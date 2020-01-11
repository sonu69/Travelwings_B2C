package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_C {


	@Test
	public void testcase() {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://test.techtreeit.in/");
		
		driver.manage().window().maximize();
		
		driver.get("https://test.techtreeit.in");
		
		driver.findElement(By.xpath("//a[text()='CONTACT US']")).click();
	}
	
}

package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public WebDriver driver;
	
	public WebDriver getDriver() {
		WebDriverManager.firefoxdriver().setup();
		 driver = new FirefoxDriver();
		return driver;
	}
	
	
	

	

	
}

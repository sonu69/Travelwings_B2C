package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo_C {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--headless");
		op.setHeadless(false);
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		
		driver.get("https://test.techtreeit.in/");

	}

}

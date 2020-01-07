package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Helper {
	
	public static String getCurrentDateTime() {
		DateFormat customer_format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date current_date = new Date();
		return customer_format.format(current_date);
		 
	}

	public static String takescreenshot(WebDriver driver) throws Exception {

		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/sonu"+".png";
		
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
	    
		try {
			ImageIO.write(fpScreenshot.getImage(),"PNG",new File(screenshotpath));
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	     return screenshotpath;
	}
	
}

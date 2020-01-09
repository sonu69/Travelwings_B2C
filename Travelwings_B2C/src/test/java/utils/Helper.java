package utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

import javax.imageio.ImageIO;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

	public static String getScreenshot(WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/Screenshots/sonu "+System.currentTimeMillis()+".png";
		File destination = new File(path);
		FileUtils.copyFile(src, destination);
		
		return path;
		
	}

	public static String takescreenshot(WebDriver driver) throws Exception {		
		String path = System.getProperty("user.dir")+"/Screenshots/sonu "+System.currentTimeMillis()+".png";
		Screenshot fpScreenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		try {
			ImageIO.write(fpScreenshot.getImage(),"PNG",new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	     return path;
	}
}

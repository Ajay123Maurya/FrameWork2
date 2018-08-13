package utils;

import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

/**
 * 
 * Author : Manmeet Kumar
 * 
 */

public class BrowserFactory {

	protected Data data = Data.getInstance();
	public static RemoteWebDriver driver;
	protected Helper helper = new Helper();

	@BeforeClass
	public RemoteWebDriver initializeBrowser() throws IOException {
		if (System.getProperty("os.name").contains("Mac")) {
			System.setProperty("webdriver.chrome.driver", "src/resources/mac/chromedriver");
			

		} else {
			System.setProperty("webdriver.chrome.driver", "src/resources/linux/chromedriver");
		}
		
		try{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		catch(Exception e){
			driver = null;
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return driver;
	}
	
	
/*
	@AfterClass
	public void tearDown() {
		driver.quit();
	}*/

}

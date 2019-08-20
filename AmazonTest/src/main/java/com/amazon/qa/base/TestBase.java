package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.util.Utility;

public class TestBase {
	static WebDriver driver;
	static Properties prop;
	
	public TestBase() {
		try {
			prop=new Properties();
			
			FileInputStream fis=new FileInputStream("C:\\JUnit\\eclipse-workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		}
		
				
	}

	
	public static void initialization() {
		//fetch the browser name
		String browseName=prop.getProperty("browser");
		if(browseName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/mytools/chromedriver.exe");
			
			//launching chrome browser
			driver=new ChromeDriver();
		}else {
			System.setProperty("webdriver.gecko.driver", "C:/mytools/geckodriver.exe");
			
			//launching firefox browser
			driver=new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(Utility.page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.implicit_wait, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
		
	}
}

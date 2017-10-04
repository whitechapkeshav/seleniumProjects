package com.naukri.accelerators;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class ActionEngine {

	String browsers;
	protected static WebDriver driver;

	@Parameters({ "browser" })
	@BeforeTest
	public void pre(String browser) {


		this.browsers = browser;
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("ie")) {
			File file = new File("Drivers\\IEDriverServer32.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			File file = new File("Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		}
//		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@AfterTest
	public void post() {
		driver.close();
	}

}

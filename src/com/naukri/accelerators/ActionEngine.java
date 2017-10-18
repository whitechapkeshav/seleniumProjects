package com.naukri.accelerators;

import java.io.File;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
			DesiredCapabilities capa = DesiredCapabilities.firefox();
			capa.setVersion("36");
			capa.setPlatform(Platform.WINDOWS);
			driver = new FirefoxDriver();
		}
		if (browser.equalsIgnoreCase("ie")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

			capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

			File file = new File("Drivers\\IEDriverServer32.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
		}
		if (browser.equalsIgnoreCase("chrome")) {

			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability("version", "61.0");
			cap.setCapability("platform", "windows");

			File file = new File("Drivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
			driver = new ChromeDriver();
		}
		// driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
	}

	@AfterTest
	public void post() {
		driver.close();
	}

}

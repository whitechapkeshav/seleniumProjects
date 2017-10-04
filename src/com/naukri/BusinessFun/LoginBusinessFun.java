package com.naukri.BusinessFun;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;

import com.naukri.accelerators.ActionEngine;
import com.naukri.objectRepo.LoginRepo;

public class LoginBusinessFun extends ActionEngine {

	public void closeWindows() {
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String win : windows) {
			if (!win.equals(parent)) {
				driver.switchTo().window(win);
				driver.close();
			}
			driver.switchTo().window(parent);
		}
	}

	public void LauncUrl(String Url) {
		driver.navigate().to(Url);
		driver.manage().window().maximize();
	}

	public String ReadDataFromConfig(String name) {
		String names = null;
		try {
			File f = new File("config.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties pr = new Properties();
			pr.load(fis);
			names = pr.getProperty(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
	}

	public void LoginPage() {

		driver.findElement(LoginRepo.uname).sendKeys("keshav.rajapanthula@gmail.com");
		driver.findElement(LoginRepo.pass).sendKeys("0@RChinni");
		driver.findElement(LoginRepo.submit).submit();
	}
}

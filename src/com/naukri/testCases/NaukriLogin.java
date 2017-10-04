package com.naukri.testCases;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.naukri.BusinessFun.LoginBusinessFun;
import com.naukri.objectRepo.LoginRepo;

public class NaukriLogin extends LoginBusinessFun {

	@Test
	public void mainMethod() throws InterruptedException {
		String url = ReadDataFromConfig("Naukri_URL");
		LauncUrl(url);
		closeWindows();
		String url1 = ReadDataFromConfig("Naukri_URL_Navigate");
		LauncUrl(url1);
		LoginPage();
		driver.findElement(LoginRepo.viewEdit).click();
		driver.findElement(LoginRepo.editphoto).click();
		Thread.sleep(1000);
		driver.findElement(LoginRepo.browse).sendKeys("C:\\Users\\white_000\\Downloads\\1291921_10152197919190744_1894658008_n.jpg");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		driver.findElement(LoginRepo.closePop).click();
	}

	/*
	 * @DataProvider() public Object[][] read() {
	 * 
	 * return TestUtil.getData("Naukri","Login"); }
	 */

}

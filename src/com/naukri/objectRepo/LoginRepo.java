package com.naukri.objectRepo;

import org.openqa.selenium.By;

public class LoginRepo {
	public static By uname = By.id("emailTxt");
	public static By pass = By.id("pwd1");
	public static By submit = By.name("logFormN");

	public static By viewEdit = By.cssSelector("button.w205");
	public static By editphoto = By.cssSelector("a.dspB");
	public static By closePop = By.cssSelector("a#phUpC");
	public static By browse = By.xpath("//input[@id='inpFile']");

}

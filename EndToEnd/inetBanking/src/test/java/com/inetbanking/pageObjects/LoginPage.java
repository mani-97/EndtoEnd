package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name="uid")
	public WebElement txtUserName;	
	@FindBy(name="password")
	public WebElement txtPassword;
	@FindBy(name="btnLogin")
	public WebElement btnLogin;
	@FindBy(xpath="//a[text()='Log out']")
	public WebElement btnLogout;

	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		btnLogin.click();
	}
	public void clickLogout() {
		btnLogout.click();
	}




}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	// Encapsulation
	//1. Private - By Locators and OR :
	private By email = By.id("email");
	private By password = By.id("passwd");
	private By signIn_btn = By.id("SubmitLogin");
	private By forgotPwd_link = By.linkText("Forgot your password?");
	
		
	//2. Constructor of the page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}	
	
	//3. public - Page Actions

	public String getLoginPageTitle() {		
		return driver.getTitle();
	}
	
	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwd_link).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(username);		
	}
	
	public void enterPassword(String strpassword) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strpassword);		
	}
	
	public void clickOnLoginButton() {
		driver.findElement(signIn_btn).click();		
	}
	
	public AccountsPage doLogin(String un, String pass) {
		System.out.println("Login with username:: " + un + " and password :: " + pass);
		enterUserName(un);
		enterPassword(pass);
		clickOnLoginButton();
		return new AccountsPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

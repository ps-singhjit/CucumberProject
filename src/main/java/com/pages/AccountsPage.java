package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;

	// Encapsulation
	// 1. Private - By Locators and OR :
	private By accountSections = By.cssSelector("div#center_column span");
	

	// 2. Constructor of the page class:
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. public - Page Actions
	public int getAccountSectionCount() {
		int size = driver.findElements(accountSections).size();
		return size;
	}
	
	public String getAccountsPageTitle() {
		return driver.getTitle();
	}
	
	public List<String> getAccountSectionList() {
		
		List<String> namesList = new ArrayList<>();
		List<WebElement> accountsHeaderList = driver.findElements(accountSections);
		for(WebElement elem: accountsHeaderList) {
			String text = elem.getText();
			System.out.println(text);
			namesList.add(text);
		}
		return namesList;
	}
	
}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	Actions action;

	// Page Factory -OR;
	@FindBy(name = "email")
	WebElement email;

	@FindBy(xpath = "//input[@name='password']")
	WebElement password;

	@FindBy(xpath = "//*[@id=\'ui\']/div/div/form/div/div[3]")
	WebElement loginBtn;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public HomePage login(String un_email, String pwd) {
		action = new Actions(driver);
		action.sendKeys(email, un_email).build().perform();
		action.sendKeys(password, pwd).build().perform();
		loginBtn.click();
		return new HomePage();
	}
}

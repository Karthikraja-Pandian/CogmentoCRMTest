package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	Actions action = new Actions(driver);
	
	// Page Factory -OR;
	@FindBy(xpath = "//div[@id='top-header-menu']//div")
	WebElement headerImage;

	@FindBy(xpath = "//span[contains(text(),'Karthik Raja')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//i[contains(@class, 'users icon')]/parent::a")
	WebElement contactsLink;

	@FindBy(xpath = "//span[contains(text(),'Deals')]")
	WebElement dealsLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean verifyHeaderImage() {
		return headerImage.isDisplayed();
	}

	public String verifyUserNameLabel() {
		return userNameLabel.getText();
	}

	public ContactsPage clickOnContactsLink(){
		action.moveToElement(contactsLink).click().build().perform();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		action.moveToElement(dealsLink).click().build().perform();
		dealsLink.click();
		return new DealsPage();
	}
}

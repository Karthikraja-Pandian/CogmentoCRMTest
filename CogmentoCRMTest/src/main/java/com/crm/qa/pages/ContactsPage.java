package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	Actions action = new Actions(driver);
	
	// Page Factory -OR;
	@FindBy(xpath = "//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement contactsLabel;
	
	@FindBy(linkText = "Create")
	WebElement newContactsPageBtn;
	
	@FindBy(name = "first_name")
	WebElement firstName;
	
	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Email address')]")
	WebElement emailAddress;
	
	@FindBy(xpath = "//*[@id=\'dashboard-toolbar\']/div[2]/div/button[2]")
	WebElement saveBtn;
	

	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		}
	
	//Actions
	public String verifyContactsPageLabel() {
		return contactsLabel.getText();
	}
	
	public void selectContactsByEmail(String email) {
		WebElement checkBox = driver.findElement(By.xpath("//td[text()='"+email+"']"));
		action.moveToElement(checkBox).click().build().perform();
	}
	
	public void clickOnNewContactList() {
		newContactsPageBtn.click();
	}
	
	public void createNewContactList(String f_name, String l_name, String email_add) {
		firstName.sendKeys(f_name);
		lastName.sendKeys(l_name);
		emailAddress.sendKeys(email_add);
		saveBtn.click();
	}
	
	
}

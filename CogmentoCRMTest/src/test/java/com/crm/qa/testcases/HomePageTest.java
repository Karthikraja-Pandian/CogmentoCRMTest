package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void headerImageTest() {
		boolean flag = homePage.verifyHeaderImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 2)
	public void userNameLabelTest() {
		String username_label = homePage.verifyUserNameLabel();
		Assert.assertEquals(username_label, "Karthik Raja");
	}

	@Test(priority = 3)
	public void contactsPageTest() {
		homePage.clickOnContactsLink();
	}

	@Test(priority = 4)
	public void dealsPageTest() {
		homePage.clickOnDealsLink();
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}

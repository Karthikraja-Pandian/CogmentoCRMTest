package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetName = "Contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil =new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login succcessful");
		homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void contactsPageLabelTest() {
		String contacts_label = contactsPage.verifyContactsPageLabel();
		Assert.assertEquals(contacts_label, "Contacts");
	}
	
	@Test(priority=2)
	public void selectContactsByEmailTest() {
		contactsPage.selectContactsByEmail("chiran@gmail.com");
	}
	
	@DataProvider
	public Object[][] getCogmentoTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3, dataProvider="getCogmentoTestData")
	public void validateCreateNewContact(String firstName, String lastName, String email){
		contactsPage.clickOnNewContactList();;
		contactsPage.createNewContactList(firstName, lastName, email);
		
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	
}

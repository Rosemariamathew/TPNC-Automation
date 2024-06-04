package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.CartPage;
import Pages.Homepage;
import Pages.LoginPage;


public class CartFunctionality extends baseClass {
	
	LoginPage loginPage;
	Homepage homePage;
	CartPage cartPage;

	
	@BeforeClass
	public void preConditionSteps(String URL) {
		browserSetUp(URL);
		loginPage = new LoginPage();
		homePage = new Homepage();
		cartPage = new CartPage();
	}
	
	@Test
	public void TC_01_VerifyMiniCartIconandAmount()throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com", "julia@123");
		Assert.assertTrue(homePage.CartIcon.isDisplayed());
		Assert.assertTrue(homePage.CartAmount.isDisplayed());
		logger = report.createTest("TC_01_VerifyMiniCartIcon"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}
	
	

	@Test
	public void TC_02_VerifyMiniCartAmountFormat() {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com", "julia@123");
		isElementToBeClicked(homePage.SearchInputField);
		homePage.enterTextInSearchInputField("WC-41V24");
		
		
		String CartAmtWithNoItem = "$0.00";	//to fetch the amount value from then cart (No Item)
		Assert.assertTrue(homePage.CartAmount.equals(CartAmtWithNoItem), "");
		logger = report.createTest("TC_02_VerifyMiniCartAmountFormat"); // logger - ExtentTest component
	}
	
	
	
	@Test
	public void TC_03_VerifyMiniCartRedirect() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		scrollToAndClickElement(homePage.CartIcon);
		Thread.sleep(3000);
		String PageTitle = "Shopping Cart";
		Assert.assertEquals(getDriver().getTitle(), PageTitle);
		logger = report.createTest("TC_03_VerifyMiniCartRedirect"); // logger - ExtentTest component
	}

}

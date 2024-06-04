package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.Homepage;
import Pages.LoginPage;

public class HeaderAndFooterLinks extends baseClass {
	
	Homepage homePage;
	LoginPage loginPage;
	
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		loginPage = new LoginPage();
		homePage = new Homepage();
	}
	
	@Test
	public void TC_01_testHeaderLoginLink()throws InterruptedException {
		homePage.clickLoginLink();
		String ExpPageTitle = "Log in | Register";
		isElementDisplayed(loginPage.HeadingTitle);
		String ActPagetitle = getDriver().getTitle();
		Assert.assertTrue(ActPagetitle.equals(ExpPageTitle), "User not logged in");
		logger = report.createTest("TC_01_testHeaderLoginLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	@Test
	public void TC_02_testUserNameDisplayedAfLogin() {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com", "julia@123");
		String expectedName = "IDEAL AUTO & INDUSTRIAL SUPPLY (NAPA WHITECOURT)";
		String uName = homePage.getUserNameTextAfterLogin();
		Assert.assertEquals(expectedName, uName);
		logger = report.createTest("TC_02_testUserNameDisplayedAfLogin"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_03_testHdrContactUsLink() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		homePage.clickContactUsHdrLink();
		boolean condition = getTitleOfPage("Platinum North America Contact Us");
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_03_testHdrContactUsLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_04_testHdrAboutUsLink() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		homePage.clickAboutUsHdrLink();
		boolean condition = getTitleOfPage("About Us");
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_04_testHdrAboutUsLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_05_testHdrGrinderLifeLink() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		homePage.clickGrinderLifeHdrLink();
		boolean condition = getTitleOfPage("GRINDER FOR LIFE");
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_05_testHdrGrinderLifeLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_06_testHdrQuickOrderLink() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		Thread.sleep(2000);
		homePage.clickQuickOrderHdrLink();
		boolean condition = getTitleOfPage("Shopping Cart");
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_06_testHdrQuickOrderLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_07_testAccountOverViewSubLinks() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		homePage.clickAccountOverviewSubLink("Invoices"); // hard code - Enter the link text
		boolean condition = getTitleOfPage("Invoices"); // hard code - Enter title of the page
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_07_testAccountOverViewSubLinks"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_08_testAccountOverViewLink() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		homePage.clickAccountOverViewLink();
		boolean condition = getTitleOfPage("Welcome!");
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_08_testAccountOverViewLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_09_testCategoryMenuList(String emailAdd, String pass) throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin(emailAdd, pass);
		boolean condition = homePage.hoverCategoryMenuAndClickItem("WELDING", "WELDING MACHINES", "WELDING MACHINES");
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_09_testCategoryMenuList"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_10_testSocialMediaLinks() throws InterruptedException {
		String linkedInTitle = "Platinum North America | LinkedIn";
		String XTitle = "Log in to X / X";
		String FbTitle = "Platinum North America | Edmonton AB | Facebook";
		String InstaTitle = "Platinum North America (@platinumnainc) • Instagram photos and videos";
		String YtTitle = "Platinum North America - YouTube";
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		Thread.sleep(3000);
		homePage.clickSocialMediaHdrLink("LinkedIn");
		windowHandling();
		Assert.assertTrue(getTitleOfPage(linkedInTitle));
		logger = report.createTest("TC_10_testSocialMediaLinks"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_11_testFooterAcctAndCateLink() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		homePage.clickFtrAcctAndCatgLinks("SAFETY");
		Thread.sleep(2000);
		boolean condition = getTitleOfPage("SAFETY");
		Assert.assertTrue(condition, "The user redirected to the wrong page");
		logger = report.createTest("TC_11_testFooterAcctAndCateLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_12_testFooterBlogLink(String emailAdd, String pass) throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		homePage.clickFtrBlogLinks("PLATINUM DEMO VAN");
		Thread.sleep(2000);
		boolean condition = getTitleOfPage("platinum-demo-van");
		Assert.assertTrue(condition, "The user redirected to the wrong blog page");
		logger = report.createTest("TC_12_testFooterBlogLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}

	
	@Test
	public void TC_13_testSignOutLink() throws InterruptedException {
		homePage.clickLoginLink();
		loginPage.userLogin("julia@jobinandjismi.com","julia@123");
		Thread.sleep(2000);
		boolean condition = homePage.clickSignOutLink();
		Assert.assertTrue(condition, "User not logged out");
		logger = report.createTest("TC_13_testSignOutLink"); // logger - ExtentTest component
		// ExcelUtil.setExcelFile();
	}


}

package TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;

import Pages.Homepage;
import Pages.LoginPage;
import Pages.PDPPage;

import Pages.SearchResultPage;

public class SearchingFunctionality extends baseClass {
	LoginPage loginPage;
	Homepage homePage;
	SearchResultPage searchResultPage;
	PDPPage pdpPage;

	@BeforeClass
	public void preConditionSteps(String URL) {
		browseropening();
		loginPage = new LoginPage();
		homePage = new Homepage();
		searchResultPage = new SearchResultPage();
		pdpPage = new PDPPage();
	}
	
	
	@Test
	//User performs a valid search and sees suggestions.
	public void TC_01_testValidSearchWithSuggestions() throws InterruptedException { 
		homePage.enterTextInSearchInputField("Welding Cable");	//hard code
		Assert.assertTrue(homePage.SearchItemSuggList.size() > 0, "No results shown");
		logger = report.createTest("TC_01_testValidSearchWithSuggestions"); // logger - ExtentTest component
		//ExcelUtil.setExcelFile();
	}

	@Test
	// User performs an invalid search and sees no suggestions.
	public void TC_02_testInvalidSearchNoSuggestions() {
		homePage.enterTextInSearchInputField("1213115");	//hard code
		Assert.assertTrue(isElementDisplayed(homePage.NoSearchResultText),"No empty search result message is displayed");
		logger = report.createTest("TC_02_testInvalidSearchNoSuggestions"); // logger - ExtentTest component
		//ExcelUtil.setExcelFile();
	}
	
	@Test	
	//User clicks on the "See all results" link.
	public void TC_03_testSeeAllResultsLink() throws InterruptedException {
		homePage.enterTextInSearchInputField("Metal Polish");	//hard code
		homePage.clickSeeAllResultsLink();
		Assert.assertTrue(isElementDisplayed(searchResultPage.BreadCrumbText),"User not redirected to the search page");
		logger = report.createTest("TC_03_testSeeAllResultsLink"); // logger - ExtentTest component
		//ExcelUtil.setExcelFile();
	}
	
	@Test	
	//User clicks on a suggestion from the search results dropdown.
	public void TC_04_testClickOnSuggestion() {
		homePage.enterTextInSearchInputField("Metal Polish");	//hard code
		homePage.clickAnyItemFromSearchSugg("REBEL RED");	//REBEL RED
		Assert.assertTrue(pdpPage.getBannerName("REBEL RED"));
		logger = report.createTest("TC_04_testClickOnSuggestion"); // logger - ExtentTest component
		//ExcelUtil.setExcelFile();
	}
	
	@Test	
	//User performs a valid search and sees the correct number of suggestions (up to 4).
	public void TC_05_testNumberOfSuggestionsDisplayed() {
		getDriver().navigate().refresh();
		homePage.enterTextInSearchInputField("Welding Cable");	//hard code
		Assert.assertTrue(homePage.SearchItemSuggList.size() <= 4, "No results shown");
		logger = report.createTest("TC_05_testNumberOfSuggestionsDisplayed"); // logger - ExtentTest component
		//ExcelUtil.setExcelFile();
	}
	
	@Test	
	//User performs a search and sees the correct number of items displayed on the search results page.
	public void TC_06_testNumberOfItemsOnSearchResultsPage() throws InterruptedException {
		homePage.enterTextInSearchInputField("Welding Cable");	//hard code
		homePage.clickGoBtn();
		Assert.assertTrue(isElementDisplayed(searchResultPage.BreadCrumbText),"User not redirected to the search page");
		Assert.assertTrue(searchResultPage.getResultCount(), "Number of search results does not match data quantity attribute.");
		logger = report.createTest("TC_06_testNumberOfItemsOnSearchResultsPage"); // logger - ExtentTest component
		//ExcelUtil.setExcelFile();
	}
	
	

}

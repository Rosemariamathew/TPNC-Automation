package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.Homepage;

public class SearchFunctionality extends baseClass{
	Homepage homePage;
  
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		homePage = new Homepage();
	}
	
	
	@Test
	public void step1() {
		homePage.searching("Razor");
	}
	
	
}

package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.Homepage;


public class CategorySectionHomepage extends baseClass{
	
Homepage homePage;
	
	
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		homePage = new Homepage();
	}
	
	@Test
	public void step1() throws InterruptedException {
		homePage.AbrasiveClick();
		
	}
	
	@Test
	public void step2() {
		homePage.WeldingClick();
	}
	
	@Test
	public void step3() {
		homePage.SafetyClick();
	}
	
	@Test
	public void step4() {
		homePage.PolishingClick();
	}
	
	@Test
	public void step5() {
		homePage.RhodiusClick();
	}
	
	@Test
	public void step6() {
		homePage.InstockClick();
	}
	


}

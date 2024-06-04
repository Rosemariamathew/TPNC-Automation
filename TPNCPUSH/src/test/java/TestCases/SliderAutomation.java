package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.Homepage;

public class SliderAutomation extends baseClass {
	
	Homepage homePage;
	  
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		homePage = new Homepage();
	}
	
	
	@Test
	public void step2() {
		homePage.ProductSlider("WELDING SCREENS");
	}
	
	
	
	public void step1() throws InterruptedException  {
		homePage.clickSliderImage();
	}
	
	@Test
	public void step3() {
		homePage.UrlValidation("https://www.platinumna.com/WELDING-SCREENS");
	}
	
	
	
  
}

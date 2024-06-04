package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.PLPPage;

public class CategorySectionSelection extends baseClass{
	
	PLPPage plpPage;
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		plpPage = new PLPPage();
	}
  @Test
  public void Step1() throws InterruptedException {
	  plpPage.ClickOnDesiredCategory("RHODIUS");
  }

}

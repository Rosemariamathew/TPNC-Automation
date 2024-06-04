package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.PLPPage;

public class SortingSectionFunctionality extends baseClass {
	PLPPage plpPage;
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		plpPage = new PLPPage();
	}
	
	
	@Test
	public void step0() throws InterruptedException {
		plpPage.ClickOnDesiredCategory("ABRASIVES");
	}
	
  @Test
  public void Step1() throws InterruptedException {
	  Thread.sleep(2000);
	  plpPage.displayProductsPerPageSorting("24 per page");
	  
  }
  
  @Test
  public void step2() throws InterruptedException {
	  Thread.sleep(2000);
	  plpPage.SortByNameAndRelevance("Name, a to z");
  }
  
  @Test
  public void step3() throws InterruptedException {
	  Thread.sleep(2000);
	  plpPage.ClickOnListView();
  }
  
  @Test
  public void step4() throws InterruptedException {
	  Thread.sleep(2000);
	  plpPage.ClickOnTableView();
  }
  
  @Test
  public void step5() throws InterruptedException {
	  Thread.sleep(2000);
	  plpPage.ClickOnGridView();
  }
}

package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.Homepage;

public class ProductGridClick extends baseClass{
	
	Homepage homepage;
	
	
	
	
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		homepage = new Homepage();
	}
	
	@Test
	public void step1() {
		homepage.ClickingOnCategory("GRINDER FOR LIFE");
	}
}

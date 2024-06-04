package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.LoginPage;
import Pages.PLPPage;


public class PDPNavigation extends baseClass {
	PLPPage plpPage;
	LoginPage loginPage;
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		plpPage = new PLPPage();
		loginPage = new LoginPage();
	}
	
	
	@Test
	public void step0() throws InterruptedException {
		Thread.sleep(3000);
		loginPage.validlogin("julia@jobinandjismi.com", "julia@123");
	}
	
	@Test
	public void step1() throws InterruptedException {
		plpPage.ClickOnDesiredCategory("SAFETY");
		plpPage.pdpNavigation("PROMAX 4000 WELDING GLOVES");
	}

	@Test
	public void step2() throws InterruptedException {
		//plpPage.EnterProductQuantity(5);
		Thread.sleep(2000);
		plpPage.EnterProductQuantity(5);
		
	}
	
	@Test
	public void step3() {
		plpPage.clickOnAddToOrderBtn();
	}

}

package TestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Pages.LoginPage;


public class LoginFunctionality extends baseClass{

	LoginPage loginpage;
	
	@BeforeClass
	public void preConditionSteps() {
		browseropening();
		loginpage = new LoginPage();
	}
	
	@Test
	public void LoginbtnClick() {
		loginpage.clickLoginBtn();
	}

	@Test
	public void LoginWithValidCredentials() throws InterruptedException {
		loginpage.validlogin("julia@jobinandjismi.com","julia@123");

	}
	
	@Test
	public void VerifyLoginRedirection() {
		loginpage.verifyLoginRedirection();
	}
	
	@Test
	public void Signout() {
		loginpage.signout();
	}
	
	@Test
	public void LoginWithInvalidUsernameAndValidPassword() throws InterruptedException {
		loginpage.InvalidusernameValidpasswrd("test@gmail.com","julia@123");
	}
	
	@Test
	public void LoginWithValidUsernameAndInvalidPassword() throws InterruptedException {
		loginpage.validUsernameAndInvalidPasswrd("julia@jobinandjismi.com","test@123");
	}
	
	@Test
	public void LoginWithEmptyUsername() {
		loginpage.emptyUsernameLogin("","julia@123" );
		
	}
	
	@Test
	public void LoginWithEmptyPassword() {
		loginpage.emptyPassword("julia@jobinandjismi.com", "");
	}
	
	@Test
	public void LoginWithUsernameAndPasswordAsUpperCase() {
		loginpage.caseSensitivetest("JULIA@JOBINANDJISMI.COM", "JULIA@123");
	}
	
}

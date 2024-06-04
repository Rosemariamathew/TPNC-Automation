package Pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class LoginPage extends baseClass {
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	@FindBy(xpath = "(//input[@name='email'])[1]") public WebElement emailtxtbx;
	@FindBy(xpath = "(//input[@name='password'])[1]") public WebElement passwordtxtbx;
	@FindBy(xpath = "//button[contains(text(),' Log In ')]") public WebElement loginbtn;
	@FindBy(xpath = "//p[text()='Valid Email is required']") public WebElement validemailreqvalidation;
	@FindBy(xpath = "//p[text()='Please enter a valid password']") public WebElement validpasswrdvalidation;
	@FindBy(xpath = "//a[@class='header-profile-welcome-link']") public WebElement AccountName;
	@FindBy(xpath = "//a[@name='signout']") public WebElement SignOut;
	@FindBy(xpath = "//a[@class='header-profile-login-link']") public WebElement DistributorLogin;
	@FindBy(xpath = "//div[contains(text(),'Incorrect email or password. Please')]") public WebElement incorrectuserpaswrd;
	@FindBy(xpath = "//h2[@class='login-register-login-title']") public WebElement HeadingTitle;
	@FindBy(xpath = "//input[@id='login-email']")public WebElement EmailAddressField;
	@FindBy(xpath = "//input[@id='login-password']")public WebElement PasswordField;
	@FindBy(xpath = "//button[@class='login-register-login-submit']")public WebElement LoginBtn;

	
	
	
	
	
	
	public void clickLoginBtn() {
		waitUntilInvisible(DistributorLogin);
		DistributorLogin.click();
			
	}
	
	
	public void validlogin(String Username, String Password) {
		waitUntilInvisible(DistributorLogin);
		DistributorLogin.click();
		waitUntilInvisible(emailtxtbx);
		emailtxtbx.clear();
		emailtxtbx.sendKeys(Username);
		passwordtxtbx.clear();
		passwordtxtbx.sendKeys(Password);
		loginbtn.click();
	}
	
	public boolean verifyLoginRedirection() {
		waitUntilInvisible(AccountName);
		String URL = "https://www.platinumna.com/sca-dev-2020-1/my_account.ssp";
		String currentUrl = getDriver().getCurrentUrl();
		if(URL.contentEquals(currentUrl)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public void InvalidusernameValidpasswrd(String Username,String Password) throws InterruptedException {
		getDriver().navigate().refresh();
		emailtxtbx.clear();
		emailtxtbx.sendKeys(Username);
		passwordtxtbx.clear();
		passwordtxtbx.sendKeys(Password);
		loginbtn.click();
//		assertTrue(incorrectuserpaswrd.isDisplayed(),"Invalid username");
		Thread.sleep(2000);
		getDriver().navigate().refresh();
		
	}
	
	public void validUsernameAndInvalidPasswrd(String Username,String Password) throws InterruptedException {
		waitUntilInvisible(emailtxtbx);
		emailtxtbx.clear();
		emailtxtbx.sendKeys(Username);
		passwordtxtbx.clear();
		passwordtxtbx.sendKeys(Password);
		waitUntilInvisible(loginbtn);
		loginbtn.click();
		assertTrue(incorrectuserpaswrd.isDisplayed(),"invalid password");
		Thread.sleep(2000);
		getDriver().navigate().refresh();
	}
	
	public void emptyUsernameLogin(String Username,String Password) {
		waitUntilInvisible(emailtxtbx);
		emailtxtbx.clear();
		emailtxtbx.sendKeys(Username);
		passwordtxtbx.clear();
		passwordtxtbx.sendKeys(Password);
		loginbtn.click();
		loginbtn.click();
		assertTrue(validemailreqvalidation.isDisplayed(), "username is empty");
		getDriver().navigate().refresh();
	}
	
	public void emptyPassword(String Username,String Password) {
		waitUntilInvisible(emailtxtbx);
		emailtxtbx.clear();
		emailtxtbx.sendKeys(Username);
		passwordtxtbx.clear();
		passwordtxtbx.sendKeys(Password);
		loginbtn.click();
		loginbtn.click();
		assertTrue(validpasswrdvalidation.isDisplayed(), "password is empty");
		getDriver().navigate().refresh();
	}
	
	public void caseSensitivetest(String UsernameUppercase, String PasswordUpperCase ) {
		waitUntilInvisible(emailtxtbx);
		emailtxtbx.clear();
		emailtxtbx.sendKeys(UsernameUppercase);
		passwordtxtbx.clear();
		passwordtxtbx.sendKeys(PasswordUpperCase);
		loginbtn.click();
		loginbtn.click();
		getDriver().navigate().refresh();
//		assertTrue(validemailreqvalidation.isDisplayed(), "Invalid username");
//		assertTrue(validpasswrdvalidation.isDisplayed(),"invalid password");
	}
	
	public void signout() {
		AccountName.click();
		SignOut.click();
	}
	
	public void refresh() {
		getDriver().navigate().refresh();
	}
	
	public void userLogin(String emailAdd, String pass) {
		scrollToAndClickElement(EmailAddressField);
		sendDataToInputField(EmailAddressField, emailAdd);
		scrollToAndClickElement(PasswordField);
		sendDataToInputField(PasswordField, pass);
		scrollToAndClickElement(LoginBtn);
	}
	

}

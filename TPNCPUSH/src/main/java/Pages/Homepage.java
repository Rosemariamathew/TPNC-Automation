package Pages;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import BaseClass.baseClass;

public class Homepage extends baseClass{
	
	public Homepage(){
		PageFactory.initElements(getDriver(), this);
	}

//------------------------------elements-----------------------------------------------------

	@FindBy(xpath = "//a[@class='header-profile-login-link']")
	public WebElement distLoginLink;
	@FindBy(xpath = "//ul[@class='header-subheader-options']/descendant::a[normalize-space()='Contact Us']")
	public WebElement ContactUsHdrLink;
	@FindBy(xpath = "//ul[@class='header-subheader-options']/descendant::a[normalize-space()='About Us']")
	public WebElement AboutUsHdrLink;
	@FindBy(xpath = "//ul[@class='header-subheader-options']/descendant::a[normalize-space()='Grinder for Life']")
	public WebElement GrinderLifeHdrLink;
	@FindBy(xpath = "//ul[@class='header-subheader-options']/descendant::a[normalize-space()='Quick Order']")
	public WebElement QuickOrderHdrLink;
	@FindBy(xpath = "//strong[@class='header-profile-welcome-link-name']")
	public WebElement UserNameText;
	@FindBy(xpath = "//a[@class='header-menu-myaccount-overview-anchor']")
	public WebElement AccountOverviewLink;
	@FindBy(xpath = "//a[@class='header-menu-myaccount-anchor-level3']")
	public List<WebElement> AccountOverviewSubLinks; // shows after clicking UN Text. - Use getText()
	@FindBy(xpath ="//i[@class='header-mini-cart-menu-cart-icon']")
	public WebElement CartIcon;
	@FindBy(xpath = "//span[@class='header-mini-cart-menu-cart-legend']")
	public WebElement CartAmount;
	@FindBy(xpath = "//li[@class='logo-social-icons']/child::a")
	public List<WebElement> SocialMediaHdrLinks; // use title value
	@FindBy(xpath = "//div[@class='footer-social-icons']/child::a")
	public List<WebElement> SocialMediaFtrLinks; // use title value
	@FindBy(xpath = "//input[@placeholder='Search for products']")
	public WebElement SearchInputField;
	@FindBy(xpath = "//div[@class='itemssearcher-item-results-title']")
	public List<WebElement> SearchItemSuggList; // div[@class='tt-suggestion
												// tt-selectable']/descendant::strong[@class='tt-highlight']
	@FindBy(xpath = "//div[@class='itemssearcher-item-all-results']")
	public WebElement SeeAllResultsLink;
	@FindBy(xpath = "//div[@class='itemssearcher-item-no-results']")
	public WebElement NoSearchResultText;
	@FindBy(xpath = "(//button[@type='submit'][normalize-space()='Go'])[1]")
	public WebElement GoBtn;
	@FindBy(xpath = "//a[@class='header-menu-level1-anchor']")
	public List<WebElement> CtgryMenuList;
	@FindBy(xpath = "(//li[contains(@class,'categories')]/a[2])")
	public List<WebElement> CMenuItemList;
	@FindBy(xpath = "//a[@class='footer-link']")
	public List<WebElement> FtrAcctAndCatgLinks; // use data-hastag - contains
	@FindBy(xpath = "//a[@class='footer-link-blog']")
	public List<WebElement> BlogLinksFtr; // use title value
	@FindBy(xpath = "//a[@class='header-menu-myaccount-signout-link']")
	public WebElement signOutLink;
	
	@FindBy(xpath = "//a[contains(text(),' ABRASIVES ')]") public WebElement Abrasive;
	@FindBy(xpath = "//a[contains(text(),' WELDING ')]") public WebElement Welding;
	@FindBy(xpath = "//a[contains(text(),'SAFETY')]") public WebElement Safety;
	@FindBy(xpath = "//a[contains(text(),'POLISHING')]") public WebElement Polishing;
	@FindBy(xpath = "//a[contains(text(),'RHODIUS')]") public WebElement Rhodius;
	@FindBy(xpath = "//a[contains(text(),'INSTOCK - QUICK SHIP')]") public WebElement Instock_Quickship;
	String AbrasivePagetitle = "Platinum North America";
	String WeldingPageTitle = "WELDING";
	String SafetyPageTitle = "SAFETY";
	String PolishingPageTitle = "POLISHING";
	String RhodiusPageTitle = "RHODIUS";
	String InstockPageTitle = "INSTOCK-QUICK-SHIP";
	@FindBy(xpath = "(//input[@class='itemssearcher-input typeahead tt-input'])[1]") public WebElement SearchBox;
	@FindBy(xpath = "//*[@id=\"home-page\"]/div/div/div/div/div/div[1]/ul/li") public List<WebElement> sliderImages;
	@FindBy(xpath = "//a[text()='DISCOVER MORE']") public WebElement discoverMoreBtn;
	String currentwindowurl = "https://www.platinumna.com/";
	@FindBy(xpath = "")  public WebElement WeldingCableAndElectrical;
	@FindBy(xpath = "//*[@id=\"cms\"]/div/div/div/div") public List<WebElement> CategoryList;
	@FindBy(xpath = "//a[@class='home-gallery-next-icon']") public WebElement BannerImageNxtBtn;
	@FindBy(xpath = "(//a[@class='home-gallery-prev-icon'])[1]") public WebElement BannerImagePrevBtn;
	@FindBy(xpath = "//img[@class='header-logo-image']") public WebElement PlatinumLogo;
	
	
	
	
	
	public void AbrasiveClick() throws InterruptedException {
		waitUntilInvisible(Abrasive);
		Thread.sleep(2000);
		Abrasive.click();
		String currentWindow = getDriver().getWindowHandle();
		Set<String> allWindows = getDriver().getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				getDriver().switchTo().window(window);
				if (getDriver().getTitle().equals(AbrasivePagetitle)) {
					break;
				}
			}
		}
		System.out.println(getDriver().getTitle());
		Assert.assertEquals(getDriver().getTitle(), AbrasivePagetitle);
		getDriver().close();
		

	}

	public void WeldingClick() {
		Welding.click();
		String currentWindow = getDriver().getWindowHandle();
		Set<String> allWindows = getDriver().getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				getDriver().switchTo().window(window);
				if (getDriver().getTitle().equals("https://www.platinumna.com/ABRASIVES")) {
					break;
				}
			}
		}
		Assert.assertEquals(getDriver().getTitle(), WeldingPageTitle);
		getDriver().close();
		

	}

	public void SafetyClick() {
		Safety.click();
		String currentWindow = getDriver().getWindowHandle();
		Set<String> allWindows = getDriver().getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				getDriver().switchTo().window(window);
				if (getDriver().getTitle().equals("https://www.platinumna.com/ABRASIVES")) {
					break;
				}
			}
		}
		Assert.assertEquals(getDriver().getTitle(), SafetyPageTitle);
		getDriver().close();
		

	}

	public void PolishingClick() {
		Polishing.click();
		String currentWindow = getDriver().getWindowHandle();
		Set<String> allWindows = getDriver().getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				getDriver().switchTo().window(window);
				if (getDriver().getTitle().equals("https://www.platinumna.com/ABRASIVES")) {
					break;
				}
			}
		}
		Assert.assertEquals(getDriver().getTitle(), PolishingPageTitle);
		getDriver().close();
		

	}

	public void RhodiusClick() {
		Rhodius.click();
		String currentWindow = getDriver().getWindowHandle();
		Set<String> allWindows = getDriver().getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				getDriver().switchTo().window(window);
				if (getDriver().getTitle().equals("https://www.platinumna.com/ABRASIVES")) {
					break;
				}
			}
		}
		Assert.assertEquals(getDriver().getTitle(), RhodiusPageTitle);
		getDriver().close();
		

	}

	public void InstockClick() {
		Instock_Quickship.click();
		String currentWindow = getDriver().getWindowHandle();
		Set<String> allWindows = getDriver().getWindowHandles();

		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				getDriver().switchTo().window(window);
				if (getDriver().getTitle().equals("https://www.platinumna.com/ABRASIVES")) {
					break;
				}
			}
		}
		Assert.assertEquals(getDriver().getTitle(), InstockPageTitle);
		getDriver().close();
		

	}
	
	public void searching(String item) {
		SearchBox.sendKeys(item);
		GoBtn.click();
	}
	
	public void clickSliderImage() throws InterruptedException {
		Actions actions = new Actions(getDriver());
		
		for (WebElement slide : sliderImages) {
	        slide.click();
	        Thread.sleep(2000);
	        actions.keyDown(Keys.CONTROL);
	        actions.click(discoverMoreBtn);
	        actions.perform();
	        getDriver().switchTo().window(currentwindowurl);
	        }
	}
	
	public void ProductSlider(String textValue) {
		getDriver().findElement(By.xpath("//span[contains(text(),'" + textValue + "')]")).click();
	}
	
	public void UrlValidation(String Url) {
		String currentUrl = getDriver().getCurrentUrl();
		assertEquals(Url, currentUrl);
	}

	public void ClickingOnCategory(String ProductName) {
		waitUntilInvisible(Abrasive);
		getDriver().findElement(By.xpath("//h2[text()='" + ProductName + "']/..")).click();
		
	}
	
	public void BannerImageNextNavigation() {
		waitUntilInvisible(Abrasive);
		int i =0;
		while(i<10) {
			BannerImageNxtBtn.click();
			i++;
		}
		
	}
	
	public void BannerImagePrevNavigation() {
		waitUntilInvisible(Abrasive);
		int i =0;
		while(i<10) {
			BannerImagePrevBtn.click();
			i++;
		}
	}
	
	public void ClickOnPlatinumLogo() {
		PlatinumLogo.click();
	}
	
	
	public void clickSocialMediaHdrLink(String expTitle) throws InterruptedException {
		for (WebElement smLink : SocialMediaHdrLinks) {
			if (smLink.getAttribute("title").equals(expTitle)) {
				scrollToAndClickElement(smLink);
				Thread.sleep(3000);
			}
		}
	}

	// Scroll and click the social media link (Footer)
	public void clickSocialMediaFtrLink(String expTitle) throws InterruptedException {
		for (WebElement smLink : SocialMediaFtrLinks) {
			if (smLink.getAttribute("title").equals(expTitle)) {
				scrollToAndClickElement(smLink);
				Thread.sleep(3000);
			}
		}
	}

	// get user name text after login
	public String getUserNameTextAfterLogin() {
		if (isElementDisplayed(UserNameText)) {
			return UserNameText.getText().trim();
		} else {
			return null;
		}
	}

	// click the user name and click account overview link
	public void clickAccountOverViewLink() {
		scrollToAndClickElement(UserNameText);
		scrollToAndClickElement(AccountOverviewLink);
	}

	// Click the user name and click the account links
	public void clickAccountOverviewSubLink(String accText) throws InterruptedException {
		scrollToAndClickElement(UserNameText);
		for (WebElement accOverLink : AccountOverviewSubLinks) {
			if (accOverLink.getText().equals(accText)) {
				scrollToAndClickElement(accOverLink);
				Thread.sleep(2000);
				break;
			}
		}
	}

	// Scroll and click the search field and enter the text.
	public void enterTextInSearchInputField(String itemName) {
		scrollToAndClickElement(SearchInputField);
		sendDataToInputField(SearchInputField, itemName);
	}

	// click see all results link in the suggestion section.
	public void clickSeeAllResultsLink() {
		scrollToAndClickElement(SeeAllResultsLink);
	}

	// click any of the item from the search suggestion list and open
	public void clickAnyItemFromSearchSugg(String itemName) {
		for (WebElement sResult : SearchItemSuggList) {
			if (sResult.getText().contains(itemName)) {
				sResult.click();
				break;
			}
		}
	}

	// click the Go button for search function
	public void clickGoBtn() {
		scrollToAndClickElement(GoBtn);
	}

	// click the contact us link from the header section
	public void clickContactUsHdrLink() throws InterruptedException {
		scrollToAndClickElement(ContactUsHdrLink);
		Thread.sleep(2000);
	}

	// click the about us link from the header section
	public void clickAboutUsHdrLink() throws InterruptedException {
		scrollToAndClickElement(AboutUsHdrLink);
		Thread.sleep(2000);
	}

	// click the grinderLife us link from the header section
	public void clickGrinderLifeHdrLink() throws InterruptedException {
		scrollToAndClickElement(GrinderLifeHdrLink);
		Thread.sleep(2000);
	}

	// click the quick order link from the header section
	public void clickQuickOrderHdrLink() throws InterruptedException {
		scrollToAndClickElement(QuickOrderHdrLink);
		Thread.sleep(2000);
	}

	// hover above the category menu and click the item from the list and check the
	// title of the page
	public boolean hoverCategoryMenuAndClickItem(String expctMenuName, String expctItemName, String expctPageTitle)
			throws InterruptedException {
		isElementDisplayed(UserNameText);
		for (WebElement menuList : CtgryMenuList) {
			if (menuList.getText().trim().equals(expctMenuName)) {
				hoverOverElement(menuList);
				Thread.sleep(2000);
				for (WebElement itemList : CMenuItemList) {
					if (itemList.getText().equals(expctItemName)) {
						scrollToAndClickElement(itemList);
						Thread.sleep(2000);
						if (getTitleOfPage(expctPageTitle)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	// click the footer account and category links
	public void clickFtrAcctAndCatgLinks(String expctFLink) {
		isElementDisplayed(UserNameText);
		for (WebElement ftrLink : FtrAcctAndCatgLinks) {
			if (ftrLink.getText().equals(expctFLink)) {
				scrollToAndClickElement(ftrLink);
				break;
			}
		}
	}

	// click the footer blog links
	public void clickFtrBlogLinks(String expctBLink) {
		isElementDisplayed(UserNameText);
		for (WebElement ftrBloglink : BlogLinksFtr) {
			if (ftrBloglink.getText().equals(expctBLink)) {
				scrollToAndClickElement(ftrBloglink);
				break;
			}
		}
	}

	// click the sing out link and verify it
	public boolean clickSignOutLink() throws InterruptedException {
		scrollToAndClickElement(UserNameText);
		scrollToAndClickElement(signOutLink);
		Thread.sleep(2000);
		if (isElementDisplayed(distLoginLink)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickLoginLink() {
		scrollToAndClickElement(distLoginLink);
	}

	
	
	

}

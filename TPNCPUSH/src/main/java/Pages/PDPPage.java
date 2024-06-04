package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class PDPPage extends baseClass {
	public PDPPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//article[@class='product-details-full-content']/h1")
	public WebElement ItemBannerName;
//------------------------------------functions----------------------------------------------

	public boolean getBannerName(String itemName) {
		if(isElementDisplayed(ItemBannerName)) {
			return ItemBannerName.getText().contains(itemName);
		}
		return false;
	}

}

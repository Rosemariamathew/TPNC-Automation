package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class CartPage extends baseClass {
	
	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//li[@class='global-views-breadcrumb-item-active']")
	public WebElement breadCrumb;
	
	@FindBy(xpath = "//h2[@class='cart-detailed-title']")
	public WebElement EmptyCartMsg;
	
	@FindBy(xpath = "//small[@class='cart-detailed-title-details-count']")
	public WebElement CartItemCount;
	
	@FindBy(xpath = "//a[normalize-space()='Home Page']")
	public WebElement HomePageCartLink;	//If no items are available on the cart page
	
	@FindBy(xpath = "//i[@class='quick-order-expander-toggle-icon']")
	public WebElement QOrderExpander;
	
	@FindBy(xpath = "//input[@id='quickaddSearch']")
	public WebElement QOdrItmNameField;
	
	@FindBy(xpath = "//input[@id='quantity']")
	public WebElement QOdrQtyField;
	
	@FindBy(xpath = "//button[@class='quick-add-box-button']")
	public WebElement QOdrAddItemBtn;
	
	@FindBy(xpath = "//tr[@class='cart-line-table-row']")
	public List<WebElement> CartLineTableRow;	//to get the no: of rows
	
	@FindBy(xpath = "//span[@class='product-line-sku-value']")
	public List<WebElement> ItemSKUColm;	//getText()
	
	@FindBy(xpath = "//div[@class='cart-lines-options']//span[@class='transaction-line-views-selected-option-value']")
	public List<WebElement> ItemDescrpName;	//getText()
	
	@FindBy(xpath = "//a[@data-action='remove-item']")
	public List<WebElement> RemoveBtn;
	
	@FindBy(xpath = "//td[@class='tableHead']/descendant::b")
	public WebElement subTotalAmt;
	
	@FindBy(xpath = "//a[@id='btn-proceed-checkout']")
	public WebElement ProceedToChkOutBtn;
	
	
	public void addItemQuickOdr(String ItmName, String ItmQty) {
		scrollToAndClickElement(QOdrItmNameField);
		sendDataToInputField(QOdrItmNameField, ItmName);
		sendDataToInputField(QOdrQtyField, ItmQty);
		scrollToAndClickElement(QOdrAddItemBtn);
	}

}

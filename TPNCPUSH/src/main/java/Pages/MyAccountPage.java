package Pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class MyAccountPage extends baseClass {
	public MyAccountPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//a[text()='Overview']")
	public WebElement OverviewOptn;
	@FindBy(xpath = "//a[text()=' Purchases ']")
	public WebElement Purchases;
	@FindBy(xpath = "//a[text()=' Billing ']")
	public WebElement Billing;
	@FindBy(xpath = "//a[text()=' Settings ']")
	public WebElement Settings;
	@FindBy(xpath = "//a[text()=' Cases ']")
	public WebElement Cases;
	@FindBy(xpath = "//a[text()=' My Rebate ']")
	public WebElement MyRebate;
	@FindBy(xpath = "(//a[text()='Purchase History'])[2]")
	public WebElement PurchaseHistory;
	@FindBy(xpath = "(//a[text()='Open orders'])[2]")
	public WebElement OpenOrders;
	@FindBy(xpath = "(//a[text()='Returns'])[2]")
	public WebElement Returns;
	@FindBy(xpath = "(//a[text()='Reorder Items'])[2]")
	public WebElement ReorderItems;
	@FindBy(xpath = "(//a[text()='Quotes'])[2]")
	public WebElement Quotes;
	@FindBy(xpath = "//a[@class='order-history-summary-button-reorder']")
	public WebElement ReorderAllItemsBtn;
	@FindBy(xpath = "//a[text()=' Download PDF ']") public WebElement downloadPdfBtn;
	@FindBy(xpath = "//a[text()=' Request a Return ']") public WebElement RequestReturnBtn;
	@FindBy(xpath = "//a[text()=' View Invoice ']") public WebElement ViewInvoiceBtn;
	@FindBy(xpath = "(//a[text()='Quotes'])[2]") public WebElement QuotesBtn;
	@FindBy(xpath = "//a[text()='Download as PDF']") public WebElement DownloadAsPdfQutoes;
	@FindBy(xpath = "//a[text()=' Purchases ']") public WebElement PurchasesOptn;
	@FindBy(xpath = "(//a[text()='Returns'])[2]") public WebElement Return;
	@FindBy(xpath = "//input[@name='from']") public WebElement From;
//	@FindBy(xpath = "(//th[@class='datepicker-switch'])[1]") public WebElement curMnthYr;
	@FindBy(xpath = "(//th[@class='next disabled'])[1]") public WebElement forwardOption_Calendar;
	@FindBy(xpath = "//input[@name='to']") public WebElement to;
	
	


	public void clickPurchaseHistory() {
		Purchases.click();
		PurchaseHistory.click();
	}

	public void ClickOnPurchaseNumber(String PurchaseNumber) {
		getDriver().findElement(By.xpath("//span[text()='" + PurchaseNumber + "']")).click();
		String PurchaseOrderNumber = getDriver()
				.findElement(By.xpath("//span[@class='order-history-details-order-number']")).getText();
		assertEquals(PurchaseNumber, PurchaseOrderNumber);

	}

	public boolean ClickOnReorderAllItemsAndRedirection() {
		ReorderAllItemsBtn.click();
		windowHandling();
		String Url = getDriver().getCurrentUrl();
		if (Url.contains("/my_account.ssp#/reorderItems")) {
			return true;
		} else {
			return false;
		}

	}

	public boolean ClickOnDownloadPdfAndRedirection() {
		Purchases.click();
		downloadPdfBtn.click();
		windowHandling();
		String url = getDriver().getCurrentUrl();
		if (url.contains("/accounting/print/NLSPrintForm.nl?")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ClickOnRequestAReturnAndRedirection() {
		RequestReturnBtn.click();
		windowHandling();
		String url = getDriver().getCurrentUrl();
		if (url.contains("/my_account.ssp#/returns/new/")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ClickOnViewInvoiceAndRedirection() {
		ViewInvoiceBtn.click();
		windowHandling();
		String url = getDriver().getCurrentUrl();
		if (url.contains("/my_account.ssp#/invoices")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean ClickOnQuotesAndRedirection() {
		QuotesBtn.click();
		windowHandling();
		String url = getDriver().getCurrentUrl();
		if (url.contains("/my_account.ssp#/quotes")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void clickOnQuotes(String QuoteNumber) {
		getDriver().findElement(By.xpath("//a[text()='" + QuoteNumber + "']")).click();
	}
	
	public void ClickOnProductsInQuotesPage(String ProductName) {
		getDriver().findElement(By.xpath("//a[text()='" + ProductName + "']")).click();
	}
	
	public void DownloadQuotePdf() {
		DownloadAsPdfQutoes.click();
	}
	
	public void clickOnOpenOrders() {
		OpenOrders.click();
	}
	
	public void clickOnPurchase() {
		PurchasesOptn.click();
	}
	
	public void ClickOnReturns() {
		Return.click();
	}
	
	public void selectDate(String FromDate, String toDate) throws InterruptedException {
		From.clear();
		From.sendKeys(FromDate);
		to.clear();
		to.sendKeys(toDate);
		
	}


}

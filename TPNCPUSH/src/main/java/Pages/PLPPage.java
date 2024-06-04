package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import BaseClass.baseClass;

public class PLPPage extends baseClass{
	
	
	public PLPPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(xpath = "//select[@class='facets-item-list-show-selector']") public WebElement SortProductPerPage;
	@FindBy(xpath = "//select[@class='facets-item-list-sort-selector']") public WebElement SortByNameAndRelevance;
	@FindBy(xpath = "//i[@class='icon-display-list']") public WebElement ViewList;
	@FindBy(xpath = "//i[@class='icon-display-table']") public WebElement ViewTable;
	@FindBy(xpath = "//i[@class='icon-display-grid']") public WebElement ViewGrid;
	@FindBy(xpath = "//*[@id=\"facet-browse\"]/section/div[2]/div[2]/div[1]/div[5]/div[1]/div[3]/div/div[2]/a") public WebElement PROMAX4000WG;
	@FindBy(xpath = "//input[@class='quick-order-grid-row-quantity']") public WebElement quantityTxtBx;
	@FindBy(xpath = "(//td[@class='itemqty'])[1]") public WebElement quantitytxtbx;
	@FindBy(xpath = "//button[contains(text(),'Add to Order')]") public WebElement AddToOrderBtn;  
	
	
	
	
	
	public void ClickOnDesiredCategory(String CategoryName) throws InterruptedException {
		Thread.sleep(2000);
		getDriver().findElement(By.xpath("//a[contains(text(),'" + CategoryName + "')]")).click();
	}

	public void displayProductsPerPageSorting(String VisibleText) {
		Select sel = new Select(SortProductPerPage);
		sel.selectByVisibleText(VisibleText);
	}

	public void SortByNameAndRelevance(String Option) {
		Select sel = new Select(SortByNameAndRelevance);
		sel.selectByVisibleText(Option);
	}

	public void ClickOnListView() {

		ViewList.click();
	}

	public void ClickOnTableView() {
		ViewTable.click();
	}

	public void ClickOnGridView() {
		ViewGrid.click();
	}

	public void pdpNavigation(String product) throws InterruptedException {
		Thread.sleep(3000);
		getDriver().findElement(By.xpath("//span[text()='" + product + "']")).click();
		
	}
	
	public void EnterProductQuantity(int quantity) throws InterruptedException {
		waitUntilInvisible(quantitytxtbx);
		scrollToElement(quantitytxtbx);
		quantitytxtbx.click();
		
		Actions act = new Actions(getDriver());
		int i=0;
		while(i<quantity) {
			act.keyDown(Keys.ARROW_UP);
			act.perform();
			i++;
		}
			}
	
	
	public void clickOnAddToOrderBtn() {
		AddToOrderBtn.click();
	}

}

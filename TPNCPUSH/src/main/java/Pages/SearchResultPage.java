package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class SearchResultPage extends baseClass{
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//------------------------------elements-----------------------------------------------------
	
	@FindBy(xpath = "//li[@class='global-views-breadcrumb-item-active']")
	public WebElement BreadCrumbText;
	
	@FindBy(xpath = "//h1[@class='facets-facet-browse-title']")
	public WebElement SearchDataCount;	//data-quantity
	
	@FindBy(xpath = "//span[@class='facets-facet-browse-title-alt']")
	public WebElement ItemTitle;
	
	@FindBy(xpath = "//span[@itemprop='name']")
	public List<WebElement> ItemSearchLists;
//------------------------------------functions----------------------------------------------
	
	//compare both data count from result with the items listed on the search result page.
	public boolean getResultCount() {
		isElementDisplayed(SearchDataCount);
        String dataQuantityAttribute = SearchDataCount.getAttribute("data-quantity");
        int dataQuantityValue = Integer.parseInt(dataQuantityAttribute);
        int listCount = ItemSearchLists.size();
        if(dataQuantityValue == listCount) {
        	System.out.println("dataQuantityValue: "+dataQuantityValue);
        	System.out.println("listCount: "+listCount);
        	return true;
        }else {
        	return false;
        }
	}
	

}

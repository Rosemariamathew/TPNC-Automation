package BaseClass;

import java.io.File;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class baseClass {
	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();

	public static ExtentReports report; // To attach the report with all the details.
	public static ExtentTest logger; // TO attach the test case details
	public static ExtentSparkReporter sparkReporter; // To generate HTML report to the given path

//	public static String emailAddress = "";
//	public static String password = "";
	
	
	
	public static void browseropening() {
		setDriver(new ChromeDriver());
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().manage().window().maximize();
		String url = "https://www.platinumna.com/";
		getDriver().get(url);
	}

	public static void setDriver(RemoteWebDriver driverValue) {
		driver.set(driverValue);
	}

	public static RemoteWebDriver getDriver() {
		return driver.get();
	}

	@BeforeSuite
	public void reportSetUp() {
		// Reports file will be automatically created and the file will be shown there
		sparkReporter = new ExtentSparkReporter(
				new File(System.getProperty("user.dir") + "/Reports/ExtentSeleniumChrome.html"));
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("TPNC Testing Report");
		sparkReporter.config().setTheme(Theme.DARK); // HTML file

		report = new ExtentReports(); // To convert the HTML to Report
		report.attachReporter(sparkReporter); // Attaching the HTML to Report
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Application", "TPNC");
		report.setSystemInfo("Environment", "Live");
		report.setSystemInfo("Browser", "Chrome Browser");
	}
	
	public static ExtentReports getReport() {
	    return report;
	}

	@AfterMethod
	// executes after the first test
	public void stepStatus(ITestResult result) { // iTestResult -> TestNG Listener -> To acquire the status of the test
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				logger.fail("FAILED: " + result.getName(),
						MediaEntityBuilder.createScreenCaptureFromPath(captureScreenshot()).build()); // screenshot attached
				// MediaEntityBuilder -> used to attach the screenshots
				logger.fail("Reason for Failure:" + result.getThrowable());
			} catch (Exception e) {
			}
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			try {
				logger.pass("PASSED: " + result.getName());
			} catch (Exception e) {
			}
		} else if (result.getStatus() == ITestResult.SKIP) {
			try {
				logger.skip("SKIPPED: " + result.getName());
			} catch (Exception e) {
			}
		}
		report.flush(); // cleaning process - to avoid overriding
	}

//----------------------------------Common Methods----------------------------------------------------

	//To open the browser and load the URL
	@Parameters("url")
	public void browserSetUp(String URL) {
		setDriver(new ChromeDriver());
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().manage().window().maximize();
		//String url = "https://www.platinumna.com/";
		getDriver().get(URL);
		System.out.println("Browser Initialized	");
	}

	//To terminate the browser after each test case
	public void terminateBrowser() {
		getDriver().quit();
		System.out.println("Browser Terminated");
	}

	//To capture and store the screenshot
	public String captureScreenshot() throws Exception { // manually we need to create the
		Date date = new Date();
		String timestamp = "IMG" + date.getTime(); // Changes the value in microseconds - Lengthier Number
		String fileWithPath = System.getProperty("user.dir") + "\\screenshots\\" + timestamp + ".png"; // folder + file Name + extension
		TakesScreenshot scrShot = ((TakesScreenshot) getDriver()); // Take screenshot
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE); // Convert to file - Screenshot
		File DestFile = new File(fileWithPath); // A folder is created
		FileUtils.copyFile(SrcFile, DestFile); // To copy-paste - Save
		return fileWithPath;
	}
	
	// Verifies if the title of the page matches the expected title
	public boolean getTitleOfPage(String expectedTitle) throws InterruptedException {
		String pageTitle = getDriver().getTitle().trim();
		System.out.println("Title of the page: " + pageTitle);
		return pageTitle.equals(expectedTitle);
	}
	
	// To get the URL of the page
	public boolean getCurrentURL(String expectedURL) {
		String pageURL = getDriver().getCurrentUrl();
		return pageURL.equals(expectedURL);
	}
	
	// JSE -> To scroll and view the element.
	public void scrollToElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	// To hover above the element
	public void hoverOverElement(WebElement element) {
		isElementDisplayed(element);
		scrollToElement(element);
		Actions action = new Actions(getDriver());
		action.moveToElement(element).build().perform();
	}
	
	// To scroll and click an element
	public void scrollToAndClickElement(WebElement element) {
		isElementToBeClicked(element);
		scrollToElement(element);
		Actions action = new Actions(getDriver());
		action.moveToElement(element).click().build().perform();
	}
	
	// To press the enter key
	public void pressEnterKey(WebElement element) {
		Actions actions = new Actions(getDriver());
		actions.sendKeys(element, Keys.ENTER).build().perform();
	}
	
	//To clear the field and enter text
	public void sendDataToInputField(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	// WebDriverWait -> To check whether the element is disappeared
	public boolean isElementDisappeared(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		boolean result = wait.until(ExpectedConditions.invisibilityOf(element));
		return result;
	}
	
	// WebDriverWait -> To check whether the element is displayed
	public boolean isElementDisplayed(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		return true;
	}
	
	// WebDriverWait -> Wait until the element to be clicked
	public boolean isElementToBeClicked(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return true;
	}
	
	// Select -> To select an element from dropdown
	public void selectFromDropdown_VisibleText(WebElement elename, String visibleText) {
		Select adultno = new Select(elename);
		adultno.selectByVisibleText(visibleText);
	}
	
	// Handle windows
	public void windowHandling() {
	    String mainWindowHandle = getDriver().getWindowHandle();
	    Set<String> windowHandles = getDriver().getWindowHandles();
	    for (String handle : windowHandles) {
	        if (!handle.equals(mainWindowHandle)) {
	            getDriver().switchTo().window(handle);
	            return; // Switched to the first non-main window, exit the loop
	        }
	    }
	}
	
	// Get item count from a locator
	public int getItemCount(WebElement locator) {
		String text = locator.getText().trim();
		Pattern pattern = Pattern.compile("\\d+");
		Matcher matcher = pattern.matcher(text);
		return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
	}
	
	public void waitUntilInvisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(getDriver(),Duration.ofSeconds(60));
}

}

package com.mk.pages;



import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mk.utils.WebUtils;

public class DashboardPage {
	private WebDriver driver;
	static WebUtils webutils;
	private JavascriptExecutor js;

	private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
	private By userProfileIcon = By.className("oxd-userdropdown-img");
	private By quicklaunchWidget = By.xpath("//div[@class='oxd-grid-3 orangehrm-quick-launch']");
	
	private By assignleavebtn = By.xpath("//button[@title='Assign Leave']");
	private By leavelistbtn = By.xpath("//button[@title='Leave List']");
	private By timesheetbtn = By.xpath("//button[@title='Timesheets']");
	private By applyleavebtn = By.xpath("//button[@title='Apply Leave']");
	private By myleavebtn = By.xpath("//button[@title='My Leave']");
	private By mytimesheetbtn = By.xpath("//button[@title='My Timesheet']");
	
	private By employeedistribution = By.xpath("//p[text()='Employee Distribution by Sub Unit']");
	
	private By dashboard = By.xpath("//span[text()='Dashboard']");
	

	// Constructor to initialize driver and WaitUtils
	public DashboardPage(WebDriver driver) {
        this.driver = driver;
		DashboardPage.webutils = new WebUtils(driver, 20); // Set a timeout of 20 seconds
	}

	// Method to validate successful login
	public boolean isLoginSuccessful() {
		try {
			WebElement dashboardElement = WebUtils.waitForVisibility(dashboardHeader);
			return dashboardElement.isDisplayed(); // Return true if the dashboard is displayed
		} catch (Exception e) {
			return false; // Return false if any exception occurs
		}
	}

	public String getDashboardHeaderText() {
	    // Wait for the dashboard header to be visible
	    WebElement dashboardElement = WebUtils.waitForVisibility(dashboardHeader);
	    
	    // Ensure the element is visible before getting text
	    if (dashboardElement.isDisplayed()) {
	        return dashboardElement.getText();  // Return text from the WebElement
	    } else {
	        throw new NoSuchElementException("Dashboard header is not visible.");
	    }
	}

	
	public boolean isUserProfileIconVisible() throws InterruptedException {
		WebElement usericon = WebUtils.waitForVisibility(userProfileIcon);
		return usericon.isDisplayed();
	}

	
	
	public boolean quickLaunchWidgetVisibility() throws InterruptedException {
		 // Scroll to the container of the quick launch items
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-grid-3 orangehrm-quick-launch']")));
		
		WebUtils.scrollToElementJS(quicklaunchWidget);
	    WebElement quickLaunchWidget = WebUtils.waitForVisibility(quicklaunchWidget);
	    
	    return element.isDisplayed(); //True
	    
/*	   String text = quickLaunchWidget.getText();
	   System.out.println(text); display s text as well*/  
	   
	  
	}

	public DashboardPage returnToDashboard() {
		 WebUtils.scrollToElementJS(dashboard);
		  WebUtils.waitForClickabilityAndClick(dashboard); 
		  return new DashboardPage(driver);
		  
		
	}
	public boolean assignLeaveBtnDisplayed() throws InterruptedException {
		WebUtils.scrollToElementJS(quicklaunchWidget);
		WebElement btndisplayed = WebUtils.waitForVisibility(assignleavebtn);
		return btndisplayed.isDisplayed();
		
	}
	
	public DashboardPage assignLeaveBtnclick() throws InterruptedException {
	    WebUtils.scrollToElementJS(quicklaunchWidget);
	  WebUtils.waitForClickabilityAndClick(assignleavebtn); //screen navigated to Assign leave page 
	  return new DashboardPage(driver);
	}
	
	public boolean leaveListBtnDisplayed() throws InterruptedException {
		WebUtils.scrollToElementJS(quicklaunchWidget);
		WebElement btndisplayed = WebUtils.waitForVisibility(leavelistbtn);
		return btndisplayed.isDisplayed();
		
	}
	
	public DashboardPage leaveListBtnclick() throws InterruptedException {
	    WebUtils.scrollToElementJS(quicklaunchWidget);
	  WebUtils.waitForClickabilityAndClick(leavelistbtn); //screen navigated to Assign leave page 
	  return new DashboardPage(driver);
	}
	
	public boolean timeSheetBtnDisplayed() throws InterruptedException {
		WebUtils.scrollToElementJS(quicklaunchWidget);
		WebElement btndisplayed = WebUtils.waitForVisibility(timesheetbtn);
		return btndisplayed.isDisplayed();
		
	}
	
	public DashboardPage timeSheetBtnclick() throws InterruptedException {
	    WebUtils.scrollToElementJS(quicklaunchWidget);
	  WebUtils.waitForClickabilityAndClick(timesheetbtn); //screen navigated to Assign leave page 
	  return new DashboardPage(driver);
	}
	
	public boolean applyLeaveBtnDisplayed() throws InterruptedException {
		WebUtils.scrollToElementJS(quicklaunchWidget);
		WebElement btndisplayed = WebUtils.waitForVisibility(applyleavebtn);
		return btndisplayed.isDisplayed();
		
	}
	
	public DashboardPage applyLeaveBtnclick() throws InterruptedException {
	    WebUtils.scrollToElementJS(quicklaunchWidget);
	  WebUtils.waitForClickabilityAndClick(applyleavebtn); //screen navigated to Assign leave page 
	  Thread.sleep(2000);
	  return new DashboardPage(driver);
	}
	
	public boolean myLeaveBtnDisplayed() throws InterruptedException {
		WebUtils.scrollToElementJS(quicklaunchWidget);
		WebElement btndisplayed = WebUtils.waitForVisibility(myleavebtn);
		return btndisplayed.isDisplayed();
		
	}
	
	public DashboardPage myLeaveBtnclick() throws InterruptedException {
	    WebUtils.scrollToElementJS(quicklaunchWidget);
	  WebUtils.waitForClickabilityAndClick(myleavebtn); //screen navigated to Assign leave page 
	  Thread.sleep(2000);
	  return new DashboardPage(driver);
	}
	
	public boolean myTimeSheetBtnDisplayed() throws InterruptedException {
		WebUtils.scrollToElementJS(quicklaunchWidget);
		WebElement btndisplayed = WebUtils.waitForVisibility(mytimesheetbtn);
		return btndisplayed.isDisplayed();
		
	}
	
	public DashboardPage myTimeSheetBtnclick() throws InterruptedException {
	    WebUtils.scrollToElementJS(quicklaunchWidget);
	  WebUtils.waitForClickabilityAndClick(mytimesheetbtn); //screen navigated to Assign leave page 
	  Thread.sleep(2000);
	  return new DashboardPage(driver);
	}
	
	
	public boolean employeeDistributionSubUnitD() throws InterruptedException {
		WebUtils.scrollToElementJS(employeedistribution);
		WebElement empdistrisubunit = WebUtils.waitForVisibility(employeedistribution);
		
		return empdistrisubunit.isDisplayed();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	Not in use Dont go much deeper 
	// Method to enter username
	public String getdropdown() {
		webutils.waitForClickabilityAndClick(userProfileIcon);
		return "clickedonuserProfile";
	}

	// click on about link
	public String openAbout() {
		webutils.waitForClickabilityAndClick(about);
		return "clickedonAboutLink";
	}

	// close the About dialog
	public String closeAboutPopup() {
		WebUtils.waitForVisibility(closepopup);
		return "displayed";
	}

	public String supportlink() throws InterruptedException {
		getdropdown();
		webutils.waitForClickabilityAndClick(support);
		return "clickedonsupportlink";
	}

	public String Logout() throws InterruptedException {
	
		webutils.waitForClickabilityAndClick(userProfileIcon);
		Thread.sleep(2000);
		webutils.waitForClickabilityAndClick(logout);
		return "userloggedout";
	}

	public List<String> aboutgrid() {
		// Wait for the visibility of the grid table
		WebElement details = webutils.waitForVisibility(aboutgridtable);

		// Find all text-containing elements within the dialog
		List<WebElement> listdetails = details.findElements(aboutgridtable); // Select all child elements

		List<String> aboutgrid = webutils.extractNonEmptyText(listdetails);
		return aboutgrid;
	}

	public boolean retrieveOrangeHrmItemsPresence() {
		// Locate the <ul> element
		WebElement mainClass = driver.findElement(orangehrmmainclass);

		// Find all <a> elements within <li> tags under the located <ul> element
		List<WebElement> listItems = mainClass.findElements(orangehrmlistitems);

		boolean orangehrm = webutils.extractNonEmptyPresence(listItems);

		return orangehrm;
	}

	public List<String> retrieveOrangeHrmItemsText() {
		// Locate the <ul> element
		WebElement mainClass = driver.findElement(orangehrmmainclass);

		// Find all <a> elements within <li> tags under the located <ul> element
		List<WebElement> listItems = mainClass.findElements(orangehrmlistitems);

		List<String> orangehrm = webutils.extractNonEmptyText(listItems);
		return orangehrm;
	}

	public List<String> OrangeHRMclickonlink() {
		// Locate the <ul> element
		WebElement mainClass = driver.findElement(orangehrmmainclass);

		// Find all <a> elements within <li> tags under the located <ul> element
		List<WebElement> listItems = mainClass.findElements(orangehrmlistitems);

		List<String> orangehrm = webutils.extractNonEmptyTextAndClick(orangehrmlistitems, 0);
		return orangehrm;
	}   */
}
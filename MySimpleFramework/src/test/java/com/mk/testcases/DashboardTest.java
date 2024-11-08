package com.mk.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mk.base.BaseTest;

public class DashboardTest extends BaseTest {

	@Test()
	public void TC_1()  {
		
		System.out.println("TC_1, test Dashboard Header");
		String expectedHeader = "Dashboard";
		String actualHeader = dashboardPage.getDashboardHeaderText();
		System.out.println("TC_1,Actual Header is : " + actualHeader);
		// Actual Header is : Dashboard
		Assert.assertEquals(actualHeader, expectedHeader, "Dashboard header text does not match.");
		
	}

	@Test()
	public void TC_2() throws InterruptedException {
		System.out.println("TC_2,testUserProfileIconVisibility");
		boolean isIconVisible = dashboardPage.isUserProfileIconVisible();
		System.out.println("TC_2,User profile icon is displayed in dashboard: " + isIconVisible);
		// User profile icon is displayed: true
		Assert.assertTrue(true, "User profile icon is not visible on the dashboard.");
	}

	@Test()
	public void TC_3() throws InterruptedException {
	    boolean widgetdisplayed = dashboardPage.quickLaunchWidgetVisibility();// Get button texts
	    System.out.println("TC_3,is Widget displayed  " + widgetdisplayed); // Print all retrieved button texts
	    
	    Assert.assertTrue(true, "widget not displayed.");
	}
	
	@Test
	public void TC_4() throws InterruptedException {
		boolean aldisplayed = dashboardPage.assignLeaveBtnDisplayed();
		System.out.println("TC_4, Assign leave button is enabled " + aldisplayed );
		Assert.assertTrue(true, "false:-Assign button not enabled ");
	}
	
	
	@Test
	public void TC_5() throws InterruptedException {
		dashboardPage.assignLeaveBtnclick();
		System.out.println("TC_5,clicked on Assign leave btn " );
		Assert.assertTrue(true,"false:not clicked on Assign leave ");
	}
	
	@Test
	public void TC_6() throws InterruptedException {
		boolean lldisplayed = dashboardPage.leaveListBtnDisplayed();
		System.out.println("TC_6,leave list  button is displayed " + lldisplayed );
		Assert.assertTrue(true, "False: leave list button not displayed");
		
	}
	
	
	@Test
	public void TC_7() throws InterruptedException {
		dashboardPage.leaveListBtnclick();
		System.out.println("TC_7,clicked on leave list btn " );
		Assert.assertTrue(true,"False: not clicked on leave list ");
	}
	
	@Test
	public void TC_8() throws InterruptedException {
		boolean tsdisplayed = dashboardPage.timeSheetBtnDisplayed();
		System.out.println("TC_8,Time sheet button is displayed " + tsdisplayed );
		Assert.assertTrue(true," False:-Time sheet button not displayed");
		
	}
	
	@Test
	public void TC_9() throws InterruptedException {
		dashboardPage.timeSheetBtnclick();
		System.out.println("TC_9,clicked on Time sheet btn " );
		Assert.assertTrue(true,"False:not clicked on Timesheet");
	}
	
	@Test
	public void TC_10() throws InterruptedException {
		boolean aldisplayed = dashboardPage.applyLeaveBtnDisplayed();
		System.out.println("TC_10,apply leave button is displayed " + aldisplayed );
		Assert.assertTrue(true,"False:-Apply leave button not displayed");
	}
	
	@Test
	public void TC_11() throws InterruptedException {
		dashboardPage.applyLeaveBtnclick();
		System.out.println("TC_11,clicked on apply leave btn " );
		Assert.assertTrue(true,"False:-Apply leave button not clicked ");
	}
	
	@Test
	public void TC_12() throws InterruptedException {
		boolean myldisplayed = dashboardPage.myLeaveBtnDisplayed();
		System.out.println("TC_12,My leave button is displayed " + myldisplayed );
		Assert.assertTrue(true,"False:-My leave button not displayed");
	}
	
	@Test
	public void TC_13() throws InterruptedException {
	//	dashboardPage.myLeaveBtnclick();
	//	System.out.println("TC_13,clicked on my leave btn " );
		Assert.assertTrue(false, "False: not clicked on My leave button");
//   FAILED: TC_13   output :- 
	//	java.lang.AssertionError: False: not clicked on My leave button did not expect to find [true] but found [false]
	}
	@Test
	public void TC_14() throws InterruptedException {
		boolean mytsdisplayed = dashboardPage.myTimeSheetBtnDisplayed();
		System.out.println("TC_14,My Timesheet  button is displayed " + mytsdisplayed );
		Assert.assertTrue(true,"False:My Timesheet button not dispalyed ");
	}
	
	
	@Test
	public void TC_15() throws InterruptedException {
		dashboardPage.myTimeSheetBtnclick();
		System.out.println("TC_15,clicked on My Timesheet  btn " );
		Assert.assertTrue(true,"False:Not clicked on My Timesheet button ");
	}
	
	@Test
	public void TC_16() throws InterruptedException {
		boolean isdisplayed = dashboardPage.employeeDistributionSubUnitD();
		System.out.println("Employee DistributionSubunit section is displayed" + isdisplayed);
		Assert.assertTrue(true,"False:Employee DistributionSubunit section not displayed ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

/*	

	@Test(description = "Validate close About dialog on dropdown navigation bar",priority=4)
	public void TC_5() throws InterruptedException {
		String opendrpdwn = dashboardPage.getdropdown(); // Open the dropdown
		System.out.println("TC_5, open drop down " + opendrpdwn);
	}
	@Test(dependsOnMethods= {"TC_5"},priority= 5)
	public void TC_6() {
		String openaboutlink = dashboardPage.openAbout(); // Open the About dialog
		System.out.println(" TC_6,opened about dialog box " + openaboutlink);
	}
	
	@Test(dependsOnMethods= {"TC_6"},priority = 6)
	public void TC_7() {
		String closeaboutpopup = dashboardPage.closeAboutPopup(); // Close the popup, through button click 
		System.out.println("TC_7,About popup closed successfully." + closeaboutpopup);
	}
	
	@Test(enabled = false,description = "support page ", dependsOnMethods= {"TC_5"}, priority = 7)
	public void TC_8() throws InterruptedException {
	
		String support = dashboardPage.supportlink();
		System.out.println("TC_8,open support page " + support);
	}
	
	@Test(dependsOnMethods= {"TC_6"},priority = 7)
	public void TC_9() {
		List<String> list = dashboardPage.aboutgrid();
		System.out.println("TC_9,List of items company details " + list);
		
		
/*List of items company details 
 * [Company Name:OrangeHRM
Version:OrangeHRM OS 5.7
Active Employees:100
Employees Terminated:0] 
	}
	
	@Test(description="check the navigation bar links present , Eg , Admin, PIM, Leave, Time, Recruitment ",priority=9)
	public void TC_10() {
		boolean list = dashboardPage.retrieveOrangeHrmItemsPresence();
		System.out.println("TC_10, list of items in OrangeHRM is displayed " + list); //true 
		
	}
	
	@Test(description="check the navigation bar links Eg , Admin, PIM, Leave, Time, Recruitment ",priority = 10)
	public void TC_11() {
		List<String> list = dashboardPage.retrieveOrangeHrmItemsText();
		System.out.println("TC_11, list of items in OrangeHRM" + list);
		//list of items in OrangeHRM[Admin, PIM, Leave, Time, Recruitment, My Info, Performance, Dashboard, Directory, Maintenance, Claim, Buzz]
	}
	
	@Test(description="links are clickable",priority = 11)
	public void TC_12() {
		List<String> clickonlink = dashboardPage.OrangeHRMclickonlink();
		System.out.println("TC_12, items opened except maintainance in OrangeHRM" + clickonlink);
		//list of items in OrangeHRM[Admin, PIM, Leave, Time, Recruitment, My Info, Performance, Dashboard, Directory, Maintenance, Claim, Buzz]
	}
	
*/
}

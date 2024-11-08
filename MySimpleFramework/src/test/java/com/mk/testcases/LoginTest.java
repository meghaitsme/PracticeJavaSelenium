package com.mk.testcases;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mk.base.BaseTest;
import com.mk.pages.LoginPage;
import com.mk.pages.LogoutPage;
import com.mk.utils.LoginDataProvider;

public class LoginTest extends BaseTest {

	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver = initDataProv(); // Initialize the driver
		driver.get(properties.getProperty("url")); // Navigates to the URL

		// Initialize the login page
		loginPage = new LoginPage(driver);

		// Read test data from Excel
		String filePath = properties.getProperty("testdatapath");
		String sheetName = "Sheet2"; // Adjust as needed
		LoginDataProvider dataProvider = new LoginDataProvider();
		int rowCount = dataProvider.getRowCount(filePath, sheetName);

		for (int i = 1; i <= rowCount; i++) {
			// Read data for each user from Excel
			Map<String, String> rowData = dataProvider.readExcelData(filePath, sheetName, i);
			// Declare username and password here
			String un = rowData.get("username"); // Make sure these lines are not duplicated
			String pswd = rowData.get("password");

			// Perform login
			loginPage.login(un, pswd);
			String userv = "Admin";
			String passv = "admin123";

			if (un.equals(userv) && pswd.equals(passv)) {
				LogoutPage logout = new LogoutPage(driver);
				logout.logout();
				System.out.println("Login successful for user: " + un + " and " + pswd);
				continue;
				
			} else {
				System.out.println("Invalid credentials for user: " + un + pswd);
			}
		}
		// Clean up
					driver.quit(); // Close the browser after tests
	}
}
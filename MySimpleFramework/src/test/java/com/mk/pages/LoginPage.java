package com.mk.pages;

import com.mk.utils.WebUtils;

import freemarker.core.BugException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {   // locators + pass value , click  
    
    private WebDriver driver;
    private WebUtils webutils;
   

    // Locators
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginButton = By.xpath("//button[@type='submit']");


    // Constructor to initialize driver and WaitUtils
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.webutils = new WebUtils(driver, 20); // Set a timeout of 20 seconds
        
    }

    public void enterUsername(String username) throws InterruptedException {
        webutils.waitForVisibilityAndSendKeys(usernameField, username);
    }

    // Method to enter password
    public void enterPassword(String password) throws InterruptedException {
        webutils.waitForVisibilityAndSendKeys(passwordField, password);
    }

    // Method to click on the login button
    public void clickLogin() {
        WebUtils.waitForClickabilityAndClick(loginButton);
    }

    // Method to perform login action
    public String login(String username, String password) throws InterruptedException {
        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return username;
        }

        if (password == null || password.isEmpty()) {
            System.out.println("Password cannot be empty.");
            return password;
        }

        enterUsername(username);
        enterPassword(password);
        clickLogin();
        
        if (driver.getCurrentUrl().contains("dashboard")) {
            return username; // Login was successful
        } else {
            return username+password; // Login failed
        }
    
    }
}

/*Documentation :- Data Driven :-  */

/*PASSED: loginTest("invalidUser", "admin123")
PASSED: loginTest("Admin", "invalidPass123")
PASSED: loginTest("", "admin123")
PASSED: loginTest("Admin", "")
PASSED: loginTest("Admin!@#", "admin123")
PASSED: loginTest("Admin", "admin123!@#123")
PASSED: loginTest("Admin", "admin123")
PASSED: loginTest("Admin", "123.0")
PASSED: loginTest("Admin", "thisPasswordIsWayTooLongAndShouldNotBeAllowed")
PASSED: loginTest(" Admin", " admin123")
PASSED: loginTest("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "admin123")
PASSED: loginTest("Admin", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
PASSED: loginTest("user@domain", "admin123")
PASSED: loginTest("", "")
PASSED: loginTest("", "")
PASSED: loginTest("", "")

 * 
 * 
 * */
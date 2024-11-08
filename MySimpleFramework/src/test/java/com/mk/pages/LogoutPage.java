package com.mk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.mk.utils.WebUtils;

public class LogoutPage {
    private WebDriver driver;
    private WebUtils webutils;

    // Locators
    private By userProfileIcon = By.xpath("//img[@class ='oxd-userdropdown-img']");
    private By logoutButton = By.xpath("//a[text()='Logout']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.webutils = new WebUtils(driver, 10);
    }

    public void logout() throws InterruptedException {
        WebUtils.waitForClickabilityAndClick(userProfileIcon);
        WebUtils.waitForClickabilityAndClick(logoutButton);
    }
}

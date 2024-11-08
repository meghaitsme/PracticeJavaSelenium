package com.mk.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HerokuappPage {
    private WebDriver driver;
    
    // Locators
    private By addElementButton = By.xpath("//button[text()='Add Element']");
    private By deleteButton = By.xpath("//button[text()='Delete']");
    
    private By selectdropdown = By.id("dropdown");
    
    // Constructor to initialize driver and WebUtils
    public HerokuappPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click "Add Element" button
    public void clickAddElement() {
        driver.findElement(addElementButton).click();
    }

    // Method to check if "Delete" button is displayed
    public boolean isDeleteButtonDisplayed() {
        return driver.findElements(deleteButton).size() > 0;
    }
    
    public boolean isAddElementButtonDisplayed() {
        return driver.findElements(deleteButton).size() > 0;
    }

    // Method to click "Delete" button, no return type for click() method 
    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }
    
    public List<WebElement> optionDisplayed(){
    	WebElement dropdownElement = driver.findElement(selectdropdown);
    	Select dropdown = new Select(dropdownElement);
    	
    	
    	List<WebElement> options = dropdown.getOptions();
    	System.out.println(options);
		return options;
    }
    public boolean optionIsSelected(){
    	WebElement selected = driver.findElement(selectdropdown);
    	Select dropdown = new Select(selected);
    	dropdown.selectByVisibleText("Option 1");
    	selected.isSelected();
    	return selected != null;
    }
    
}

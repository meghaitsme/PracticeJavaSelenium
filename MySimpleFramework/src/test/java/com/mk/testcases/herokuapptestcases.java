package com.mk.testcases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.mk.pages.HerokuappPage;
import io.github.bonigarcia.wdm.WebDriverManager;
public class herokuapptestcases {
    private WebDriver driver;
    private HerokuappPage happ;

    
    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        
        happ = new HerokuappPage(driver);
    }

    @Test
    public void testAddElement() {
        // Add an element
      happ.clickAddElement(); //true 
      System.out.println(happ.isDeleteButtonDisplayed()+ "delete butn is displayed on click of addelement ");
        Assert.assertTrue(happ.isDeleteButtonDisplayed(), "Delete button should be displayed after adding an element.");
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testRemoveElement() throws InterruptedException {
        // Remove the element
        happ.clickDeleteButton();//false , its correct 
        System.out.println(happ.isDeleteButtonDisplayed()+ "delete butn not displayed on click of addelement ");
        Thread.sleep(2000);
        Assert.assertFalse(happ.isAddElementButtonDisplayed(), "Delete button should be hidden after removing the element.");
    }

    @Test
    public void dropdownisVisible() throws InterruptedException{
    	driver.get("https://the-internet.herokuapp.com/dropdown");
    	List<WebElement> optiondisplay = happ.optionDisplayed();
    	Thread.sleep(2000);
    	System.out.println(optiondisplay+ "Options dispalyed");
    }	
    @Test
    public void dropdownisVSelected() throws InterruptedException{
    	driver.get("https://the-internet.herokuapp.com/dropdown");
    	
    	boolean optionselect = happ.optionIsSelected();
    	Thread.sleep(2000);
    	System.out.println(optionselect + "Options Selected");
    	
    }
    
    
    
    
    
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

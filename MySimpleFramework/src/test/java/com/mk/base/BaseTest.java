package com.mk.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mk.pages.DashboardPage;
import com.mk.pages.LoginPage;
import com.mk.pages.LogoutPage;
import com.mk.utils.ExtentUtil;
import com.mk.utils.LoginDataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;
    protected static Properties properties;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected LoginDataProvider testDataProvider;
    protected LogoutPage logout;
 
   @BeforeTest
    public WebDriver init() throws InterruptedException, IOException {
    	loadProperty();
       // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
    	options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    	driver.manage().deleteAllCookies();
    	
    	ExtentUtil.initReport(driver);

    	  ExtentUtil.createTest("1. Execute the code  ");
        // Navigate to URL from properties
        driver.get(properties.getProperty("url"));
     

        // Initialize LoginPage with WebDriver
        loginPage = new LoginPage(driver);

        // Perform login using credentials from properties
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        loginPage.login(username, password);
        
       dashboardPage = new DashboardPage(driver);
		return driver;

    }

    
  //  @BeforeTest
    public WebDriver initDataProv() throws InterruptedException, IOException {
    	loadProperty(); // Make sure properties are loaded before initializing WebDriver
        // Set up WebDriver 	
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        ExtentUtil.initReport(driver);

  	  ExtentUtil.createTest("2. data driven   ");
        driver.manage().deleteAllCookies();
        return driver;
    }
    
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
        	
        	   ExtentUtil.endReport();
        	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
            driver.quit(); // Close the browser
        }
    }
    
    @BeforeMethod  // navigate to dashboard before every test , @BeforeMethod 
    //without logout , page -> dashboard , page -> dashboard 
    public void setUp() {
    	loaddashboardProperty();
    	driver.get(properties.getProperty("dashboardurl"));
    }
    
    
    public static void loadProperty() {
  	  // Load properties from src/test/resources/config.properties
      properties = new Properties();
      try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
          properties.load(fis);
      } catch (IOException e) {
          e.printStackTrace();
          throw new RuntimeException("Could not load configuration file.");
      }
    }

    public static void loaddashboardProperty() {  //@BeforeMethod 
    	  // Load properties from src/test/resources/dashboard.properties
        properties = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/dashboard.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load configuration file.");
        }
      }
}
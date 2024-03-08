package com.xyz.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.AddCustomerPage;

public class AddCustomerPageTest extends TestBase {
    AddCustomerPage addCustomerPage;
    
    public AddCustomerPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        addCustomerPage = new AddCustomerPage(); 
    }
    
    @Test
    public void verifyAddCustomerAlertMessage() {
        // Click on Bank Manager Login
        addCustomerPage.clickBankManagerLoginButton();
        
        // Click on Add Customer
        addCustomerPage.clickAddCustomerButton();
        
        // Enter customer details
        addCustomerPage.enterFirstName("Shubham@21");
        addCustomerPage.enterLastName("Kamble$5");
        addCustomerPage.enterPostCode("J12122");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        // Click on Add Customer button
        addCustomerPage.clickSubmitButton();
        
        // Get the alert message text
        String alertMessage = addCustomerPage.getAlertMessageText();
        
        // Assert the alert message text
        Assert.assertTrue(alertMessage.contains("Customer added successfully"));

        
        // Click OK on the alert
        addCustomerPage.acceptAlert();
    }
    
  //  @AfterMethod
   // public void tearDown() {
   //     driver.quit();
   // }
}

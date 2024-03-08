package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.OpenAccountPage;

public class OpenAccountPageTest extends TestBase {
    OpenAccountPage openAccountPage;
    
    public OpenAccountPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        openAccountPage = new OpenAccountPage(); 
    }
    
    @Test
    public void verifyOpenAccountAlertMessage() {
        // Click on Bank Manager Login
        openAccountPage.clickBankManagerLoginButton();
        
        // Click on Open Account
        openAccountPage.clickOpenAccountButton();
        
        // Select customer name from dropdown
        openAccountPage.selectCustomerName("Harry Potter");
        
        // Select currency from dropdown
        openAccountPage.selectCurrency("Pound");
        
        // Click on Process button
        openAccountPage.clickProcessButton();
        
        // Get the alert message text
        String alertMessage = openAccountPage.getAlertMessageText();
        
        // Assert the alert message text
        Assert.assertTrue(alertMessage.contains("Account created successfully"));
        
        // Click OK on the alert
        openAccountPage.acceptAlert();
    }
    
  //  @AfterMethod
   // public void tearDown() {
   //     driver.quit();
   // }
}

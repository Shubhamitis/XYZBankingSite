
package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.LoginPage;

public class CustomerLoginPageTest extends TestBase {
    LoginPage loginPage;
    CustomerLoginPage accountPage;
    
    public CustomerLoginPageTest() {
        super();
    }
    
    // Setting up the test environment before each test method execution
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        accountPage = loginPage.loginAsCustomer("Harry Potter");
    }
    
    // Verifying customer account details such as header name and customer name
    @Test(priority=2)
    public void verifyCustomerAccountDetails() {
        String headerName = accountPage.getHeaderName();
        Assert.assertEquals(headerName, "XYZ Bank");

        String customerName = accountPage.getCustomerName();
        Assert.assertEquals(customerName, "Harry Potter");
        
        accountPage.clickDepositButton();
        accountPage.clickWithdrawButton();
    }
    
    // Closing the browser after each test method execution
    //@AfterMethod
    //public void tearDown() {
    //    driver.quit();
    //}
}

package com.xyz.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.DepositPage;
import com.xyz.qa.pages.LoginPage;
import com.xyz.qa.pages.WithdrawPage;

public class WithdrawPageTest extends TestBase {
    LoginPage loginPage;
    CustomerLoginPage accountPage;
    WithdrawPage withdrawPage;
    DepositPage depositPage;
    
    public WithdrawPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(); 
        accountPage = loginPage.loginAsCustomer("Hermoine Granger"); 
    }
    
    @Test(priority=4)
    public void withdrawAmount() {
        // Deposit

        // Withdraw 
        withdrawPage = accountPage.clickWithdrawButton();
        withdrawPage.enterWithdrawAmount("100"); 
        withdrawPage.WithdrawButton();
        
        // Verify withdraw status message
        String withdrawStatusMessage = withdrawPage.getWithdrawStatusMessage();
        Assert.assertEquals(withdrawStatusMessage, "Transaction successful");

        withdrawPage = accountPage.clickWithdrawButton();
        withdrawPage.enterWithdrawAmount("10000"); 
        withdrawPage.WithdrawButton();
        
        // Verify withdraw status message
        String withdrawStatusMessage1 = withdrawPage.getWithdrawStatusMessage();
        Assert.assertEquals(withdrawStatusMessage1, "Transaction Failed. You can not withdraw amount more than the balance.");
    }
       
    
 //   @AfterMethod
   // public void tearDown() {
   //     driver.quit();
   // }
}

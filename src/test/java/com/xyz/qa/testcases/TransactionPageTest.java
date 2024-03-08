package com.xyz.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.xyz.qa.base.TestBase;
import com.xyz.qa.pages.CustomerLoginPage;
import com.xyz.qa.pages.DepositPage;
import com.xyz.qa.pages.LoginPage;
import com.xyz.qa.pages.TransactionPage;
import com.xyz.qa.pages.WithdrawPage;

public class TransactionPageTest extends TestBase {
	public static long IMPLICIT_WAIT = 30;
    LoginPage loginPage;
    CustomerLoginPage accountPage;
    WithdrawPage withdrawPage;
    DepositPage depositPage;
    TransactionPage transactionPage;
    
    public TransactionPageTest() {
        super();
    }
    
    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage(); 
        accountPage = loginPage.loginAsCustomer("Hermoine Granger"); 
    }
    
    @Test(priority=5)
    public void depositWithdrawAndVerifyTransactions() {
        // Deposit
        
        // Go to transactions page
        transactionPage = accountPage.clickTransactionButton();
        
        //filter the date
        transactionPage.setStartDate("12-01-2024 00:00");

        transactionPage.setEndDate("07-03-2024 00:00");
    
        transactionPage.pageClick();
    }
    //@AfterMethod
    //public void tearDown() {
     //   driver.quit();
   // }
}

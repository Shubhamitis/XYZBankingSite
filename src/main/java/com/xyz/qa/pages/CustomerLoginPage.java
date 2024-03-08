
package com.xyz.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xyz.qa.base.TestBase;

public class CustomerLoginPage extends TestBase {

    // Page Factory - Object Repository:
    @FindBy(xpath="//strong[@class='mainHeading']")
    WebElement headerName;

    @FindBy(xpath="//span[@class='fontBig ng-binding']")
    WebElement customerName;

    @FindBy(xpath="//button[normalize-space()='Transactions']")
    WebElement transactionButton;

    @FindBy(xpath="//button[normalize-space()='Deposit']")
    WebElement depositButton;
    
    @FindBy(xpath="//button[normalize-space()='Withdrawl']")
    WebElement withdrawalButton;

    // Initializing the Page Objects:
    public CustomerLoginPage(){
        PageFactory.initElements(driver, this);
        
    }

    // Method to get the header name
    public String getHeaderName() {
        return headerName.getText();
    }

    // Method to get the customer name
    public String getCustomerName() {
        return customerName.getText();
    }

    // Method to click on the transaction button and return to the transaction page
    public TransactionPage clickTransactionButton(){
        transactionButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new TransactionPage();
    }
    
    // Method to click on the deposit button and return to the deposit page
    public DepositPage clickDepositButton(){
        depositButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new DepositPage();
    }

    // Method to click on the withdrawal button and return to the withdrawal page
    public WithdrawPage clickWithdrawButton(){
        withdrawalButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return new WithdrawPage();
    }
}

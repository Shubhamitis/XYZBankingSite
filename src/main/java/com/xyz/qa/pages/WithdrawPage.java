

package com.xyz.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.xyz.qa.base.TestBase;

public class WithdrawPage extends TestBase {

    // Page Factory - Object Repository:
    @FindBy(xpath="//input[@placeholder='amount']")
    WebElement withdrawAmountInput;
    
    @FindBy(xpath="//button[normalize-space()='Withdraw']")
    WebElement withdrawButton;
    
    @FindBy(xpath="//span[@class='error ng-binding']")
    WebElement withdrawStatusMessage;
    
    @FindBy(xpath="//button[normalize-space()='Transactions']")
    WebElement transcationclick;
    
    @FindBy(xpath="//td[normalize-space()='100']")
    WebElement lastTransactionAmount;

    // Initializing the Page Objects:
    public WithdrawPage(){
        PageFactory.initElements(driver, this);
    }
    
    // Method to enter withdraw amount
    public void enterWithdrawAmount(String amount) {
        withdrawAmountInput.clear(); // Clear the input field 
        withdrawAmountInput.sendKeys(amount);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    // Method to click on withdraw button
    public void WithdrawButton() {
        withdrawButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    // Method to retrieve the withdraw status message
    public String getWithdrawStatusMessage() {
        return withdrawStatusMessage.getText();
        
    }
    
    // Method to click on the Transactions button
    public void clickTransaction() {
        transcationclick.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    // Method to retrieve the last transaction amount
    public String getLastTransactionAmount() {
        return lastTransactionAmount.getText();
    }
}

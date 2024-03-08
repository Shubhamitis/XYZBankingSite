
package com.xyz.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.xyz.qa.base.TestBase;

public class CustomersPage extends TestBase {

    // Page Factory - Object Repository:
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Customers']")
    WebElement customersButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchCustomerInput;

    @FindBy(xpath = "//td[normalize-space()='Neville']")
    WebElement firstName;

    @FindBy(xpath = "//td[normalize-space()='Longbottom']")
    WebElement lastName;

    @FindBy(xpath = "//td[normalize-space()='E89898']")
    WebElement postCode;

    @FindBy(xpath = "//tbody//td[4]")
    WebElement accountNumber;

    @FindBy(xpath = "//button[normalize-space()='Delete']")
    WebElement deleteButton;

    // Initializing the Page Objects:
    public CustomersPage() {
        PageFactory.initElements(driver, this);
    }

    // Method to click the bank manager login button
    public void clickBankManagerLoginButton() {
        bankManagerLoginButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Method to click the customers button
    public void clickCustomersButton() {
        customersButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Method to search for a customer using the search input field
    public void searchCustomer(String customerName) {
        searchCustomerInput.sendKeys(customerName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Method to get the first name of the customer
    public String getFirstName() {
        return firstName.getText();
    }

    // Method to get the last name of the customer
    public String getLastName() {
        return lastName.getText();
    }

    // Method to get the post code of the customer
    public String getPostCode() {
        return postCode.getText();
    }

    // Method to get the account number of the customer
    public String getAccountNumber() {
        return accountNumber.getText();
    }

    // Method to click the delete button to delete the customer
    public void clickDeleteButton() {
        deleteButton.click();
        
        
    }
}

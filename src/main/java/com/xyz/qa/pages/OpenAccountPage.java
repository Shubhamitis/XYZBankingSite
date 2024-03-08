
package com.xyz.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.xyz.qa.base.TestBase;

public class OpenAccountPage extends TestBase {

    // Page Factory - Object Repository:
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankManagerLoginButton;

    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccountButton;

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameDropdown;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    // Initializing the Page Objects:
    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    // Method to click the bank manager login button
    public void clickBankManagerLoginButton() {
        bankManagerLoginButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Method to click the open account button
    public void clickOpenAccountButton() {
        openAccountButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Method to select a customer name from the dropdown
    public void selectCustomerName(String customerName) {
        Select customerDropdown = new Select(customerNameDropdown);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        customerDropdown.selectByVisibleText(customerName);
    }

    // Method to select a currency from the dropdown
    public void selectCurrency(String currency) {
        Select currencyDropdownSelect = new Select(currencyDropdown);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        currencyDropdownSelect.selectByVisibleText(currency);
    }

    // Method to click the process button to open the account
    public void clickProcessButton() {
        processButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // Method to get the text of the alert message
    public String getAlertMessageText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

    // Method to accept the alert
    public void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}

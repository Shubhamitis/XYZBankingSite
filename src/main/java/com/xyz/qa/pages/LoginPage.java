

package com.xyz.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.xyz.qa.base.TestBase;

public class LoginPage extends TestBase {

    // Page Factory - Object Repository:
    @FindBy(xpath="//button[contains(text(),'Customer Login')]")
    WebElement customerLoginBtn;
    
    @FindBy(xpath="//select[@id='userSelect']")
    WebElement namedropdown;

    @FindBy(xpath="//button[normalize-space()='Login']")
    WebElement loginButton;  
    
    @FindBy(xpath="//button[normalize-space()='Logout']")
    WebElement logoutButton;

    // Initializing the Page Objects:
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    
    // Method to perform customer login
    public void customerLogin(){
        customerLoginBtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    // Method to get the login page title
    public String loginPageTitle() {
        return driver.getTitle();
    }
    
    // Method to select a customer from the drop-down menu
    public void selectCustomer(String customerName){
        Select select = new Select(namedropdown);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        select.selectByVisibleText(customerName);
    }
    
    // Method to click the login button
    public void clickLoginButton(){
        loginButton.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    
    // Method to login as a customer and return the customer account page
    public CustomerLoginPage loginAsCustomer(String customerName) {
        customerLogin();
        selectCustomer(customerName);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        clickLoginButton();
        return new CustomerLoginPage();
    }           
}

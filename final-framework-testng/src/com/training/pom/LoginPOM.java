package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//For RTTC_013 - RTTC_015
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(tagName="button")
	private WebElement loginBtn; 
	
	//@FindBy(id="menu-catalog")
	
	@FindBy(xpath="//ul[@id='menu']/li[@id='menu-catalog']/a[@class='parent']/i[@class='fa fa-tags fw']")
	private WebElement catmen; 
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}

	public boolean LoginUser(String UserID,String Password)
    {
            try
            {
                    sendUserName(UserID);
                    sendPassword(Password);
                    clickLoginBtn();
                    return true;
                    
            }
            
            catch(Exception ex)
            {
                    System.out.println(ex.getMessage());
                    return false;
            }
    }
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}	
		
	public void clickCatBtn() {
			this.catmen.click(); 	
	}
}

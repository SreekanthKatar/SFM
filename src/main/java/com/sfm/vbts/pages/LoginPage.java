package com.sfm.vbts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfm.vbts.base.TestBase;





public class LoginPage extends TestBase{
	
	@FindBy(id="Username")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement PassWord;
	
	@FindBy(xpath="/html/body/div/form/button")
	WebElement Login;
	
	@FindBy(xpath="/html/body/div/center/a/img")
	WebElement CenterpointLogo;
	
	@FindBy(xpath="//*[@id=\"mainnav\"]/nav/div/div[2]/ul/li[3]/a")
	WebElement ProfileSection;
	
	@FindBy(xpath="//*[@id=\"mainnav\"]/nav/div/div[2]/ul/li[3]/ul/li[2]/a")
	WebElement Logout;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public String ValidateLoginPageURL() {
		
		return driver.getCurrentUrl();
	}
	
	public boolean VerifyCenterpointLogo()
	{
		return CenterpointLogo.isDisplayed();
	}
	
	public HomePage PerformLogin(String un, String pw) throws InterruptedException
	{
		UserName.click();
		UserName.sendKeys(un);
		
		PassWord.click();
		PassWord.sendKeys(pw);
		
		Login.click();
		Thread.sleep(4000);
		return new HomePage();
	}
	
	public HomePage PerformLogout() throws InterruptedException
	{
		ProfileSection.click();
		Thread.sleep(1000);
		Logout.click();
		Thread.sleep(2000);
		return new HomePage();
	}
	
	

}

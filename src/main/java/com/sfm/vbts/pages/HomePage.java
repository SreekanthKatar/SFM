package com.sfm.vbts.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sfm.vbts.base.TestBase;





public class HomePage extends TestBase{

	@FindBy(xpath="//*[@id=\"mainnav\"]/nav/div/div[1]/a/img")
	WebElement SFMLogo;
	

	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifySFMLogo()
	{
		return SFMLogo.isDisplayed();
	}
	
	public String ValidateHomePageURL()
	{
		return driver.getCurrentUrl();
	}
	
	public String ValidateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
	
	
}

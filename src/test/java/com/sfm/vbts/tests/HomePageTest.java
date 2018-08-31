package com.sfm.vbts.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sfm.vbts.base.TestBase;
import com.sfm.vbts.pages.HomePage;
import com.sfm.vbts.pages.LoginPage;
import com.sfm.vbts.utils.TestUtil;





public class HomePageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil util;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException, IOException {
		browser_init();
		loginpage = new LoginPage();
		homepage = loginpage.PerformLogin(prop.getProperty("username"), prop.getProperty("password"));
//		homepage = loginpage.PerformLogin(prop.getProperty("username_rm"), prop.getProperty("password_rm"));
//		homepage = loginpage.PerformLogin(prop.getProperty("username_hr"), prop.getProperty("password_hr"));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		//loginpage.PerformLogout();
		driver.quit();

	}

	@Test(priority = 0)
	public void ValidateHomePageTitle() {
		String pt = homepage.ValidateHomePageTitle();
		Reporter.log("Home Page Title is: " + pt, true);
		assertEquals(pt, "::SalesForceManagement::");

	}

	@Test(priority = 1)
	public void ValidateHomePageURL() {
		String hp_url = homepage.ValidateHomePageURL();
		Reporter.log("HomePageURL is " + hp_url, true);
		assertEquals(hp_url, "http://103.231.43.144/home");

	}

	@Test(priority = 2)
	public void ValidateHomePageHCMLogo() {
		boolean logo = homepage.VerifySFMLogo();
		if (logo) {
			Reporter.log("SFM Logo is Displayed in Home Page", true);
		} else {
			Reporter.log("SFM Logo is Not Displayed in Home Page", true);
		}
		assertTrue(logo);

	}

}

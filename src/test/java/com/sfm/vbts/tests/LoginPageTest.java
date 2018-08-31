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





public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil util;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void SetUp() throws InterruptedException, IOException {
		browser_init();
		loginpage = new LoginPage();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		//loginpage.PerformLogout();
		driver.quit();
	}

	@Test(priority = 0)
	public void ValidateLoginPageTitle() {
		String pt = loginpage.ValidateLoginPageTitle();
		Reporter.log("Login Page Title is: " + pt, true);
		assertEquals(pt, "SFM");

	}

	@Test(priority = 1)
	public void ValidateLoginPageURL() {
		String lp_url = loginpage.ValidateLoginPageURL();
		Reporter.log("LoginPageURL is " + lp_url, true);
		assertEquals(lp_url, "http://103.231.43.144/");

	}

	@Test(priority = 2)
	public void ValidateLoginPageCenterpointLogo() {
		boolean cp_logo = loginpage.VerifyCenterpointLogo();
		if (cp_logo) {
			Reporter.log("Centerpoint Logo is Displayed in Login Page", true);
		} else {
			Reporter.log("Centerpoint Logo is Not Displayed in Login Page", true);
		}
		assertTrue(cp_logo);

	}

	@Test(priority = 3)
	public void Login() throws InterruptedException, IOException {
		homepage = loginpage.PerformLogin(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.takeScreenshotAtEndOfTest();
	}
	
	

}

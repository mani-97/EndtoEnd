package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_001_LoginTest extends BaseClass {


	@Test
	public void loginTest() throws IOException {

		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		//log.info("Entered username");
		lp.setPassword(password);
	//	log.info("Entered password");
		lp.clickSubmit();
		if(driver.getTitle().equals(" GTPL Bank Manager HomePage")) {

			Assert.assertTrue(true);
			//log.info("login test passed");
		}
		else {
			getScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			//log.info("login test failed");
		}
	}
	


}

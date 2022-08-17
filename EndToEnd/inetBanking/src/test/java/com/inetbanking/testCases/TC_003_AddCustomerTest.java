package com.inetbanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_003_AddCustomerTest extends BaseClass{
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	//log.info("username is provided");
	lp.setPassword(password);
	//log.info("password is provided");
	lp.clickSubmit();
	Thread.sleep(2000);
	AddCustomerPage addcus=new AddCustomerPage(driver);
	//log.info("providing customer details..");
	
	addcus.clickAddNewCustomer();
	addcus.custName("Manik");
	addcus.custgender("male");
	addcus.custdob("22","03","1996");
	Thread.sleep(2000);
	addcus.custaddress("121,nehruStreet");
	addcus.custcity("chennai");
	addcus.custstate("TamilNadu");
	addcus.custpinno("123456");
	addcus.custtelephoneno("1234567890");
	String email=randomestring()+"@gmail.com";
	addcus.custemailid(email);
	addcus.custsubmit();
	
	//log.info("validation started...");
	boolean res=driver.getPageSource().contains("Cutomer Registered Successfully!!!");	
	if(res==true) {
		Assert.assertTrue(true);
		//log.info("test case passed...");
	}
	else {
		//log.info("test case failed...");
		getScreenshot(driver, "addNewCustomer");
		Assert.assertTrue(false);
		
	}
	}
	
}

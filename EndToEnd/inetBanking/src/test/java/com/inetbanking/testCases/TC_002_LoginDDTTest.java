package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_002_LoginDDTTest extends BaseClass{

	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		//log.info("user name provided");
		lp.setPassword(pwd);
		//log.info("Password provided");
		lp.clickSubmit();
		
		if(isAlertPresent()==true) { //if true ourcase is  fail or false ourcase is pass go else
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			//log.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);     
		//log.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
		}
	}
	public boolean isAlertPresent() { //user defined method created to check alert is present or not		
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		String path="D:\\EndToEnd\\inetBanking\\src\\test\\java\\com\\inetbanking\\testData\\data.xlsx";
		int rownum=XLUtils.getRowCount(path,"Sheet1");	
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		String logindata[][]=new String[rownum][colcount];	
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++) {	
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return logindata;	
	}
}

package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver){
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
	}
	@FindBy(how=How.XPATH,using="//a[text()='New Customer']")
	WebElement lnkAddNewCustomer;
	
	@FindBy(how=How.NAME,using="name")
	WebElement txtCustomerName;
	@FindBy(how=How.NAME,using="rad1")
	WebElement rdGender;
	@FindBy(how=How.ID_OR_NAME, using="dob")
	WebElement txtdob;
	@FindBy(how=How.NAME, using="addr")
	WebElement txtaddress;
	@FindBy(how=How.NAME, using="city")
	WebElement txtcity;
	@FindBy(how=How.NAME,using="state")
	WebElement txtstate;
	@FindBy(how=How.NAME, using="pinno")
	WebElement txtpinno;
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement txttelephoneno;
	@FindBy(how=How.NAME,using="emailid")
	WebElement txtemailid;
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	@FindBy(how=How.NAME, using="res")
	WebElement btnReset;
	
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}
	public void custName(String cname) {
	txtCustomerName.sendKeys(cname);
	}
	public void custgender(String cgender) {
		rdGender.click();
	}
	public void custdob(String dd,String mm,String yy) {
		txtdob.sendKeys(dd);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(yy);	
	}
	public void custaddress(String caddress) {
	txtaddress.sendKeys(caddress);
	}
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	public void custpinno(String cpinno) {// sendkeys not support int so it convert
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}
	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}
	public void custsubmit() {
		btnSubmit.click();
	}
	public void custreset() {
		btnReset.click();
	}
	
	
	
	
	
}

package com.inetbanking.testCases;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	
		
	public static WebDriver driver;
	//public static Logger log;

	@Parameters("browser")
	@BeforeClass
	public void setup(String browse) {
	//	log=Logger.getLogger("ebanking");
	//	PropertyConfigurator.configure("log4j.properties");	
		if(browse.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if(browse.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		//log.info("URL is opened");
	}
	
	public void getScreenshot(WebDriver driver,String testcaseName) throws IOException {
	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		String filePath=System.getProperty("user.dir")+"\\Screenshots\\"+testcaseName+".png";
		FileUtils.copyFile(sourceFile,new File(filePath));
		System.out.println("Screenshot taken");
	}
	public String randomestring() {
		//every time it generate new letters(a-z) with in size of 8
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return (generatedstring);
		}
		public String randomeNum() {
			//every time it generate new numbers(0-9) with in size of 5
			String generatedNum=RandomStringUtils.randomNumeric(5);
			return (generatedNum);
			}

	
	@AfterClass
	public void tearDown(){
		//driver.quit();	
	}
}

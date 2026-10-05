package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import genericUtility.DatabaseUtility;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.UtilityClassObject;
import genericUtility.WebdriverUtility;
import objRepo.HomePage;
import objRepo.LoginPage;

public class BaseClass {
	public DatabaseUtility db = new DatabaseUtility();
	public WebdriverUtility wu = new WebdriverUtility();
	public PropertyUtility pu = new PropertyUtility();
	public ExcelUtility eu = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriver driver;
	public String parent;
	public static WebDriver sdriver;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void dataBaseConnection() throws Exception {
		System.out.println("===Connect to DB,Roeport config===");
		db.getDbConnection();
	}

	@Parameters("BROWSER")
	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
	public void launchBrowser() throws Exception {
		System.out.println("====launch the browser====");
		// String BROWSER=Browser;
		String browser = System.getProperty("browser", pu.readDataFromPropertyFile("Browser"));
		driver = wu.launchBrowser(browser);
		wu.maximizeBrowser(driver);
		wu.implicitlyWaitMethod(driver, 5);
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void loginToApplication() throws Exception {
		System.out.println("====login to applocation===");
		String url = System.getProperty("url", pu.readDataFromPropertyFile("Url"));
		String un = System.getProperty("username", pu.readDataFromPropertyFile("Username"));
		String pwd = System.getProperty("password", pu.readDataFromPropertyFile("Password"));
		driver.get(url);
		parent = driver.getWindowHandle();
		LoginPage lp = new LoginPage(driver);
		lp.login(un, pwd);
	}

//	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
//	public void logoutFromApplication() throws Exception {
//		System.out.println("===logout===");
//		HomePage hp = new HomePage(driver);
//		hp.logout();
//	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void closeBrowser() {
		System.out.println("===close the browser====");
		driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void closeDbConnection() throws Exception {
		System.out.println("=====CloseDb,ReportBackup===");
		db.closConnection();
	}

}

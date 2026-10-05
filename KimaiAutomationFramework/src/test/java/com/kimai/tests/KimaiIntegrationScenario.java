package com.kimai.tests;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.comcast.crm.basetest.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import objRepo.ActivitiesPage;
import objRepo.AllTimesPage;
import objRepo.CreateActivityPage;
import objRepo.CreateAllTimesPage;
import objRepo.CreateCustomersPage;
import objRepo.CreateProjectsPage;
import objRepo.CustomersPage;
import objRepo.HomePage;
import objRepo.ProjectsPage;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class KimaiIntegrationScenario extends BaseClass {
	ExcelUtility eu = new ExcelUtility();
	PropertyUtility pu = new PropertyUtility();
	JavaUtility ju = new JavaUtility();

	@Test(groups = "SmokeTest")
	public void verifyProjectWithCustomer() throws Exception {

		// homepage verification
		System.out.println(driver.getCurrentUrl());
		String acturl = "https://seleniumproject.kimai.cloud/en/timesheet/";
		String targeturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, targeturl);

		// verify customer from project
		// create customer
		HomePage hp = new HomePage(driver);
		hp.getAdministrationlink().click();
		hp.getCustomerlink().click();
		CustomersPage cp = new CustomersPage(driver);
		cp.getCreatebtn().click();
		CreateCustomersPage cc = new CreateCustomersPage(driver);
		String ccname = eu.readDataFromExcel("Customers", 1, 0);
		cc.createCustomer(ccname);

		// navigateback
		driver.navigate().back();

		// create Project

		hp.getProjectlink().click();
		ProjectsPage pp = new ProjectsPage(driver);
		pp.getCreatebtn().click();
		String pname = eu.readDataFromExcel("Projects", 1, 0);
		String pcname = eu.readDataFromExcel("Projects", 1, 2);
		CreateProjectsPage cpp = new CreateProjectsPage(driver);
		cpp.createProject(pname, pcname);
		String act = pcname;
		String targt = driver.findElement(By.xpath("//span[@class='pe-1 label-customer']")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(act, targt);

	}

	@Test(groups = "RegressionTest")
	public void verifyActivityWithProject() throws Exception {

		// homepage verification
		System.out.println(driver.getCurrentUrl());
		String acturl = "https://seleniumproject.kimai.cloud/en/timesheet/";
		String targeturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, targeturl);

		// create Activity
		HomePage hp = new HomePage(driver);
		hp.getAdministrationlink().click();
		hp.getActivitieslink().click();
		ActivitiesPage ap = new ActivitiesPage(driver);
		ap.getCreatebtn().click();
		CreateActivityPage ca = new CreateActivityPage(driver);
		String aName = eu.readDataFromExcel("Activities", 1, 0);
		String pName = eu.readDataFromExcel("Activities", 1, 2);
		ca.createActivity(aName, pName);

	}

	@Test(groups = "RegressionTest")
	public void verifyAllTimesSheetPageWithProjectandActivity() throws Exception {

		// homepage verification
		System.out.println(driver.getCurrentUrl());
		String acturl = "https://seleniumproject.kimai.cloud/en/timesheet/";
		String targeturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, targeturl);

		// create timesheet
		HomePage hp = new HomePage(driver);
		hp.getAlltimeslink().click();
		AllTimesPage at = new AllTimesPage(driver);
		at.getCreatebtn().click();
		CreateAllTimesPage ac = new CreateAllTimesPage(driver);
		String time = eu.readDataFromExcel("Timesheets", 1, 2);
		String pname = eu.readDataFromExcel("Timesheets", 1, 4);
		String aname = eu.readDataFromExcel("Timesheets", 1, 5);
		ac.createAllTimes(time, pname, aname);

	}

}

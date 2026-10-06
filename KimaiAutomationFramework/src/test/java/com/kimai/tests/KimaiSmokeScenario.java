package com.kimai.tests;

import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import objRepo.AllTimesPage;
import objRepo.CreateAllTimesPage;
import objRepo.CreateCustomersPage;
import objRepo.CreateProjectsPage;
import objRepo.CustomersPage;
import objRepo.HomePage;
import objRepo.ProjectsPage;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class KimaiSmokeScenario extends BaseClass {
	@Test(groups = "SmokeTest")
	public void createCustomerTest() throws Exception {

		// homepage verification
		System.out.println(driver.getCurrentUrl());
		String acturl = "https://seleniumproject.kimai.cloud/en/timesheet/";
		String targeturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, targeturl);
		// create customer
		HomePage hp = new HomePage(driver);
		hp.getAdministrationlink().click();
		hp.getCustomerlink().click();
		CustomersPage cp = new CustomersPage(driver);
		cp.getCreatebtn().click();
		CreateCustomersPage cc = new CreateCustomersPage(driver);
		String ccname = eu.readDataFromExcel("Customers", 1, 0);
		cc.createCustomer(ccname);
	}

	@Test(groups = "SmokeTest")
	public void createProject() throws Exception {

		// homepage verification
		System.out.println(driver.getCurrentUrl());
		String acturl = "https://seleniumproject.kimai.cloud/en/timesheet/";
		String targeturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, targeturl);
		// create project
		HomePage hp = new HomePage(driver);
		hp.getAdministrationlink().click();
		hp.getProjectlink().click();
		ProjectsPage pp = new ProjectsPage(driver);
		pp.getCreatebtn().click();
		String pname = eu.readDataFromExcel("Projects", 1, 0);
		String pcname = eu.readDataFromExcel("Projects", 1, 2);
		CreateProjectsPage cpp = new CreateProjectsPage(driver);
		cpp.createProject(pname, pcname);
	}

	@Test(groups = "SmokeTest")
	public void createTimesheet() throws Exception {

		// homepage verification
		System.out.println(driver.getCurrentUrl());
		String acturl = "https://seleniumproject.kimai.cloud/en/timesheet/";
		String targeturl = driver.getCurrentUrl();
		Assert.assertEquals(acturl, targeturl);
		// click on create on timesheet page
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

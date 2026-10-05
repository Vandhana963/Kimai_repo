package com.kimai.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import genericUtility.ExcelUtility;
import objRepo.ActivitiesPage;
import objRepo.AllTimesPage;
import objRepo.CreateActivityPage;
import objRepo.CreateAllTimesPage;
import objRepo.CreateCustomersPage;
import objRepo.CreateProjectsPage;
import objRepo.CreateUserPage;
import objRepo.CustomersPage;
import objRepo.HomePage;
import objRepo.ProjectsPage;
import objRepo.UserInfoPage;
import objRepo.UsersPage;

@Listeners(com.comcast.crm.ListenerUtility.ListenerImpClass.class)
public class KimaiSystemScenario extends BaseClass {
	ExcelUtility eu = new ExcelUtility();

	@Test(groups = "SmokeTest")
	public void CreateUser() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getSystemlink().click();
		hp.getUserlink().click();
		UsersPage up = new UsersPage(driver);
		up.getCreatebtn().click();
		CreateUserPage cu = new CreateUserPage(driver);
		String username = eu.readDataFromExcel("Users", 1, 0);
		String emailid = eu.readDataFromExcel("Users", 1, 1);
		String pwd = eu.readDataFromExcel("Users", 1, 2);
		String cnfpwd = eu.readDataFromExcel("Users", 1, 3);
		cu.createUser(username, emailid, pwd, cnfpwd);

	}

	@Test(groups = "RegressionTest")
	public void verifyBusinessFlow() throws Exception {
		HomePage hp = new HomePage(driver);

		hp.getAdministrationlink().click();
		hp.getCustomerlink().click();
		CustomersPage cp = new CustomersPage(driver);
		cp.getCreatebtn().click();
		CreateCustomersPage cc = new CreateCustomersPage(driver);
		String ccname = eu.readDataFromExcel("Customers", 1, 0);
		cc.createCustomer(ccname);
		Thread.sleep(1000);
		hp.getProjectlink().click();
		ProjectsPage pp = new ProjectsPage(driver);
		pp.getCreatebtn().click();
		String pname = eu.readDataFromExcel("Projects", 1, 0);
		String pcname = eu.readDataFromExcel("Projects", 1, 2);
		CreateProjectsPage cpp = new CreateProjectsPage(driver);
		cpp.createProject(pname, pcname);
		Thread.sleep(1000);

		hp.getActivitieslink().click();
		ActivitiesPage ap = new ActivitiesPage(driver);
		ap.getCreatebtn().click();
		CreateActivityPage ca = new CreateActivityPage(driver);
		String aName = eu.readDataFromExcel("Activities", 1, 0);
		String pName = eu.readDataFromExcel("Activities", 1, 2);
		ca.createActivity(aName, pName);
		Thread.sleep(1000);

		hp.getAlltimeslink().click();
		AllTimesPage at = new AllTimesPage(driver);
		at.getCreatebtn().click();
		CreateAllTimesPage ac = new CreateAllTimesPage(driver);
		String time = eu.readDataFromExcel("Timesheets", 1, 2);
		String prname = eu.readDataFromExcel("Timesheets", 1, 4);
		String aname = eu.readDataFromExcel("Timesheets", 1, 5);
		ac.createAllTimes(time, prname, aname);

	}

	@Test(groups = "RegressionTest")
	public void verifyUserDeactivation() throws Exception {
		HomePage hp = new HomePage(driver);
		hp.getSystemlink().click();
		hp.getUserlink().click();
		UsersPage up = new UsersPage(driver);

		String username1 = eu.readDataFromExcel("Users", 1, 0);
		up.getSearchtxt().sendKeys(username1);
		up.getSearchbtn().click();
		UserInfoPage ui = new UserInfoPage(driver);
		ui.deactivateUser();
		
		ui.reactivateUser();
	}

}

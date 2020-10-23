package TestCases;

import org.testng.annotations.Test;

import org.testng.AssertJUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.HealthInsurancePage;
import pageClasses.LandingPage;

public class HealthInsuranceMenuTest extends BaseTestClass{
	LandingPage landingPage;
	HealthInsurancePage healthInsurancePage;
	
	@Test
	public void getItemsUnderHealthInsurance() {
		logger = report.createTest("Get Health Insurance Plans : " + "trial");
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		landingPage.getSubmenuItems();
		driver.close();
	}

	@Test(dependsOnMethods = "getItemsUnderHealthInsurance")
	public void isHealthInsuranceClickable() {
		logger = report.createTest("Click Health Insurance Plans : " + "trial");
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		healthInsurancePage = landingPage.clickHealthInsurancePlans();
		driver.quit();
	}
}

package TestCases;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.LandingPage;
import pageClasses.TravelInsurancePage;
import pageClasses.InsuranceListPage;

public class InsuranceListTest extends BaseTestClass{
	LandingPage landingPage;
	TravelInsurancePage travelInsurancePage;
	InsuranceListPage insuranceListPage;
	
	//@Test
	public void displayTravelInsurance( ) {
		
		logger = report.createTest("Get Travel Insurance Plans : " + "trial");
		invokeBrowser("Chrome");
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = pageBase.OpenApplication();
		travelInsurancePage = landingPage.clickTravelInsurance();
		insuranceListPage = travelInsurancePage.fillDetailsTravel();
		insuranceListPage.showInsurance();
		
	}

}

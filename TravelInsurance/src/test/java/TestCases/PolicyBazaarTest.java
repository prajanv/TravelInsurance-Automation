package TestCases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.CarInsurancePage;
import pageClasses.FillDetailsForCarPage;
import pageClasses.HealthInsurancePage;
import pageClasses.InsuranceListPage;
import pageClasses.LandingPage;
import pageClasses.SelectCarBrandPage;
import pageClasses.SelectCarFuelPage;
import pageClasses.SelectCarModelPage;
import pageClasses.SelectCarVariantPage;
import pageClasses.SelectCarYearPage;
import pageClasses.SelectRtoPage;
import pageClasses.TravelInsurancePage;
import utilities.TestDataProvider;

public class PolicyBazaarTest extends BaseTestClass{
	LandingPage landingPage;
	HealthInsurancePage healthInsurancePage;
	CarInsurancePage carInsurancePage;
	SelectRtoPage selectRtoPage;
	SelectCarBrandPage selectCarBrandPage;
	SelectCarModelPage selectCarModelPage;
	SelectCarFuelPage selectCarFuelPage;
	SelectCarVariantPage selectCarVariantPage;
	SelectCarYearPage selectCarYearPage;
	FillDetailsForCarPage fillDetailsForCarPage;
	TravelInsurancePage travelInsurancePage;
	InsuranceListPage insuranceListPage;
	
	@Test(dataProvider="displayTravelInsuranceTestData", groups={"Regression Suite"})
	public void displayTravelInsurance(Hashtable<String, String> testData) {
		logger = report.createTest("Get Travel Insurance Plans : " + testData.get("Comments"));
		invokeBrowser();
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = OpenApplication();
		travelInsurancePage = landingPage.clickTravelInsurance();
		insuranceListPage = travelInsurancePage.fillDetailsTravel(testData.get("Destination"),testData.get("StudentAge1"),testData.get("StudentAge2"),testData.get("StartDate"), testData.get("EndDate"), 
		testData.get("Honorific"), testData.get("TravellerName"), testData.get("TravellerPhone"), testData.get("TravellerEmail"));
		insuranceListPage.showInsurance( testData.get("SelectSum"), testData.get("SelectSort"));
	}
	
	@Test(dataProvider="getCarInsuranceDetailsTestData", groups={"Regression Suite"})
	public void getCarInsuranceDetails(Hashtable<String, String> testData) {
		logger = report.createTest("Get Car Insurance Plans : " + testData.get("Comments"));
		invokeBrowser();
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = OpenApplication();
		carInsurancePage = landingPage.clickCarInsurance();
		selectRtoPage = carInsurancePage.clickProceedWithoutNumber();
		selectCarBrandPage = selectRtoPage.selectCityRto();
		selectCarModelPage = selectCarBrandPage.selectBrand();
		selectCarFuelPage = selectCarModelPage.selectModel();
		selectCarVariantPage = selectCarFuelPage.selectFuelType();
		selectCarYearPage = selectCarVariantPage.selectYear();
		fillDetailsForCarPage = selectCarYearPage.selectVariant();
		fillDetailsForCarPage.fillPersonalDetails(testData.get("ClientName"), testData.get("ClientEmail"), testData.get("ClientMobileNo"));
	}
	
	@Test(groups={"Smoke Suite"})
	public void getItemsUnderHealthInsurance() {
		logger = report.createTest("Get Health Insurance Plans");
		invokeBrowser();
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = OpenApplication();
		landingPage.getSubmenuItems();
	}

	@Test(groups={"Smoke Suite"})
	public void isHealthInsuranceClickable() {
		logger = report.createTest("Click Health Insurance Plans");
		invokeBrowser();
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = OpenApplication();
		healthInsurancePage = landingPage.clickHealthInsurancePlans();
	}
	
	@DataProvider
	public Object[][] getCarInsuranceDetailsTestData(){
		return TestDataProvider.getTestData("PolicyBazaar.xlsx", "PolicyBazaarCarInsurance", "GetCarInsuranceDetails");
	}
	
	@DataProvider
	public Object[][] displayTravelInsuranceTestData(){
		return TestDataProvider.getTestData("PolicyBazaar.xlsx", "PolicyBazaarTravelInsurance", "DisplayTravelInsurance");
	}

}

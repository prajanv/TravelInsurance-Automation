package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;
import baseClasses.PolicyBazaarLogoClass;

public class HealthInsurancePage extends PageBaseClass{
	public PolicyBazaarLogoClass policyBazaarLogoClass;
	public HealthInsurancePage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
		super.getTitle("Health Insurance: Compare Medical Insurance Plans in India");
		policyBazaarLogoClass = new PolicyBazaarLogoClass(driver, logger);
		PageFactory.initElements(driver,policyBazaarLogoClass);
	}
		
	public PolicyBazaarLogoClass gettopLogo(){
		return policyBazaarLogoClass;
	}
}

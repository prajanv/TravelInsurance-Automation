package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.ExtentTest;

import pageClasses.LandingPage;

public class PolicyBazaarLogoClass extends PageBaseClass{
	
	public PolicyBazaarLogoClass(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(className = "pb-logo")
	WebElement otherPolicyBazaarLogo;
	
	public LandingPage clickPolicyBazaar() {
		otherPolicyBazaarLogo.click();
		logger.log(Status.PASS, "Clicked on Policy Bazaar Logo");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver,landingPage);
		return landingPage;
	}

}

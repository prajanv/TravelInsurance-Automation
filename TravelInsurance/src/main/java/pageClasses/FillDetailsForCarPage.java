package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
import baseClasses.PolicyBazaarLogoClass;

public class FillDetailsForCarPage extends PageBaseClass{
	public PolicyBazaarLogoClass policyBazaarLogoClass;
	public FillDetailsForCarPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
		policyBazaarLogoClass = new PolicyBazaarLogoClass(driver, logger);
		PageFactory.initElements(driver,policyBazaarLogoClass);
	}
	
	@FindBy(id="name")
	public WebElement clientName;
	
	@FindBy(id="email")
	public WebElement clientEmail;
	
	@FindBy(id="mobileNo")
	public WebElement clientMobile;
	
	@FindBy(id="btnLeadDetails")
	public WebElement viewPrices;
	
	@FindBy(xpath="//input[@id='email']/following-sibling::div[2]")
	public WebElement emailError;
	
	@FindBy(xpath="//input[@id='mobileNo']/following-sibling::div[2]")
	public WebElement phoneError;
	
	public void fillPersonalDetails(String name, String email, String mobileNo) {
		clientName.sendKeys(name);
		logger.log(Status.PASS, "Entered the Name of the User");
		clientEmail.sendKeys(email);
		logger.log(Status.PASS, "Entered the Email ID of the User");
		clientMobile.sendKeys(mobileNo);
		logger.log(Status.PASS, "Entered the Mobile Number of the User");
		viewPrices.click();
		logger.log(Status.PASS, "Clicked on the View Prices Button");
		System.out.println("Invalid email id and mobile number gives the error:");
		System.out.println(emailError.getText());
		System.out.println(phoneError.getText());
		getErrorMessage(emailError.getText(), "Please enter a valid e-mail ID.");
		getErrorMessage(phoneError.getText(), "Please enter a valid 10-digit mobile number.");
		softAssert.assertAll();
	}
	
	public PolicyBazaarLogoClass gettopLogo(){
		return policyBazaarLogoClass;
	}

}

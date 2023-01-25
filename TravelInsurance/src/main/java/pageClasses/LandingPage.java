package pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {

	public LandingPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(linkText = "Other Insurance")
	public WebElement otherInsurance;
	
	@FindBy(linkText = "Travel Insurance")
	public WebElement travelInsurance;
	
	@FindBy(linkText = "Health Insurance")
	public WebElement healthInsuranceButton;
	
	@FindBy(xpath = "//a[text()='Health Insurance']/following-sibling::ul/descendant::span")
	public List <WebElement> healthInsuranceMenu;
	
	@FindBy(linkText = "Health Insurance Plans")
	public WebElement healthInsurancePlans;
	
	@FindBy(linkText = "Motor Insurance")
	public WebElement motorInsurance;
	
	@FindBy(linkText = "Car Insurance")
	public WebElement carInsurance;
	
	public TravelInsurancePage clickTravelInsurance() {
		logger.log(Status.INFO, "Clicking Travel Insurance from the drop down");
		hoverOverElement(otherInsurance);
		waitForPresence(By.linkText("Travel Insurance"));
		travelInsurance.click();
		logger.log(Status.PASS, "Clicked on Travel Insurance");
		TravelInsurancePage travelInsurancePage = new TravelInsurancePage(driver, logger);
		PageFactory.initElements(driver, travelInsurancePage);
		return travelInsurancePage;
	}
	
	public void getSubmenuItems() {
		logger.log(Status.INFO, "Storing the Submenu Items from the Health Insurance drop down");
		hoverOverElement(healthInsuranceButton);
		System.out.println("The Submenu items under Health Insurance:");
		for(int i =0; i<healthInsuranceMenu.size(); i++) {
			System.out.println(healthInsuranceMenu.get(i).getText());
		}
		logger.log(Status.PASS, "Displayed the Submenu Items from the Health Insurance drop down");
	}
	
	public HealthInsurancePage clickHealthInsurancePlans() {
		logger.log(Status.INFO, "Clicking Travel Insurance from the drop down");
		hoverOverElement(healthInsuranceButton);
		waitForPresence(By.linkText("Health Insurance Plans"));
		healthInsurancePlans.click();
		logger.log(Status.PASS, "Clicked on Health Insurance");
		HealthInsurancePage healthInsurancePage = new HealthInsurancePage(driver, logger);
		PageFactory.initElements(driver, healthInsurancePage);
		return healthInsurancePage;
	}
	
	public CarInsurancePage clickCarInsurance() {
		logger.log(Status.INFO, "Clicking Car Insurance from the drop down");
		hoverOverElement(motorInsurance);
		waitForPresence(By.linkText("Car Insurance"));
		carInsurance.click();
		logger.log(Status.PASS, "Clicked on Car Insurance");
		CarInsurancePage carInsurancePage = new CarInsurancePage(driver, logger);
		PageFactory.initElements(driver, carInsurancePage);
		return carInsurancePage;
	}

	
}
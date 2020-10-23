package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;
//import baseClasses.TopMenuClass;

public class LandingPage extends PageBaseClass {

	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath = "/html/body/div[4]/nav/section/div/div/div[2]/div/ul/li[5]/a")
	public WebElement otherInsurance;
	
	@FindBy(linkText = "Travel Insurance")
	public WebElement travelInsurance;
	
	@FindBy(xpath = "/html/body/div[4]/nav/section/div/div/div[2]/div/ul/li[3]/a")
	public WebElement healthInsuranceButton;
	
	@FindBy(xpath = "//a[text()='Health Insurance']/following-sibling::ul")
	public WebElement healthInsuranceMenu;
	
	@FindBy(linkText = "Health Insurance Plans")
	public WebElement healthInsurancePlans;
	
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
		hoverOverElement(healthInsuranceButton);
		System.out.println(healthInsuranceMenu.getText());
	}
	
	public HealthInsurancePage clickHealthInsurancePlans() {
		hoverOverElement(healthInsuranceButton);
		waitForPresence(By.linkText("Health Insurance Plans"));
		healthInsurancePlans.click();
		HealthInsurancePage healthInsurancePage = new HealthInsurancePage(driver, logger);
		PageFactory.initElements(driver, healthInsurancePage);
		return healthInsurancePage;

	}
	
	
//		List<WebElement> submenu = driver.findElements(By.tagName("a"));
//		for (WebElement i : submenu) 
//			System.out.println(i.getText());
	
}
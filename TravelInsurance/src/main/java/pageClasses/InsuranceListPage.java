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

public class InsuranceListPage extends PageBaseClass {

	public InsuranceListPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//div[@class='date_birth']/select[1]")
	public WebElement sumInsured;

	@FindBy(xpath = "//div[@class='sort_price']//select")
	public WebElement sortBy;

	@FindBy(xpath = "//div[@id='child']/p[1]/img")
	public List<WebElement> insuranceCompany;

	@FindBy(xpath = "//div[@id='child']/p[2]/span[1]")
	public List<WebElement> insurancePlan;

	@FindBy(xpath = "//div[@id='child']//button[@class='md-button md-default-theme']")
	public List<WebElement> insuranceAmount;

	@FindBy(xpath = "//div[@class='header_fixed']/descendant::a[1]")
	public WebElement policyBazaarLogo;

	public void showInsurance(String sum, String sort) {
		waitForPresence((By.xpath("//div[@class='date_birth']/select[1]")));
		sumInsured.click();
		selectDropDownValue(sumInsured, sum);
		sortBy.click();
		selectDropDownValue(sortBy, sort);

		System.out.println("Travel Insurance Plans:");
		for (int i = 0; i < 3; i++) {
			logger.log(Status.INFO, "Storing the First Three Travel Insurance Plans");
			System.out.println(insuranceCompany.get(i).getAttribute("alt") + " " + insurancePlan.get(i).getText() + " "
					+ insuranceAmount.get(i).getText());
			logger.log(Status.PASS, "Displayed the First three Travel Insurance Plans");
		}
	}

	public LandingPage clickPolicyBazaar() {
		policyBazaarLogo.click();
		logger.log(Status.PASS, "Clicked on Policy Bazaar Logo");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
}

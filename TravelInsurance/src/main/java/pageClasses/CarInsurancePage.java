package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class CarInsurancePage extends PageBaseClass{
	public CarInsurancePage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(id = "carRegistrationNumber")
	public WebElement enterCarNumber;
	
	@FindBy(xpath = "//div[@class='details_right rightContent']//a[@class='do_not inverse']")
	public WebElement proceedWithoutCarNumber;

	public SelectRtoPage clickProceedWithoutNumber() {
		waitForPresence(By.xpath("//div[@class='details_right rightContent']//a[@class='do_not inverse']"));
		proceedWithoutCarNumber.click();
		logger.log(Status.PASS, "Clicked on Proceed Without Car Number Button");
		SelectRtoPage selectRtoPage = new SelectRtoPage(driver, logger);
		PageFactory.initElements(driver,selectRtoPage);
		return selectRtoPage;
	}
}

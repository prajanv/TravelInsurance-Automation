package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class SelectCarFuelPage extends PageBaseClass{
	
	public SelectCarFuelPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(id = "Diesel")
	public WebElement carFuel;
	
	public SelectCarVariantPage selectFuelType() {
		carFuel.click();
		logger.log(Status.PASS, "Selected the Car Fuel Type");
		SelectCarVariantPage selectCarVariantPage= new SelectCarVariantPage(driver, logger);
		PageFactory.initElements(driver,selectCarVariantPage);
		return selectCarVariantPage;
	}

}

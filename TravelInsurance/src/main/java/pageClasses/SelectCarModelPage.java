package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class SelectCarModelPage extends PageBaseClass{

	public SelectCarModelPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath = "//div[@id='modelScroll']/descendant::span[6]")
	public WebElement carModel;

	public SelectCarFuelPage selectModel() {
		carModel.click();
		logger.log(Status.PASS, "Selected the Car Model");
		SelectCarFuelPage selectCarFuelPage = new SelectCarFuelPage(driver, logger);
		PageFactory.initElements(driver,selectCarFuelPage);
		return selectCarFuelPage;
	}
}

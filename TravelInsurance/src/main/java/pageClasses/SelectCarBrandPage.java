package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class SelectCarBrandPage extends PageBaseClass{
	
	public SelectCarBrandPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath = "//ul[@class='slideInRight slideInRightanimated manufact-listcb']/descendant::span[3]")
	public WebElement carBrand;

	public SelectCarModelPage selectBrand() {
		carBrand.click();
		logger.log(Status.PASS, "Selected the Car Brand");
		SelectCarModelPage selectCarModelPage = new SelectCarModelPage(driver, logger);
		PageFactory.initElements(driver,selectCarModelPage);
		return selectCarModelPage;
	}
}

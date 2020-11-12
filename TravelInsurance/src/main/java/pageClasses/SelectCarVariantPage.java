package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class SelectCarVariantPage extends PageBaseClass{
	
	public SelectCarVariantPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath="//div[@id='variantScroll']/descendant::span[2]")
	public WebElement carVariant;
	
	public SelectCarYearPage selectYear() {
		carVariant.click();
		logger.log(Status.PASS, "Selected the Car Variant");
		SelectCarYearPage selectCarYearPage = new SelectCarYearPage(driver, logger);
		PageFactory.initElements(driver,selectCarYearPage);
		return selectCarYearPage;
	}

}

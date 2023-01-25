package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class SelectCarYearPage extends PageBaseClass{
	
	public SelectCarYearPage(RemoteWebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath="//ul[@class='slideInRight slideInRightanimated model-list']/descendant::span[2]")
	public WebElement carYear;
	
	public FillDetailsForCarPage selectVariant() {
		carYear.click();
		logger.log(Status.PASS, "Selected the Car Registration Year");
		FillDetailsForCarPage fillDetailsForCarPage = new FillDetailsForCarPage(driver, logger);
		PageFactory.initElements(driver,fillDetailsForCarPage);
		return fillDetailsForCarPage;
	}

}

package pageClasses;

import java.util.Iterator;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class ModifyAccessRolePage extends PageBaseClass {

	@FindBy(xpath = "//option[contains(text(),'Delivery Manager')]")
	public WebElement deliveryManager;

	@FindBy(id = "QTP_Add_PLR__Role")
	public WebElement addButton;

	@FindBy(name = "Save")
	public WebElement saveButton;

	public ModifyAccessRolePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	// Modifying the roles
	public void addAccessRole() {
		logger.log(Status.INFO, "Modifying the Accesss Roles");
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> itr = windowIDs.iterator();
		String mainPageID = itr.next();
		String accessModifyPageID = itr.next();
		driver.switchTo().window(accessModifyPageID);
		getTitle("Modify Roles");
		deliveryManager.click();
		addButton.click();
		saveButton.click();
		waitForLoad();
		driver.switchTo().window(mainPageID);
		logger.log(Status.INFO, "Modified the Access Roles");
	}

}

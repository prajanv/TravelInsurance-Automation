package pageClasses;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class InviteUserPage extends PageBaseClass{
	
	public InviteUserPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	public void goToInviteUserWindow()
	{
		Set<String> windowIDs = driver.getWindowHandles();
		Iterator<String> itr = windowIDs.iterator();
		String mainPageID = itr.next();
		String inviteUserPageID = itr.next();
		driver.switchTo().window(inviteUserPageID);
		getTitle("Common Agile Exe Proj_9th Oct 2020 : Search and Add Team Members");
		waitForLoad();
		driver.close();
		driver.switchTo().window(mainPageID);
	}
	

}

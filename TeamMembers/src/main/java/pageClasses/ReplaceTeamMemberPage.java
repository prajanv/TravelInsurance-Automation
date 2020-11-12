package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class ReplaceTeamMemberPage extends PageBaseClass {

	public ReplaceTeamMemberPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(name = "content")
	public WebElement replaceFrame;
	
	@FindBy(linkText = "Team Members")
	public WebElement teamMembersButton;
	
	public void goToReplaceTeamFrame() {
		driver.switchTo().frame(replaceFrame);
		getTitle("Team Member - Replace");
	}
	
	public TeamMemberPage navigateBack() {
		driver.switchTo().parentFrame();
		waitForClickable(By.linkText("Team Members"));
		teamMembersButton.click();
		TeamMemberPage teamMemberPage = new TeamMemberPage(driver, logger);
		PageFactory.initElements(driver, teamMemberPage);
		return teamMemberPage;
	}

}

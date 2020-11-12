package pageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClasses.PageBaseClass;

public class TeamMemberPage extends PageBaseClass {

	public TeamMemberPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(id = "KEY_BUTTON_Skill_Search-btnEl")
	public WebElement skillSearchIcon;

	@FindBy(linkText = "Team Members")
	public WebElement teamMembersButton;

	@FindBy(xpath = "//div[@class='x-grid-row-checker']")
	public WebElement checkBox;

	@FindBy(id = "KEY_LINK_Modify_Access_Roles-btnIconEl")
	public WebElement modifyAccessRole;

	@FindBy(id = "KEY_BUTTON_Skill_Matrix-btnIconEl")
	public WebElement resourceSkillMatrix;

	@FindBy(id = "KEY_BUTTON_Invite_User-btnIconEl")
	public WebElement inviteUserIcon;

	@FindBy(id = "KEY_BUTTON_Create_Virtual_User-btnIconEl")
	public WebElement virtualUserIcon;

	@FindBy(id = "KEY_BUTTON_Replace_Team_Member-btnIconEl")
	public WebElement replaceTeamMemberIcon;

	// Check if 'Skill Search' icon is present and click able
	public SkillSearchPage clickSkillSearchIcon() {
		logger.log(Status.INFO, "Clicking on Skill Search Icon");
		boolean iconPresence = skillSearchIcon.isDisplayed();
		boolean iconEnabled = skillSearchIcon.isEnabled();
		if (iconPresence == true && iconEnabled == true) {
			skillSearchIcon.click();
		}
		logger.log(Status.PASS, "Clicked on Skill Search Icon");
		SkillSearchPage skillSearchPage = new SkillSearchPage(driver, logger);
		PageFactory.initElements(driver, skillSearchPage);
		return skillSearchPage;
	}

	// Check if 'Resource Skill Matrix' icon is present and clickable
	public ResourceSkillMatrixPage clickResourceSkillMatrixIcon() {
		logger.log(Status.INFO, "Clicking on Skill Search Icon");
		boolean iconPresence = resourceSkillMatrix.isDisplayed();
		boolean iconEnabled = skillSearchIcon.isEnabled();
		if (iconPresence == true && iconEnabled == true) {
			resourceSkillMatrix.click();
		}
		logger.log(Status.PASS, "Clicked on Resource Skill Matrix Icon");
		ResourceSkillMatrixPage resourceSkillMatrixPage = new ResourceSkillMatrixPage(driver, logger);
		PageFactory.initElements(driver, resourceSkillMatrixPage);
		return resourceSkillMatrixPage;
	}

	// Check if 'Resource Skill Matrix' icon is present and clickable
	public InviteUserPage clickInviteUser() {
		logger.log(Status.INFO, "Clicking on Invite User Icon");
		boolean iconPresence = inviteUserIcon.isDisplayed();
		boolean iconEnabled = skillSearchIcon.isEnabled();
		if (iconPresence == true && iconEnabled == true) {
			inviteUserIcon.click();
		}
		logger.log(Status.PASS, "Clicked on Invite User Icon");
		InviteUserPage inviteUserPage = new InviteUserPage(driver, logger);
		PageFactory.initElements(driver, inviteUserPage);
		return inviteUserPage;

	}

	// Check if 'Resource Skill Matrix' icon is present and clickable
	public VirtualUserPage clickVirtualUser() {
		logger.log(Status.INFO, "Clicking on Virtual User Icon");
		boolean iconPresence = virtualUserIcon.isDisplayed();
		boolean iconEnabled = skillSearchIcon.isEnabled();
		if (iconPresence == true && iconEnabled == true) {
			virtualUserIcon.click();
		}
		logger.log(Status.PASS, "Clicked on Virtual User Icon");
		VirtualUserPage virtualUserPage = new VirtualUserPage(driver, logger);
		PageFactory.initElements(driver, virtualUserPage);
		return virtualUserPage;
	}

	// Check if 'Resource Skill Matrix' icon is present and clickable
	public ReplaceTeamMemberPage clickReplaceTeamMember() {
		logger.log(Status.INFO, "Clicking on Replace Team Member Icon");
		boolean iconPresence = replaceTeamMemberIcon.isDisplayed();
		boolean iconEnabled = skillSearchIcon.isEnabled();
		if (iconPresence == true && iconEnabled == true) {
			replaceTeamMemberIcon.click();
		}
		logger.log(Status.PASS, "Clicked on Replace Team Member Icon");
		ReplaceTeamMemberPage replaceTeamMemberPage = new ReplaceTeamMemberPage(driver, logger);
		PageFactory.initElements(driver, replaceTeamMemberPage);
		return replaceTeamMemberPage;
	}

	// Verifying 'Modify Access Role' icon
	public ModifyAccessRolePage verifyModifyAccessRole() {
		logger.log(Status.INFO, "Clicking on Modify Access Role Icon");
		checkBox.click();
		boolean iconPresence = modifyAccessRole.isDisplayed();
		boolean iconEnabled = skillSearchIcon.isEnabled();
		if (iconPresence == true && iconEnabled == true) {
			modifyAccessRole.click();
		}
		logger.log(Status.PASS, "Clicked on Modify Access Role Icon");
		ModifyAccessRolePage modifyAccessRolePage = new ModifyAccessRolePage(driver, logger);
		PageFactory.initElements(driver, modifyAccessRolePage);
		return modifyAccessRolePage;

	}

}

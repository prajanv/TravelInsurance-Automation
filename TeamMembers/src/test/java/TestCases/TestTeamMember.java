package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;
import pageClasses.CommonAgilePage;
import pageClasses.InviteUserPage;
import pageClasses.LandingPage;
import pageClasses.MainPage;
import pageClasses.ModifyAccessRolePage;
import pageClasses.ReplaceTeamMemberPage;
import pageClasses.ResourceSkillMatrixPage;
import pageClasses.SkillSearchPage;
import pageClasses.TeamMemberPage;
import pageClasses.VirtualUserPage;

public class TestTeamMember extends BaseTestClass {
	LandingPage landingPage;
	MainPage mainPage;
	CommonAgilePage commonAgilePage;
	TeamMemberPage teamMemberPage;
	InviteUserPage inviteUserPage;
	VirtualUserPage virtualUserPage;
	ReplaceTeamMemberPage replaceTeamMemberPage;
	SkillSearchPage skillSearchPage;
	ResourceSkillMatrixPage resourceSkillMatrixPage;
	ModifyAccessRolePage modifyAccessRolePage;

	@Test(priority = 0)
	public void testInviteUserIcon() {
		logger = report.createTest("Test the Resource Skill Search Icon : ");
		invokeBrowser();
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = OpenApplication();
		mainPage = landingPage.enterCredentials();
		commonAgilePage = mainPage.clickProjectName();
		teamMemberPage = commonAgilePage.clickTeamMember();
		inviteUserPage = teamMemberPage.clickInviteUser();
		inviteUserPage.goToInviteUserWindow();
	}

	@Test(priority = 1)
	public void testVariousIcons() {
		logger = report.createTest("Test the Various Icons : ");
		invokeBrowser();
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = OpenApplication();
		mainPage = landingPage.enterCredentials();
		commonAgilePage = mainPage.clickProjectName();
		teamMemberPage = commonAgilePage.clickTeamMember();
		virtualUserPage = teamMemberPage.clickVirtualUser();
		virtualUserPage.goToVirtualUserFrame();
		teamMemberPage = virtualUserPage.navigateBack();
		replaceTeamMemberPage = teamMemberPage.clickReplaceTeamMember();
		waitForLoad();
		replaceTeamMemberPage.goToReplaceTeamFrame();
		teamMemberPage = replaceTeamMemberPage.navigateBack();
		skillSearchPage = teamMemberPage.clickSkillSearchIcon();
		waitForLoad();
		skillSearchPage.goToSkillSearchFrame();
		teamMemberPage = skillSearchPage.navigateBack();
		resourceSkillMatrixPage = teamMemberPage.clickResourceSkillMatrixIcon();
		waitForLoad();
		resourceSkillMatrixPage.goToSkillMatrixFrame();
		teamMemberPage = resourceSkillMatrixPage.navigateBack();
	}

	@Test(priority = 2)
	public void testModifyAcessRoles() {
		logger = report.createTest("Test the Modify Access Roles Function : ");
		invokeBrowser();
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		landingPage = OpenApplication();
		mainPage = landingPage.enterCredentials();
		commonAgilePage = mainPage.clickProjectName();
		teamMemberPage = commonAgilePage.clickTeamMember();
		modifyAccessRolePage = teamMemberPage.verifyModifyAccessRole();
		modifyAccessRolePage.addAccessRole();
		waitForLoad();
	}

}

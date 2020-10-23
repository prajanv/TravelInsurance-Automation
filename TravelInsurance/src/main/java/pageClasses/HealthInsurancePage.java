package pageClasses;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;
import bsh.This;
import net.bytebuddy.implementation.bind.annotation.Super;

public class HealthInsurancePage extends PageBaseClass{
	public HealthInsurancePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
		super.getTitle("Health Insurance: Compare Medical Insurance Plans in India");
	}
	
}

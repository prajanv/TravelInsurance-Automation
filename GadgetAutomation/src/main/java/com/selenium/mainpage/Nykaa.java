package com.selenium.mainpage;

import org.openqa.selenium.Keys;

import org.testng.annotations.Test;

import com.selenium.base.BaseWeb;
import com.datadriven.framework.utils.WriteExcelDataFile;

public class Nykaa extends BaseWeb {

	@Test
	public void headphones() {
		invokeBrowser("browserName"); // Invoke Chrome or Opera or Edge browser
		openUrl("url");// Navigate to "Nykaa Fashion" website
		click("searchButton_xpath"); // Click on search button
		enterText("searchValue_xpath", "Bluetooth Headphones"); // Enter "Bluetooth Headphones" in the textbox
		enterKeys("searchValue_xpath", Keys.ENTER); // Enter "ENTER" key to search
		verifyPageTitle("Shop Designer Clothes &amp; Accessories Online from Top Indian Designers | Nykaa Fashion"); // Verify the pagetitle after search
		scrollWebpage("scrollPage_xpath"); // Scroll the webpage to view 
		clearText("minimumTextbox_xpath"); // Clear the minimum price value
		clearText("maximumTextbox_xpath"); // Clear the maximum price value
		enterText("minimumTextbox_xpath", "700"); // Enter "700" as the minimum price
		enterText("maximumTextbox_xpath", "1400"); // Enter "1400" as the maximum price
		waitForSlider("verifySlider_xpath", "aria-valuenow", "1400"); // Wait for the "aria-valuenow" attribute of the slider to reflect the maximum value
		click("applyButton_xpath"); // Click on the apply button
		waitForElement("verifyText_className", "700 - 1400"); // Wait for the text "700-1400" to appear on top of the page
		click("sortButton_xpath"); // Click on the sort button
		waitforButton("popularityButton_xpath"); // Wait for the dropdown list to appear
		click("popularityButton_xpath"); // Click on the "Popularity" button from the dropdown
		storeElements("itemBrand_xpath", "itemName_xpath", "itemPrice_xpath", "rupeeSymbol_xpath"); // Store the brand,name and price of the first five bluetooth headphones
		WriteExcelDataFile.setDataFile(itemMap); // Store the brand,name and price of the first five bluetooth headphones in an excel sheet
		quitBrowser(); // Quit the browser
	}

}

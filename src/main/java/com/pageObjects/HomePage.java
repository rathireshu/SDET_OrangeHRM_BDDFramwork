package com.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utilities.BaseTest;

public class HomePage extends BaseTest {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath= "//div[@class='oxd-main-menu-search']//input")
	WebElement searchBox;
	@FindBy(xpath= "//span[text()='My Info']")
	WebElement myInfoLink;	
	@FindBy(xpath= "//p[text()='paul  Collings']")
	WebElement userDropdownname;
	
	public boolean validateHomePageSearchBox()
	{
		return searchBox.isDisplayed();	
	}
	public boolean validateHomePageUrl()
	{
		String homeUrl= driver.getCurrentUrl();
		return homeUrl.contains("dashboard");
	}
	public boolean validateLoggedInUser()
	{
		return userDropdownname.isDisplayed();
	}
}

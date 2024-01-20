package com.stepDefinition;

import org.testng.Assert;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.utilities.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OrangeHRMStepDefinition extends BaseTest {

	LoginPage loginPage;
	HomePage homePage;

	@Given("^User is already on OrangeHRM login page$")
	public void user_is_already_on_orange_hrm_login_page() {
		loginPage = new LoginPage();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM");
	}

	@When("^user enters given credentials and click on login button$")
	public void user_enters_credentials_and_click_login() {
		homePage = loginPage.login(pro.getProperty("username"), pro.getProperty("password"));
	}

	@When("^user provides given credentials \"(.*)\" and \"(.*)\" and click on login btn$")
	public void user_provides_username_and_password(String uname, String pwd) {
		homePage = loginPage.login(uname, pwd);
	}

	@Then("^user successfully loggedin and redirected to home page$")
	public void user_successfully_login_to_application() {

		Boolean searchBoxPresent = homePage.validateHomePageSearchBox();
		Assert.assertEquals(true, searchBoxPresent);
		System.out.println("step def:-- Successfully redirected to home page");
	}

	@Then("^validate home page url$")
	public void validate_home_page_title() {
		Assert.assertEquals(homePage.validateHomePageUrl(), true);
	}

	@Then("^validate logged in username$")
	public void validate_LoggedIn_user_home_page() {
		Assert.assertEquals(homePage.validateLoggedInUser(), true);
	}

	@When("^User enters username as \"(.*)\" and password as \"(.*)\" and click on login button$")
	public void user_enters_username_as_and_password_as_and_click_on_login_button(String usname, String pswd) {

		homePage = loginPage.login(usname, pswd);
	}

	@Then("^User should be able to see error message \"(.*)\"$")
	public void user_should_be_able_to_see_error_message(String error) {
		String errorMsg = loginPage.validateInvalidErrorMsg();
		Assert.assertEquals(error, errorMsg);
	}

	@Then("^close the browser$")
	public void close_browser() {
		driver.close();
	}

}

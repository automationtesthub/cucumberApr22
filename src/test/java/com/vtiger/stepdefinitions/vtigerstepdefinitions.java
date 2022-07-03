package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class vtigerstepdefinitions extends BaseTest {
	public LoginPage lp;
	public HomePage hp;
	public LeadPage ldp;
	
	 @After
		public void closeApp()
		{
			driver.quit();
		}
	
	@Given("user should be on login page")
	public void user_should_be_login_page() throws Exception {
		SetupPreconditions();
		lp= new LoginPage(driver);
		hp = new HomePage(driver);
		ldp = new LeadPage(driver);
	    
	}
	@When("user enters userid as {string} and password {string} and click on login button")
	public void user_enters_userid_as_and_password_and_click_on_login_button(String userid, String pwd) {
		lp.login(userid, pwd);
	}
	@Then("user can see error message on same page as {string}")
	public void user_can_see_error_message_on_same_page_as(String msg) {		
		lp.verifyErrorMsg();
	}
	
	@Then("user can will be navigated to the home page")
	public void user_can_will_be_navigated_to_the_home_page() {
		System.out.println("user can will be navigated to the home page");
	}
	@Then("user can logout link on the home page")
	public void user_can_logout_link_on_the_home_page() {
		
		hp.clickLogout();
	}
	
	@When("user click on new lead link")
	public void clickonnewlead() {
		hp.clickNewLead();
	}
	
	@When("user enters the firstname as {string} lastname as {string} and company as {string} and click on save buton")
	public void enterlastandcompanyname(String fname, String lname, String comp) {
		ldp.createlead(fname, lname, comp);
	}
	
	@Then("lead should be created successfuly")
	public void leadcreated() {
		ldp.verifyleadcreation();
	}

}

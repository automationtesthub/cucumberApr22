package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.vtiger.lib.CommonFunctions;

public class HeaderPage {
	
	 WebDriver driver;
	 CommonFunctions cf;
	
	
	public HeaderPage(WebDriver driver)
	{
		this.driver = driver;		
		PageFactory.initElements(driver, this);
		cf = new CommonFunctions(driver);
	}
	
	@FindBy(linkText="Logout")
	WebElement lnk_Logout;
	
	@FindBy(linkText="Leads")
	WebElement lnk_Leads;
	
	@FindBy(linkText="New Lead")
	WebElement lnk_NewLead;
	
	public void clickLogout()
	{
		cf.clickElement(lnk_Logout,"Link Logout");
	}
	
	public void clickLeads()
	{
		cf.clickElement(lnk_Leads,"Link Leads");
	}
	
	public void clickNewLead()
	{
		cf.clickElement(lnk_NewLead,"Link New Lead");
	}

}

package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LeadPage extends HeaderPage {

	public LeadPage(WebDriver driver) {
		super(driver);		
	}
	
	@FindBy(name="firstname")
	WebElement tb_firstname;
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button")
	WebElement btn_save;
	
	@FindBy(xpath="//td[@class='moduleTitle' and contains(text(),'Lead:')]")
	WebElement LeadHeader;
	
	public void createlead(String fname,String lname, String comp)
	{
		cf.entervalue(tb_firstname, fname);
		cf.entervalue(tb_lastname, lname);
		cf.entervalue(tb_company, comp);
		cf.clickElement(btn_save, "Save button");
	}
	
	public void verifyleadcreation()
	{
		cf.DisplayElement(LeadHeader, "Lead Headers");
	}

}

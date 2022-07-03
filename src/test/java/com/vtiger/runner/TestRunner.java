package com.vtiger.runner;

import org.junit.runner.RunWith;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/Features",
		glue={"com.vtiger.stepdefinitions"},
		plugin = { "pretty", "html:target/cucumber-html-report.html","json:target/cucumber.json" },
		tags = "@regression",
		monochrome = false
		
		
		)
public class TestRunner {
	
	

}

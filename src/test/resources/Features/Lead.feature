@Leads
Feature: Lead fuctionality

Background: 
Given user should be on login page
When user enters userid as "admin" and password "admin" and click on login button
Then user can will be navigated to the home page


@createlead @regression
Scenario Outline: create lead with mandatory fields
When user click on new lead link
And user enters the firstname as "<firstname>" lastname as "<lastname>" and company as "<company>" and click on save buton
Then lead should be created successfuly
Examples:
|firstname | lastname | company |
|Narendra  | Modi     | BJP     |
|Amit      | Shah     | BJP     |
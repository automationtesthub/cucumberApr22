@Sanity
Feature: Login fuctionality

Background: 
Given user should be on login page

@validlogin @regression
Scenario: Invalid login functionality
When user enters userid as "admin123" and password "12345" and click on login button
Then user can see error message on same page as "You must specify a valid username and password."

@InvalidLogin @regression
Scenario: valid login functionality
When user enters userid as "admin" and password "admin" and click on login button
Then user can will be navigated to the home page
And user can logout link on the home page


@Datadriven @regression
Scenario Outline: Invalid login functionality with multiple dataset
When user enters userid as "<userid>" and password "<password>" and click on login button
Then user can see error message on same page as "You must specify a valid username and password."

Examples:
|userid | password  |
|admin1 | password1 |
|admin2 | password2 |
|admin3 | password3 |
|admin4 | password4 |


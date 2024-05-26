Feature: Login Functionality

Scenario Outline: Login with Valid Credentials

Given User navigates to login page
When User enters valid email address <username> into the email field
And User enters valid password <password> into the password field
And User Clicks on login button
Then User should get successfully logged in
Examples:
|username                  |password   |
|anushasampathi08@gmail.com|Anu@9863   |
|amotooricap1@gmail.com    |12345      |


Scenario: Login with Invalid Credentials

Given User navigates to login page
When User enters invalid email address "anusha@gmail.com" into the email field
And User enters invalid password "123566" into the password field
And User Clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with Valid email and Invalid password

Given User navigates to login page
When User enters valid email address "anushasampathi08@gmail.com" into the email field
And User enters invalid password "154666" into the password field
And User Clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with Invalid email and valid password

Given User navigates to login page
When User enters invalid email address "anusha@gmail.com" into the email field
And User enters valid password "Anu@9863" into the password field
And User Clicks on login button
Then User should get a proper warning message about credentials mismatch


Scenario: Login without providing any credentials

Given User navigates to login page
When User dont enter email address into the email field
And User dont enter password into the password field
And User Clicks on login button
Then User should get a proper warning message about credentials mismatch

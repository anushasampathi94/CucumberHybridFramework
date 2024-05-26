Feature: Registration Functionality


Scenario: User creates an account only with mandatory fields

Given User navigates to Register Account page
When User enters below details
|firstName|Anusha|
|lastName|Sampathi|
|telephone|9052355749|
|password|12345|
And User selects Privacy Policy
And User clicks on Continue button
Then User account should get created successfully


Scenario: User creates an account only with all fields

Given User navigates to Register Account page
When User enters below details
|firstName|Jash|
|lastName|Chinta|
|telephone|9082355749|
|password|12345|
And User selects Privacy Policy
And User selects Newsletter
And User clicks on Continue button
Then User account should get created successfully


Scenario: User creates a duplicate account 

Given User navigates to Register Account page
When User enters below details with duplicate email
|firstName|Anusha|
|lastName|Sampathi|
|email|anushasampathi08@gmail.com|
|telephone|9052355748|
|password|Anu@9863|
And User selects Privacy Policy
And User clicks on Continue button
Then User should get a proper warning about duplicate email


Scenario: User creates an account without filling any details

Given User navigates to Register Account page
When User dont enter details
And User clicks on Continue button
Then User should get a proper warning messages for every mandatory field

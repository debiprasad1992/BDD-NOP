Feature: Adding Customer
@sanity
Scenario: Add a new customer 
	Given User Launch Chrome browser 
	When User opens URL "https://admin-demo.nopcommerce.com/" 
	And User enters Email as "admin@yourstore.com" ans Password as "admin" 
	And Click on Login 
	Then User Can View Dashboard 
	When User click on Cutomer menu 
	And Click on Cutomermenu item 
	And Click on Add new button 
	Then User Can view add new customer page 
	When User enter customer info 
	And click on Save button 
	Then User can view confirmaton message "The new customer added sucessfull" 
	And Close browser 
@Regression
Scenario: Search Customer by emailid 
	Given User Launch Chrome browser 
	When     User opens URL "https://admin-demo.nopcommerce.com/" 
	And     User enters Email as "admin@yourstore.com" ans Password as "admin" 
	And     Click on Login 
	Then     User Can View Dashboard 
	When     User click on Cutomer menu 
	And     Click on Cutomermenu item 
	And   Entered emailadd as "victoria_victoria@nopCommerce.com" for search 
	And   Click on Search button 
	Then   Userresult should be validated from table 
	And   Close browser 
Scenario: Search Customer by Firstname and Lastname 
	Given User Launch Chrome browser 
	When     User opens URL "https://admin-demo.nopcommerce.com/" 
	And     User enters Email as "admin@yourstore.com" ans Password as "admin" 
	And     Click on Login 
	Then     User Can View Dashboard 
	When     User click on Cutomer menu 
	And     Click on Cutomermenu item 
	And   Entered firstname as "victoria" and lastname as "Terces" 
	And   Click on Search button 
	Then   Userresult for name should be validated from table 
	And   Close browser 
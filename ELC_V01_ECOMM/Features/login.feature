#Feature: Login
#Scenario: Sucessful Login with Valid Credentials For Registered User
#   Given User Launch Chrome browser
#   When User opens URL "https://www.bumbleandbumble.com/account/signin.tmpl"
#   And User enters Email as "csstes2@gmail.com" ans Password as "Css@1234"
#   And Click on Login
#   Then validate Login Sucessful
#   Then Page Title should be "Account | Bumble and bumble."
#   And close browser
Feature: Guest Login
Scenario Outline:Validate IF SMS Optin is disabled for Guest User checkout
   Given User Launch Chrome browser
   When User opens URL "https://www.bumbleandbumble.com/account/signin.tmpl"
   And User enters Email as guest User "Randomuser.755523412@xyz.com" ans Password as "Css@1234"
   And Signin As Guest User
   Then validate Login Sucessful
   Then Page Title should be "Account | Bumble and bumble."
   And Validate News letter Option is disabled
   And close browser

Feature: n11 login
#https://so.n11.com/
@selleroffice-signup
Scenario: n11 selleroffice login
Given Ramazan open the login page
  And Ramazan Click The Signup Page
When Ramazan user must signed in selleroffice with valid credentials
  And Ramazan filled the extensions of the registration page
  Then Ramazan user signed in selleroffice successfully

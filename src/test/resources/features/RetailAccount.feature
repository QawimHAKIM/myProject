@jenkins
Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'email' and password 'password'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option

  @account1
  Scenario: Verify User can update Profile Information
    And User update Name 'firstName' and Phone 'phoneNumber'
    And User click on Update button
    Then user profile information should be updated

  #@account2
  #Scenario: Verify User can Update password
    #And User enter below information
      #| previousPassword | newPassword | confirmPassword |
      #| password         | newPassword | newPassword     |
    #And User click on Change Password button
    #Then a message should be displayed ‘Password Updated Successfully’

  @account3
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | cardNumber | fullName   |               5 |           2025 |          120 |
    And User click on Add your card button
    Then a message should be displayed ‘Payment Method added successfully’

  @account4
  Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber | nameOnCard | expirationMonth | expirationYear | securityCode |
      | cardNumber | fullName   |               6 |           2026 |          234 |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  @account5
  Scenario: Verify User can remove Debit or Credit card
    And User click on remove option of card section
    Then payment details should be removed

  @account6
  Scenario: Verify User can add an Address
    And User click on Add address option
    And User fill new address form with below information
      | country | fullName | phoneNumber | streetAddress | apt | city | state   | zipCode |
      | Canada  | fullName | phoneNumber | streetAddress | 123 | city | Ontario | zipCode |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’

  @account7
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And User fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city | state      | zipCode |
      | United States | fullName | phoneNumber | streetAddress | 123 | city | California | zipCode |
    And User click update Your Address button
    Then a message should be displayed Address Updated Successfully

  @account8
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed

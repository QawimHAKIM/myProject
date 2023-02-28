Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'test12345@outlook.com' and password 'Test@123456'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option

  @accountSmoke
  Scenario: Verify User can update Profile Information
    And User update Name 'QaTester' and Phone '032145698745'
    And User click on Update button
    Then user profile information should be updated

  Scenario: Verify User can Update password
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | Test@12345       | Test@123456 | Test@123456     |
    And User click on Change Password button
    Then a message should be displayed ‘Password Updated Successfully’

  @addPayment
  Scenario: Verify User can add a payment method
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard  | expirationMonth | expirationYear | securityCode |
      | 1234567891234567 | TestPayment |               5 |           2025 |          120 |
    And User click on Add your card button
    Then a message should be displayed ‘Payment Method added successfully’

  @editPayment
  Scenario: Verify User can edit Debit or Credit card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard  | expirationMonth | expirationYear | securityCode |
      | 1231231234567890 | PaymentTest |               6 |           2026 |          234 |
    And user click on Update Your Card button
    Then a message should be displayed ‘Payment Method updated Successfully’

  @removePayment
  Scenario: Verify User can remove Debit or Credit card
    And User click on remove option of card section
    Then payment details should be removed

  @addAddress
  Scenario: Verify User can add an Address
    And User click on Add address option
    And user fill new address form with below information
      | country | fullName | phoneNumber | streetAddress | apt | city    | state   | zipCode |
      | Canada  | Tester   |  1234567891 |           123 | 123 | Toronto | Ontario |   12345 |
    And User click Add Your Address button
    Then a message should be displayed ‘Address Added Successfully’

  @editAddress
  Scenario: Verify User can edit an Address added on account
    And User click on edit address option
    And User fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt | city | state      | zipCode |
      | United States | Tester   |  1231231233 |           123 | 123 | VA   | California |   12345 |
    And User click update Your Address button
    Then a message should be displayed ‘Address Updated Successfully

	@removeAddress
  Scenario: Verify User can remove Address from Account
    And User click on remove option of Address section
    Then Address details should be removed

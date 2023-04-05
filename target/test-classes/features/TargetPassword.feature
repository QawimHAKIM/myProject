@jenkins
Feature: Updating password for the UI

  @pass1
  Scenario: Verify User can Update password
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'email' and password 'password'
    And User click on login button
    And User should be logged in into Account
    When User click on Account option
    And User enter below information
      | previousPassword | newPassword | confirmPassword |
      | password         | newPassword | newPassword     |
    And User click on Change Password button
    Then a message should be displayed ‘Password Updated Successfully’

Feature: Login with valid Credentials
  
  Scenario: Successful login with valid credentials
    Given user Launch Browser
    When user Opens URL "https://practicetestautomation.com/practice-test-login/"
 		And user enters username as "student" and password as "Password123"
    And click On Submit
    Then page Title should be "Logged In Successfully | Practice Test Automation"
    When user Click on Logout
    Then page Title should be "Test Login | Practice Test Automation"
    And close Browser
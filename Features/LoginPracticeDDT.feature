Feature: Login Data Driven

  Scenario Outline: Login Data Driven
    Given user Launch Browser
    When user Opens URL "https://practicetestautomation.com/practice-test-login/"
 		And user enters username as "<username>" and password as "<password>"
    And click On Submit
    Then page Title should be "Logged In Successfully | Practice Test Automation"
    When user Click on Logout
    Then page Title should be "Test Login | Practice Test Automation"
    And close Browser
    

    Examples: 
      | username                  | password |
      | incorrectUser							| Password123 |
      | student         					| Password123  |
      | incorrectUser							| Password1234 |
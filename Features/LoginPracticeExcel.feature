Feature: Login Data Driven with Excel

  Scenario Outline: Login Data Driven Excel
    Given user Launch Browser
    When user Opens URL "https://practicetestautomation.com/practice-test-login/"
 		And user enters username as "<username>" and password as "<password>"
    And click On Submit
    Then check page title should be "Logged In Successfully | Practice Test Automation" by passing Email and Password with excel row "<row_index>"

    Examples:
      |row_index|
      |1|
      |2|
      |3|

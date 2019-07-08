Feature: Form automation
  To fill an application for work.

  Scenario Outline: Form submit
    Given user navigates to the app url
    When user fills first name "<firstName>"
    And user fills last name "<lastName>"
    And user fills gender
    And user fills date of birth "<dateOfBirth>"
    And user fills address
    And user fills email
    And user fills password
    And user fills company
    And user role QA
    And user select job expectations
    And user select ways of development
    And user fill comment
    And user click submit button
    Then form is submitted

    Examples:
      | firstName | lastName  | dateOfBirth |
      | Sergii    | Opanasiuk | 02/05/1988  |
      | Bill      | Murray    | 09/21/1950  |
      | Hugh      | Laurie    | 06/11/1959  |
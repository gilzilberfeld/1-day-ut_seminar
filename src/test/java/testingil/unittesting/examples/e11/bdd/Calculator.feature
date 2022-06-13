@tag
Feature: Calculator Cucumber Tests
  Operates calculator as unit tests

 Scenario: Calculate simple addition
    Given I have a calculator
    When I type in 1, "+", 1
    Then The result is "2"

  Scenario Outline: Multiple additions
    Given I have a calculator
    When I type in <value1> plus <value2>
    Then The result is "<result>"

    Examples:
      | value1 | value2 | result |
      | 1      | 2      | 3      |
      | 2      | 7      | 9      |

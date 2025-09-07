@PFCalculator
Feature: PF Calculator Automation
  This feature automates the Provident Fund (PF) Calculator on MoneyControl.

  Scenario: PF Calculator Positive Test
    Given I open the PF calculator page
    When I fill in the PF form details with data from excel "PositiveData"
    And I click on the calculate button for PF
    Then I take a screenshot of the PF result

  Scenario: PF Calculator Negative Test
    Given I open the PF calculator page
    When I submit the PF form without values
    Then I take a screenshot of the PF negative result
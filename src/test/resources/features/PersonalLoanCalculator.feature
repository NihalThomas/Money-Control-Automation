@PersonalLoanCalculator
Feature: Personal Loan Calculator Automation
  This feature automates the Personal Loan Calculator on MoneyControl.

  Scenario: Personal Loan Calculator Positive Test
    Given I open the Personal Loan calculator page
    When I fill in the Personal Loan form with data from excel "PositiveData"
    Then I take a screenshot of the Personal Loan page

  Scenario: Personal Loan Calculator Negative Test
    Given I open the Personal Loan calculator page
    When I fill in the Personal Loan form with data from excel "NegativeData"
    Then I take a screenshot of the Personal Loan negative result
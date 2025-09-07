@GratuityFundCalculator
Feature: Gratuity Fund Calculator Automation
  This feature automates the Gratuity Fund Calculator on MoneyControl.

  Scenario: Gratuity Fund Calculator Positive Test
    Given I open the Gratuity Fund calculator page
    When I fill in the Gratuity Fund form with data from excel "PositiveData"
    And I click on the submit button for Gratuity
    Then I take a screenshot of the Gratuity Fund result
    
  Scenario: Gratuity Fund Calculator Negative Test - Salary Zero
    Given I open the Gratuity Fund calculator page
    When I enter zero salary and submit the form
    Then I take a screenshot of the Gratuity Fund negative result

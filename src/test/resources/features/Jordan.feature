@Regression
Feature: Buy Jordan shoe

  Scenario: create account and make a purchase
    Given user create an account
    Then validate created account
    When user makes a purchase
    Then validate a item is bought
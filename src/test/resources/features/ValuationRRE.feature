@smoke
Feature: Valuation Functionality
@RRE
  Scenario: User should be able to do valuations for RRE
    Given User is on the portfolio page
    When the User navigates to the Property Valuation page
    And Set the details of property and valuate unit
    Then User should be able to see valuation results
    And User should be able to see the saved results
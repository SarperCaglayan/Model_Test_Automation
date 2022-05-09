@smoke
Feature: Commercial Property Valuation Functionality
  @CRE
  Scenario: User should be able to do valuations for CRE
    Given User is on the portfolio page
    When the User navigates to the Property Valuation page
    And Set the details of commercial property and valuate unit
    Then User should be able to see CRE valuation results
    And User should be able to see the saved CRE results
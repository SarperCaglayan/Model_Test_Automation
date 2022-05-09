@smoke
Feature: Adding and deleting unit functionality
  @unit  @add
  Scenario: User should be able to add a new unit
    Given User is on the login page
    When User navigates to the "Properties" page
    And Selects a group from the group list
    And Open adding unit popup and set the details
    Then User is able to add a new unit

  @unit
  Scenario: User should be able to delete a unit
    Given User is on the login page
    When User navigates to the "Properties" page
    And Selects a group from the group list
    And Select a unit from the list and delete
    Then User is able to delete a unit
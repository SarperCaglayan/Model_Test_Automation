@smoke
Feature: Login Functionality

  @login
  Scenario Outline: User should be able to login at different organizations
    Given User is on the login page
    When the user logs in using "<username>" and "<password>"
    Then User is on the main page
    Examples:
      | username                         | password     |
      | ugur+henryjames@skenariolabs.com | Q2MqbEWJQFB  |
      | ugur+makuti@skenariolabs.com     | UnVFEF9wemi6 |
      | ugur+espoo@skenariolabs.com      | mB8LLkk2242q |
      | ugur+testbank@skenariolabs.com   | GUPl5IEPbxzZ |

  @stg
  Scenario Outline: User should be able to login at staging environment
    Given User is on the staging login page
    When the user logs in using "<username>" and "<password>" at staging
    Then User is on the staging main page
    Examples:
      | username                         | password        |
      | ugur+ahtari@skenariolabs.com     | Qwert1234!qwert |
      | ugur+makuti_stg@skenariolabs.com | RL4urZ27N5Za    |
      | ugur+vaasa@skenariolabs.com      | 5U0rxGBV7cBV    |
      | ugur@skenariolabs.com            | BJale2013!      |
      #| ugur+bankstg@skenariolabs.com    | oAIaRAMt1DVq    |

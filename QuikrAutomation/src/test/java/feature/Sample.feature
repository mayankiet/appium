Feature: As a user I want to be able to login to Quikr App
  Scenario: Login to Quikr App
    When User is on Quikr app login Page
    And He provide user name
    And He provide password
    And click on login button
    Then He should be able to login with valid user name and password
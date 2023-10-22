Feature: Login Page SauceDemo

  @Positive
  Scenario: Success Login
    Given user open sauce demo website
    When user input valid username
    And input valid password
    When user click login button
    Then product page will appear

  @Negative
  Scenario: Failed Login
    Given user open sauce demo website
    When user input valid username
    And input invalid password
    When user click login button
    Then user got error message
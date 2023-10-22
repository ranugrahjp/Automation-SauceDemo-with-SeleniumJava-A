Feature: Sort n Filter Product

  Scenario: choose price (low to high)
    Given user success login
    When user click icon on top right of page
    And user choose price low to high
    Then page will display low until high price of product
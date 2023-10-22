Feature: Add To Cart

  Scenario: Add product to cart
    Given user have login
    When user click button Add to Cart in list of product
    And user click cart icon
    Then page will show the chosen product
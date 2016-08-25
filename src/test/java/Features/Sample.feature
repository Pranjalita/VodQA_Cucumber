Feature:Flipkart shopping site

  Scenario: sample
    Given I navigate to flipkart home page
    When I search for product "The cucumber book"
    Then I should see the product "The cucumber book" in search result
    When I select First available option
    And add it to shopping cart
    And I Go To Cart
    Then I should be able to place order






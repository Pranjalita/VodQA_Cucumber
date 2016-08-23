Feature:try

  Scenario: sample


    Given I navigate to flipkart home page
    When I search for product "The jungle book"
    Then I should see the product "The Jungle book" in search result
    When I select First available option
    And add it to shopping cart
    And I Go To Cart
    Then selected product "The Jungle book" should get added to cart




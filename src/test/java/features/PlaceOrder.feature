Feature: place the order for product


  
  Scenario: Search and Place the order
    Given User is on Landingpage
    When User searched the item "carrot" and Extracted actual name of product
    And Added "3" items selected product to the cart
    Then User navigates to the checkoutpage
    And validate items in checkout page
    And User is able to add promotion code and place order

 
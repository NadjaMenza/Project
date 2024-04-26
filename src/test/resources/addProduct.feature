Feature: Put a product in the cart
  Background:
    Given I open tesco online shop
#    And I accept cookies
    And  I am on the product page of online shop


  Rule: An adding products to shopping cart happens via clicking on the Add button

    Scenario: One item can be added
      Given text is visible 'Grocery basket empty'
      When I click on the "Add" button for the "<item_name>"
      Then the '<item_name>' is visible in the cart
      And "1 in trolley" is present on the product's cart
      When I click on the "Add" button for the "<item_name>"
      Then "2 in trolley" is present for the "<item_name>"


  Rule: Added products to shopping cart are visible in shopping cart

    Scenario: Add Item to Cart and Verify Visibility on the right bar
      Given text is visible 'Grocery basket empty'
      When I click on the "Add" button for the item "<item_name>"
      Then the '<item_name>' is visible in the cart on the right side of full mode screen

    Scenario: Add item to Cart and Verify Visibility in the cart, navigation through "View full basket"
      Given the shopping cart is empty 'Grocery basket empty'
      When I click on the "Add to Cart" button for the item "<item_name>"
      And I click button "View full basket"
      Then the '<item_name>' is in the cart



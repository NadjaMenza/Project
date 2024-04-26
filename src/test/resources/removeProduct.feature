Feature: Remove a product from the cart
  Background:
    Given I open tesco online shop
#    And I accept cookies
    And  I am on the product page of online shop

  Rule: Removing products from shopping cart is allowed

    Scenario Outline: Selected product could be removed from the basket
      Given I logged in on the tesco website using valid credentials
      And I am on the product page of online shop
      And I have <item_name> in the shopping cart
      When I click on the <sign> button <location>
      Then the '<item_name>' is removed from shopping cart
      And  "1 in trolley" is not present on the product's card
      And the text <Grocery basket empty> is visible on the right side shopping cart

      Examples:
        | item_name   | sign          | location                           |
        | example1    | minus         | on the product's card              |
        | example1    | minus         | on the right side shopping cart    |
        | example2    | cross sigh    | on the right side shopping cart    |


    Scenario: Selected product could be removed from "Trolley"
      Given I am on the trolley page of online shop
      And I have items in the shopping cart
      When I click on the button "Empty trolley"
      And I click button "Empty" in the pop up window
      Then the the text <Your trolley is empty> is visible



Feature: Navigate to home page
  Background:
    Given I open tesco online shop
#    And I accept cookies

  Rule: jumping to the home page by clicking home button

    Scenario Outline: Navigate to Home Page via logo button
      Given I am on the product page of online shop
      When I click on the <button>
      Then I should be directed to the home page

      Examples:
        | button   |
        | logo    |
        | breadcrumbs    |
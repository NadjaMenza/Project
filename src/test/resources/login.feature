Feature: Login
  Background:
    Given I open tesco online shop
    And I accept cookies

  Rule: an error should appears when user uses invalid credential

    Scenario: Error message is displayed using invalid credentials
      Given I click Sign in button
      When I enter credentials 'user@gmail.com' and '123456789'
      And I click on the sign in button
      Then the error message should be displayed 'Unfortunately we do not recognise those details. Please try again.'


  Rule: successful sign in of user using valid credential

    Scenario: successful sign in
      Given I click Sign in button
      When I enter credentials 'user@gmail.com' and '123456789'
      And I click on the sign in button
      Then I should see a welcome text on home page indicating successful login



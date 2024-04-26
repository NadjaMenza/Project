Feature: Change languages
  Background:
    Given I open tesco online shop
#    And I accept cookies

  Rule: change of language is allowed

    Scenario: change language
      Given language is set to 'english'
      When I press button hungarian flagMagyar
      Then language of website is changed to 'hungarian'
Feature: Ebay Advanced Search Page Scenarios

  Scenario: Ebay Logo
    Given I am on Ebay Advanced Search page
    When I click on Ebay Logo
    Then I navigate back to Ebay Homepage

  @P300 @setCookies
  Scenario: Advanced Search an item
    Given I am on Ebay Advanced Search page
    When I advanced search an item
      | keyword | exclude | min |max |
      | iPhone 11 | refurbished | 300 | 900 |
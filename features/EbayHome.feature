Feature: Ebay Homepage Scenarios

  Scenario: Advanced Search Link
    Given I am on Ebay Homepage
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  Scenario: Search item count
    Given I am on Ebay Homepage
    When I searched for iPhone 14
    Then I validate at least 2400 search items present

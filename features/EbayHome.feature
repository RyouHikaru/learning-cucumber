Feature: Ebay Homepage Scenarios

  @P0
  Scenario: Advanced Search Link
    Given I am on Ebay Homepage
    When I click on Advanced Link
    Then I navigate to Advanced Search page

  @P1 @setCookies @Test
  Scenario: Search item count
    Given I am on Ebay Homepage
    When I searched for 'iPhone 14'
    Then I validate at least 2400 search items present

  @P240 @setCookies
  Scenario: Search an item in category
    Given I am on Ebay Homepage
    When I search for 'soap' in 'Baby' category

  @P500
  Scenario Outline: Homepage Links
    Given I am on Ebay Homepage
    When I click on '<link>'
    Then I validate that page navigates to '<url>' and title contains '<title>'
    Examples:
      | link    | url                                                            | title       |
      | Motors  | https://www.ebay.com/b/Auto-Parts-and-Vehicles/6000/bn_1865334 | ebay Motors |
      | Fashion | https://www.ebay.com/b/Clothing-Shoes-Accessories/11450/bn_1852545                   | fashion     |
      | Toys    | https://www.ebay.com/b/Toys-Hobbies/220/bn_1865497             | Toys        |

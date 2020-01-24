@ui
Feature: Search for user's account in Facebook

  Scenario: Check user has account in Facebook
    Given I send request to get one random person name
    And I verify response status code is 200
    When I open Google Search Page
    And I input users name in search field
    And I click 'Search' button on Google Search page
    Then I should see Google Results page loaded
    And I verify there is a link to user account in Facebook


  Scenario: Search for random user from file
    Given I send request to get 100 people
    And I verify response status code is 200
    When I write down users data into .xlsx file
    And I open Google Search Page
    And I input random name from .xlsx file in search field
    And I click 'Search' button on Google Search page
    Then I should see Google Results page loaded
    And I verify there is a link to user account in Facebook

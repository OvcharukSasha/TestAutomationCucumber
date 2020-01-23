Feature: demo steps

    Scenario: Check response from Random User API is successful
        Given I send request to get 100 people
        Then I verify response status code is 200




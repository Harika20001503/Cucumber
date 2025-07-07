Feature: search and place order

  
  Scenario: Search experience in both product search and offer search
    Given user is on freencard landing page
    When user search with shortname "tom" and extracted product
    Then user search for "tom" shortname in offer page to check product

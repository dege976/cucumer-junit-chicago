Feature: DZone header
  @dzone
  Scenario:
    Given user goes to ""
    And user takes header
    Then user goes to ""
    And user takes header of that page
    Then user compares two headers

Feature:


  Scenario: Verify Collaboration menu options
    Given I logged into suiteCRM
    When I hover over the Collaboration menu
    Then the following menu options should be visible for Collaboration:
      | Home | Emails | Documents | Projects |

  Scenario Outline:
    When ghf"<a>"

Examples:
      | a     |
      | data2 |
      | row2  |
      | data3 |

  @aaa
  Scenario: Create contact using a map
   Given I logged into suiteCRM o When I create a new contact
  | first_name | John | | last_name | Smith | |cell_phone|8018888889 |



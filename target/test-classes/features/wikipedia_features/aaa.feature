Feature:
Background:
  Given home page

  Scenario Outline:verify login functionality
    When user enter user name  "<user name>"  and password"<password>"

    And i click on login button
#   Then use should see messege or heading"<heading>"
   Then verify types of tests "<posetive or negative>"



    Examples:
      | user name | password |posetive or negative|
      | Tester    | test     |positive            |
      | gkhagdfh  | test     |negative            |





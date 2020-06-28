Feature: Deleting teacher Service

  @teacherDelete
  Scenario: Positive teacher deleting
    Given user deletes teacher at "/teacher/delete/6562"
    And user gets teacher at "/teacher/6562"
    Then user verifies response message with "Teacher with id = 6562 NOT FOUND!"


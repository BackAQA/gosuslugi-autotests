Feature: Authorization on Gosuslugi
  Scenario: Failed login with wrong password
    Given I open authorization page
    When I enter login "+79889207429"
    And I enter password "wrong123"
    And I click button "Login"
    Then I see error message "Неверный логин или пароль"
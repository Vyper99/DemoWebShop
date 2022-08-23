Feature: Log-in

  @smoke #tag
  Scenario: Successful User Log-in

    #Given is what we need to run this test
    Given User has valid credentials

    #When is actual steps to run this test
    When User logs in

    #Then is to assert what's expected
    Then User logs in successfully

Feature: Digital Downloads

  Scenario: Successfully purchase Digital Download
    #Given is what we need to run this test
    Given None

    #When is actual steps to run this test
    When User Purchases music 2 under digital downloads

    #Then is to assert what's expected
    Then Checkout successfully

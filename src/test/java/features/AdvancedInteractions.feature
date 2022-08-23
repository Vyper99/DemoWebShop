Feature: Learning how to hover over

  Scenario: Hovering over Desktop Computers

    Given Customer is on Demo Web Shop

    When Customer hovers over Computers section

    Then Customer should see Desktop Section

    Scenario: Verify Book is in shopping cart

      Given health book is in shopping cart

      When customer hovers over shopping cart

      Then customer should see Health Book in shopping cart
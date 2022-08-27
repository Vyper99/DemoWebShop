Feature: Newsletter Signup

  Scenario: Successfully Sign Up For Newsletter

    When User Signs Up For Newsletter With Valid Email

    Then User Should See Success Message

  Scenario: Unsuccessful Sign Up

    When User Signs Up For Newsletter with Invalid Email

    Then User Should See Failure Message
Feature: Learning how to hover over

  Scenario: Hovering over Desktop Computers

    Given Customer is on Demo Web Shop

    When Customer hovers over Computers section

    Then Customer should see Desktop Section

  Scenario: Verify Book is in shopping cart

      Given health book is in shopping cart

      When customer hovers over shopping cart

      Then customer should see Health Book in shopping cart

  Scenario: Drag and Drop

      Given Customer on drag and drop page

      When Customer drags picture and drops in the box

      Then Customer should get success message

  Scenario: File Upload

    Given Customer on file upload page

    When Customer uploads a file

    Then File should be uploaded

  Scenario: Scrolling Down

    Given Customer on Scrolling Page

    When Customer scrolls down to the bottom of the page

  Scenario: Close Alert

    Given Customer on Alert Page

    When Customer clicks on alert

    Then Customer should get alert window



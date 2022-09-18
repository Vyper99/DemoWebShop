Feature: Testing Purchasing Different Items In DemoWebShop

  Scenario: Successfully purchase Accessory

    When User Adds TCP Self-paced Training To Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase DSLR Camera

    When User Adds DSLR Special Edition Camera To Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase Desktop Computer

    When User Adds Desktop to Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase Digital Download

    When User Adds music2 Under digital downloads To Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase Gift Card

    When User Adds Gift Card To Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase Jewelry

    When User Adds Jewelry To Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase Notebook Laptop

    When User Adds Laptop to Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase Phone Case

    When User Adds Cell Phone Cover to Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully


  Scenario: Successfully purchase Shoes

    When User Adds Blue and green Sneaker to Cart

    Then Verify Item Is In Cart

    Then Checks out Successfully




Feature: Validate the Add to cart functionality

  @SanityTest @NegativeScenario
  Scenario Outline: Verify error message when invalid search text entered on product dropdown
    Given User landed on bunnings.com
    When User enters "<searchtext>"
    Then Verify error message is displayed successfully with "<searchtext>"

    Examples: 
      | searchtext   |
      | selenium     |

  @SanityTest @PositiveScenario
  Scenario Outline: Verify images will be displayed wrt to valid search text
    Given User landed on bunnings.com
    When User enters "<searchtext>"
    Then Verify products wrt "<searchtext>" will get displayed
    Then Click on Add to cart button for the first displayed product
    Then Verify one quantity should get displayed
    Then Increase and decrease quantity and verify

    Examples: 
      | searchtext |
      | Hammer     |

  @SanityTest @PositiveScenario
  Scenario Outline: Verify images will be displayed wrt to valid search text
    Given User landed on bunnings.com
    When User enters "<searchtext>"
    Then Verify products wrt "<searchtext>" will get displayed
    Then Click on Add to cart button for the first displayed product
    Then Click on Review and Checkout and verify product details

    Examples: 
      | searchtext |
      | Hammer     |

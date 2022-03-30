@ui
Feature: Verify Cookie clicker Game

  Scenario Outline: Verify user should be able to start new game
    Given I navigate to cookie collect home page
    When I "<name>" start new game
    Then I navigate to cookie collect new game page
    And verify new game started successfully with values <cookies_count>,<factories_count> and <money>
    Examples:
      | name        | cookies_count  | factories_count  | money  |
      | Test1       | 0              | 0                | 0.0    |

  Scenario Outline: Verify user should be able to redirect to the home from game page
    Given I navigate to cookie collect home page
    And I "<name>" start new game
    When I click on cookie clicker link on game page
    Then I should navigate to cookie collect home page
    And page should have <name> with score <score>
    Examples:
      | name        | score  |
      | Test2       | 0      |

  Scenario Outline: Verify user should have the correct score in home page
    Given I navigate to cookie collect home page
    And I "<name>" start new game
    When I click on click cookie for <noOfCookies> times
    And I click on cookie clicker link on game page
    Then I should navigate to cookie collect home page
    And page should have <name> with score <score>
    Examples:
      | name        | noOfCookies | score  |
      | Test3       | 5         | 5      |
      | Test4       | 50        | 50     |

  Scenario Outline: Verify clicking on click Cookie should not increase factories or money count
    Given I navigate to cookie collect home page
    And I "<name>" start new game
    When I click on click cookie for <noOfCookies> times
    Then verify game should be with values <cookies_count>,<factories_count> and <money>
    Examples:
      | name        | noOfCookies  |cookies_count  | factories_count  | money  |
      | Test5       | 5          | 5             | 0                  | 0.0    |

  Scenario Outline: Should be able to sell all cookies and get money of 0.25 for every cookie
    Given I navigate to cookie collect home page
    And I "<name>" start new game
    And I click on click cookie for <noOfCookies> times
    When I sell <noOfCookiesToSell> cookies
    Then verify game should be with values <cookies_count>,<factories_count> and <money>
    Examples:
      | name  | noOfCookies | noOfCookiesToSell   |cookies_count  | factories_count | money  |
      | Test6 | 5           | 5                   | 0             | 0               | 1.25   |
      | Test7 | 5           | 4                   | 1             | 0               | 1      |

  Scenario Outline: Verify clicking on Sell cookies or Buy factories without entering anything in text box shouldn't update values
    Given I navigate to cookie collect home page
    And I "<name>" start new game
    When I sell <noOfCookiesToSell> cookies
    And I buy <noOfFactories> factories
    Then verify game should be with values <cookies_count>,<factories_count> and <money>
    Examples:
      | name  | noOfCookiesToSell  |noOfFactories  |cookies_count  | factories_count | money  |
      | Test8 |                    |               | 0             | 0               | 0.0    |

  Scenario Outline: Clicking on Buy factories shouldn't increase the cookies count
    Given I navigate to cookie collect home page
    And I "<name>" start new game
    And I click on click cookie for <noOfCookies> times
    When I buy <noOfFactories> factories
    Then factories count should be <factories_count>
    And verify the cookies count should not be more than <cookies_count>
    Examples:
      | name  | noOfCookies  |noOfFactories  |cookies_count  | factories_count |
      | Test9 | 100          | 10            | 90            | 10              |

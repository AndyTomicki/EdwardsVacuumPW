
Feature: 01 Sublinks specific to the tree

  Background:
    When user goes to "https://www-uat.edwardsvacuum.com/en-uk/semiconductor"
    Then user accepts cookies

  @Device:Desktop
  Scenario: Sublinks specific to the tree
  - rgb(196, 38, 46) - highlighted red
  - //i[@class='fa-kit fa-header-cart'] - little shopping cart icon
  - //span[@class='cmp-header-twentytwentyfour__quicklinks-item__link__text' and contains(text(),'Go to webshop')] - expanded shopping cart link
    Given verify that background colour of "//span[.='Semiconductor']/../.." element is "rgb(196, 38, 46)"
    # - little semiconductor icon [semiconductor-EXT] doesn't exist
    Then verify that "//i[@class='fa-kit fa-header-cart']" element is not visible
    And user clicks on "General industries" quick links menu item
    Then verify that background colour of "//span[.='General Industries']/../.." element is "rgb(196, 38, 46)"
    Then verify that "//i[@class='fa-kit fa-header-cart']" element is visible
    And size of "//i[@class='fa-kit fa-header-cart']" element is 20.109375 by 18 pixels
    Then user hovers over "//i[@class='fa-kit fa-header-cart']" element
    Then verify that "//span[@class='cmp-header-twentytwentyfour__quicklinks-item__link__text' and contains(text(),'Go to webshop')]" element is visible
    And size of "//span[@class='cmp-header-twentytwentyfour__quicklinks-item__link__text' and contains(text(),'Go to webshop')]" element is 161.67187 by 27 pixels



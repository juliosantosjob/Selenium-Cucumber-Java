#language:en

@regression @buy_product_all
Feature: Purchase of a Product
  - As a user, I should be able to make a purchase of a product on the website

  Background:
    Given the user accesses the site
    And accesses the login page
    And logs in with email "qaTest@gmail.com" and password "Change@123"

  @buy_product
  Scenario: Purchase of a product
    And search for the product "T-Shirt For Men"
    And add this item to the cart
    And proceed to checkout
    When they choose the payment method
    And confirm the purchase
    Then their purchase is completed successfully

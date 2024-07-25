
Feature: Add product
Actor:Admin
Desc: This '..'


  
  Scenario Outline: Add new product
    Given the name of product as <name>
    
    And this product has 23 items
    When press add button
    And some other action
    
    Then the new product should be added
    

  

    Examples: 
      | name  | 
      | cola |    
      | ppp |    

Feature: Post and Share Personal Dessert Creations

  Beneficiary users can post and share their personal dessert creations with other users on the platform.

  Scenario: Successful Posting of a Dessert Creation
    Given the user is logged into the Sweet System
    And the user is a beneficiary
    When the user provides a title "Orange Cake" and a description "Delicious homemade orange cake with fudge frosting."
    And the user provides an image "Orange_cake.jpg"
    And the user submits the dessert creation
    Then the dessert creation should be posted successfully
    And a success message should be displayed

  Scenario: Missing Title
    Given the user is logged into the Sweet System
    And the user is a beneficiary
    When the user provides a description "Delicious homemade orange cake with fudge frosting."
    And the user provides an image "Orange_cake.jpg"
    And the user submits the dessert creation
    Then the dessert creation should not be posted
    And an error message should be displayed indicating the title is required

  Scenario: Missing Description
    Given the user is logged into the Sweet System
    And the user is a beneficiary
    When the user provides a title "Orange Cake"
    And the user provides an image "Orange_cake.jpg"
    And the user submits the dessert creation
    Then the dessert creation should not be posted
    And an error message should be displayed indicating the description is required

  Scenario: Missing Image
    Given the user is logged into the Sweet System
    And the user is a beneficiary
    When the user provides a title "Orange Cake"
    And the user provides a description "Delicious homemade orange cake with fudge frosting."
    And the user submits the dessert creation
    Then the dessert creation should not be posted
    And an error message should be displayed indicating the image is required
    
    
    
    
    
    
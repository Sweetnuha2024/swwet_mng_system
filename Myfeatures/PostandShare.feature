Feature: Post and Share

Scenario: User posts content with description and image
Given the user "nuha" is logged in
When the user posts content with description "Delicious chocolate cake" and image "cake.jpg"
Then the post should be successfully created
And the post description should be "Delicious chocolate cake"
And the post image should be "cake.jpg"


Scenario: User tries to post content without description
Given the user "shahd" is logged in
When the user posts content with description "" and image "cake.jpg"
Then the post should fail with an error message "Description cannot be empty"



Scenario: User tries to post content without an image
Given the user "hala" is logged in
When the user posts content with description "Delicious chocolate cake" and image ""
Then the post should fail with an error message "Image cannot be empty"
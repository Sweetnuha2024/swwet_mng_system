Feature: Exploration and Purchase

Scenario: Browse and Search for Desserts
Given the user is signed in
When the user browses or searches for desserts
Then a list of matching desserts should be displayed with titles, descriptions, and images

Scenario: Filter Desserts by Dietary Needs
Given the user is signed in
When the user applies filters for dietary needs or food allergies
Then only desserts matching the filters should be displayed

Scenario: Purchase Desserts Directly from Store Owners
Given the user is signed in
When the user selects a dessert from a store owner
Then the purchase should be completed directly with the store owner
And the user should receive a confirmation and receipt

Feature: Order Management

Scenario: Process New Orders
Given the store owner or supplier is signed in and has new orders
When they process a new order with order ID "12345"
Then the order status should be updated to "Processed"
And a confirmation message should be displayed
Scenario: Track Order Status
Given the store owner or supplier is signed in
When they view the status of an order with order ID "12345"
Then the current status of the order should be displayed
And any relevant order details should be shown



Scenario: Update Order Status
Given the store owner or supplier is signed in and has an existing order
When they update the status of an order with order ID "12345" to "Shipped"
Then the order status should be updated successfully
And a confirmation message should be displayed

Feature: Validating the Mobile Purchase Functionality

Scenario: Purchase Mobile and Validate the Order ID
When Click the laptops category
And Click the first resulting laptop
And Click the Add to Cart
And Accept the Alert
And Click the cart Option in the Menu
And Click the place Order
And Entering the names in the name field as<name>
And Entering the number in the credit Card number field <cardnumber>
And Click on purchase button
Then Verify the purchase ID

Examples:
|name|cardnumber|
|Barani|12365478963257412|
|Santhosh|45698712365478965|


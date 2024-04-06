Feature: Validating the Mobile Purchase Functionality

Scenario: Purchase Mobile and Validate the Order ID

Given Launch the browser
And Load the Url
When Click the first resulting mobile
And Click the Add to Cart
And Accept the Alert 
And Click the cart Option in the Menu
And Click the place Order 
And Entering the names in the name field
And Entering the number in the credit Card number field
And Click on purchase button
Then Verify the purchase ID


@smoke
Scenario Outline: Purchase Mobile and Validate the Order ID with different set of data
When Click the first resulting mobile
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
|Ajith|12365478963257412|
|Venky|45698712365478965|

Feature: Search Functionality on Home Page

	Scenario: Verify User is able to validate cupon code
    Given User is on Home page
    Then Added below items to cart
    | Brocolli |
    | Capsicum |
    | Grapes |
    And Proceed to cart page
    When User is on Cart page
    Then Apply cupon code
    And Click on place order
    
 
    

    

 

        

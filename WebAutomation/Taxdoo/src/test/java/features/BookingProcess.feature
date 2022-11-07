Feature: Booking Process


   Background: accept cookies for the application
   Given User accept the cookies

    Scenario: Verify the Booking Process
        Given Select the average revenue as "1000"
        And   Select the "professional" package
        And   Select add the add-ons
        When  I click on next button
        Then  I am able to navigate to Personal screen
        When  I fill in the personal details
        And   I click on next button on Person page
        Then  I am able to navigate to confirmation screen
        When  I accept terms and condition
        And   I click on complete button
        Then  Verify the booking screen
        And   Verify the confirmation message
        
        Scenario: Verify the Personal Details section
         Given Select the average revenue as "10000"
         And   Select the "premium" package
         When  I click on next button
         Then  I am able to navigate to Personal screen
         When  I fill in the personal details
         And   I click on next button on Person page
         Then  I am able to navigate to confirmation screen
         And   Verify Personal Data section details
         
         
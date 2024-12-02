Feature: Add Policy

 Background: Steps common for all scenarios
Given User Launch Chrome browser
When User opens URL "https://priority.projectalphabet.ai/"
And Click on Login
And User enters Email as "monu@pcplusa.com"
And Click on Next
And User enters Password as "Welcome@5151"
And Click on Next2
Then Page Title should be "M&ANAGER"

Scenario: Add Policy for Admin
When User click on User Icon
And User select Setup option
When click on Roles
And User click on Add New Policy button
And select Role dropdown as "User"
And select Resource as "Deal"
And select Deal Name as "java"
And select Action as "Read"
And user click on Add Policy button
Then user can view msg as "Policy added successfully."
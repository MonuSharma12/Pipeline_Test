Feature: Login & Logout

Scenario: Successful Login with valid Credentials and Logout
Given User Launch Chrome browser
When User opens URL "https://priority.projectalphabet.ai/"
#When User opens URL "https://manager.projectalphabet.ai/"
And Click on Login
And User enters Email as "monu@pcplusa.com"
And Click on Next
And User enters Password as "Welcome@5151"
And Click on Next2
Then Page Title should be "M&ANAGER"
When User click on User Icon
And User select Logout option
And close browser
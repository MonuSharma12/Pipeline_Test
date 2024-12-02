@Order2
Feature: Chat

 Background: Steps common for all scenarios
Given User Launch Chrome browser
When User opens URL "https://priority.projectalphabet.ai/"
And Click on Login
And User enters Email as "monu@pcplusa.com"
And Click on Next
And User enters Password as "Welcome@5151"
And Click on Next2
Then Page Title should be "M&ANAGER"

Scenario: Chat Function
When User enters Question as "What is python Language"
And Click on Search button
And click on copy icon
And click on Like Icon
And click on DisLike Icon
And click on Regenerate Icon
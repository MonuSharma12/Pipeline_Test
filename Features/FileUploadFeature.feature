@Order1
Feature: Upload File

#Scenario: File Upload In Financial
 Background: Steps common for all scenarios
Given User Launch Chrome browser
When User opens URL "https://priority.projectalphabet.ai/"
And Click on Login
And User enters Email as "monu@pcplusa.com"
And Click on Next
And User enters Password as "Welcome@5151"
And Click on Next2
Then Page Title should be "M&ANAGER"

Scenario: File Upload In Financial
#When User click on AddDeal
#And User enters Deal Name as "MonuDeal2"
#And Click on Save
When User click on Dropdown button
And click on Financial Option
And click on Upload button
Then User can view confirmation message "File Analyzed Successfully."
And close browser

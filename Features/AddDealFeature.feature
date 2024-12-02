Feature: Add Deal

Background: Steps common for all scenarios
Given User Launch Chrome browser
When User opens URL "https://priority.projectalphabet.ai/"
And Click on Login
And User enters Email as "monu@pcplusa.com"
And Click on Next
And User enters Password as "Welcome@5151"
And Click on Next2
Then Page Title should be "M&ANAGER"

Scenario: Add M&A Deal Designer
When User click on M&A Deal Designer
And user select Choose deal side Radio button as "Sell Side"
And user select Nature of the Deal Radio button as "Acquisitions"
And User enters Deal Name as "MonuDeal3"
And user enters Name of the Company as "M&S Consulting"
And user select Industry Type dropdown as "Research"
And Click on Create
Then User can view add deal message "Deal Added Successfully"
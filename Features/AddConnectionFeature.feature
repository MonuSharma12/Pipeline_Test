
Feature: Add Connection

 Background: Steps common for all scenarios
Given User Launch Chrome browser
When User opens URL "https://priority.projectalphabet.ai/"
And Click on Login
And User enters Email as "monu@pcplusa.com"
And Click on Next
And User enters Password as "Welcome@5151"
And Click on Next2
Then Page Title should be "M&ANAGER"

Scenario: Data Source Connections
When User click on User Icon
And User select Setup option
When click on data
And click on Add button
And User enters Connection Name as "MonuSetup1"
And click on Select Deal dropdown
And click on Select Category dropdown
And click on Data Source dropdown
And click on checkbox
And User Click on Add
And User enters One Drive Email as "harrison.ford56@outlook.com"
And click on Drive Next button
And User enters One Drive Password as "Harrison@#01"
And click on Sign In
And user click on Decline button No
And User Select Folder
And click on Save Select Folders
Then User can view Add Connection Message as "OneDrive folders saved successfully!"
And click on close window button
And User Select Folder dropdown
And select Frequency dropdown
And select Data Type To Sync
And select Duplicate File Handling dropdown
And on Recursive Sync toggle button
And on Sync Notification toggle button
And on Error Notification toggle button
And user click on Save button
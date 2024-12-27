Feature: Validate Playlist API
Scenario: Verify if create playlist is working 
Given Create Playlist Api Playload
When User call with Post Http request
Then API call executed with status Code 201


Scenario: Verify if featch playlist functionality is working
Given get a playlist payload
When User call with GET http request
Then Api call executed Status Code 200

Scenario: Verify if update playlist functionality is working 
Given Update playlist api payload 
When User call with PUT http request 
Then API call should executes with Status code 200
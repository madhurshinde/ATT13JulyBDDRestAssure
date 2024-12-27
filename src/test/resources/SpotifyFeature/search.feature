Feature: Search Functionality
Scenario: Search a Song
Given Get a search track payload
| songname | track |
|O Maahi | track | 
When User call will GET request
Then API executes with Status code 200 
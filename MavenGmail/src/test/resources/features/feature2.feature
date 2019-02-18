Feature: Gmail Login
Background:
Given launch site
Scenario Outline: validate userid field
When enter userid like "<x>" value
And click userid next button
Then validate userid output for "<x>" with "<y>" criteria
When close site
Examples:
|      x            |   y      |
| manetisandeep94   | valid    |
|                   | invalid  |
| manetisandeep95   | invalid  |
Scenario Outline: validate password field
When enter userid like "manetisandeep94" value
And click userid next button
When enter password like "<x>" value
And click password next button
Then validate password output for "<x>" with "<y>" criteria
When close site
Examples:
|      x        |   y      |
| rajireddy94   | valid    |
|               | invalid  |
|    deepu      | invalid  |
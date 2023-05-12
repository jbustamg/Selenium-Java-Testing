Feature: [LM.016] Edit my registered details
    @regression
    @nationality
    @edition
    Scenario Outline:  LM.016.02 - Edit my registered details - Nationality Pre-Filled
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Nationality>"
        Then    I validate the fields is not empty
        Examples:
            |Nationality|user|MyData|
            |Nationality|99797|MyData|
    @regression
    @nationality
    @edition
    Scenario Outline:  LM.016.02 - Edit my registered details - Nationality - Select a country
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Nationality>"
        Then    I validate I am able to press the dropdown to select a "<country>"
        Examples:
            |country|Nationality|user|MyData|
            | Netherlands|Nationality|99797|MyData|
    @regression
    @nationality
    @edition
    Scenario Outline:   LM.016.02 - Edit my registered details - Nationality - Filter country
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Nationality>"
        Then    I validate I am able to press the dropdown to select a "<country>"
        Examples:
            |country|Nationality|user|MyData|
            | Netherlands|Nationality|99797|MyData|
    @regression
    @nationality
    @edition
    Scenario Outline:   LM.016.02 - Edit my registered details - Nationality -  Cancel behaviour
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Nationality>"
        Then    I validate I am able to press the dropdown to select a "<country>"
        And 	I validate I am able to press cancel
        And 	I validate the text fields the original "<value>"
        Examples:
            |country|value|Nationality|user|MyData|
            |Austria|Finland|Nationality|99797|MyData|
    @regression
    @nationality
    @edition
    Scenario Outline:   LM.016.02 - Edit my registered details - Nationality -  After Cancel field need to read-only mode
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<nationality>"
        Then    I validate I am able to press the dropdown to select a "<country>"
        And 	I validate I am able to press cancel
        And 	I validate the text fields the original "<value>"
        And     I validate "<nationality>" the field is not editable
        Examples:
            |country|value|nationality|user|MyData|
            |Austria|Finland|nationality|99797|MyData|
    @regression
    @nationality
    @edition
    Scenario Outline:   LM.016.02 - Edit my registered details - Nationality - Filter a country that is not there
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Nationality>"
        Then    I validate I am not able to press the dropdown to select a "<country>" doesn't exist
        Examples:
            |country|Nationality|user|MyData|
            |Chile|Nationality|99797|MyData|
    @regression
    @nationality
    @edition
    Scenario Outline:   LM.016.02 - Edit my registered details - Nationality  - Press X & Press Cancel
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Nationality>"
        Then    I validate I am able to press the dropdown to select a "<country>"
        And 	I validate I am able to press X
        And 	I validate I am able to press cancel
        And 	I validate the text fields the original "<value>"
        Examples:
            |country|value|Nationality|user|MyData|
            |Austria|Finland|Nationality|99797|MyData|
    @regression
    @nationality
    @edition
    Scenario Outline:   LM.016.02 - Edit my registered details - Nationality - Press X button
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Nationality>"
        Then    I validate I am able to press the dropdown to select a "<country>"
        And 	I validate I am able to press X
        And     I validate the fields is empty
        Examples:
            |country|Nationality|user|MyData|
            |Austria|Nationality|99797|MyData|
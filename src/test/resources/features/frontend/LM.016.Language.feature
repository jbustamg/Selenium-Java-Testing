Feature: [LM.016] Edit my registered details
    @regression
    @language
    @edition
    Scenario Outline:  LM.016.03 - Edit my registered details - Preferred Language - Select a Language
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<preferredLanguage>"
        Then    I validate I am able to press the dropdown to select a "<language>"
        Examples:
            |language|preferredLanguage|user|MyData|
            |French|preferredLanguage|99791 |MyData|
    @regression
    @language
    @edition
    Scenario Outline:  LM.016.03 - Edit my registered details - Preferred Language - Filter Language
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<preferredLanguage>"
        Then    I validate I am able to press the dropdown to select a "<language>"
        Examples:
            |language|preferredLanguage|user|MyData|
            |English|preferredLanguage|99791 |MyData|

    @regression
    @language
    @edition
    Scenario Outline:  LM.016.03 - Edit my registered details - Preferred Language - After Cancel field need to read-only
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<preferredLanguage>"
        Then    I validate I am able to press the dropdown to select a "<language>"
        Then    I validate I am able to press cancel
        And     I validate "<preferredLanguage>" the field is not editable
        Examples:
            |language|preferredLanguage|user|MyData|
            |French|preferredLanguage|99791 |MyData|
    @regression
    @language
    @edition
    Scenario Outline:  LM.016.03 - Edit my registered details - Preferred Language - Filter a language that is not there
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<preferredLanguage>"
        Then    I validate I am not able to press the dropdown to select a "<language>" doesn't exist

        Examples:
            |language|preferredLanguage|user|MyData|
            |Spanish|preferredLanguage|99791 |MyData|
    @regression
    @language
    @edition
    Scenario Outline:  LM.016.03 - Edit my registered details - Preferred Language - press X
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<preferredLanguage>"
        Then    I validate I am able to press the dropdown to select a "<language>"
        And     I validate I am able to press X

        Examples:
            |language|preferredLanguage|user|MyData|
            |French|preferredLanguage|99791 |MyData|
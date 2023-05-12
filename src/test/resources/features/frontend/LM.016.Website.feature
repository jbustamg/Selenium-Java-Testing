Feature: [LM.016] Edit my registered details
    @regression
    @website
    @edition
    Scenario Outline: LM.016.06 - Edit my registered details - Website - Cancel Behaviour
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<website>"
        Then    I add a "<website>"
        Then    I validate "<website>" the field is editable
        And     I validate I am able to press cancel
        And     I validate "<website>" the field is not editable
        Examples:
            | website |user|MyData|
            |website|99791 |MyData|
    @regression
    @website
    @edition
    Scenario Outline: LM.016.06 - Edit my registered details - Website  - After press edit
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<website>"
        Then    I add a "<website>"
        And     I validate "<website>" the field is editable
        Examples:
            | website |user|MyData|
            |website|99791 |MyData|
    @regression
    @website
    @edition
    Scenario Outline: LM.016.06 - Edit my registered details - Website - After press edit and add email
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<website>"
        Then    I add a "<website>"
        And     I validate "<website>" the field is editable
        Examples:
            | website |user|MyData|
            |website|99791 |MyData|
    @regression
    @website
    @edition
    Scenario Outline: LM.016.06 - Edit my registered details - Website - Empty  fields
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<website>"
        When    I add a "<website>"
        When     I empty the "<website>"
        When    I am able to select a date of change "<ASAP>"
        When     I press the submit button
        Then     I verify the field error has error
        Examples:
            | website |user|MyData|ASAP|
            |website|99791 |MyData|CURRENT|
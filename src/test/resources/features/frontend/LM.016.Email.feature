Feature: [LM.016] Edit my registered details
    @regression
    @email
    @edition
    Scenario Outline: LM.016.05 - Edit my registered details - Email - Empty  fields
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<email>"
        Then    I empty the "<email>"
        And     I add a "<email>"
        And     I am able to select a date of change "<ASAP>"
        And     I press the submit button
        And     I verify the field error has error
        Examples:
            | email|user|MyData|ASAP|
            |email|99791 |MyData|CURRENT|
    @regression
    @email
    @edition
    Scenario Outline: LM.016.05 - Edit my registered details - Email - Cancel Behaviour
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<email>"
        Then    I validate "<email>" the field is editable
        And     I validate I am able to press cancel
        And     I validate "<email>" the field is not editable
        Examples:
            | email|user|MyData|
            |email|99791 |MyData|
    @regression
    @email
    @edition
    Scenario Outline: LM.016.05 - Edit my registered details - Email  - After press edit
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<email>"
        And     I validate "<email>" the field is editable
        Examples:
            |email|user|MyData|
            |email|99791 |MyData|
    @regression
    @email
    @edition
    Scenario Outline: LM.016.05 - Edit my registered details - Email - After press edit and add email
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<email>"
        Then    I add a "<email>"
        And     I validate "<email>" the field is editable
        Examples:
            |email|user|MyData|
            |email|99791|MyData|
    @regression
    @email
    @edition
    Scenario Outline: LM.016.05 - Edit my registered details - Email - After press edit  and delete mail
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<email>"
        Then    I add a "<email>"
        And     I add a "<email>"
        And     I validate I am able to delete a "<email>"
        Examples:
            |email|user|MyData|
            |email|99791|MyData|
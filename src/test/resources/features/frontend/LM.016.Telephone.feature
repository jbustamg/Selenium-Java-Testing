Feature: [LM.016] Edit my registered details
    @regression
    @telephone
    @edition
    Scenario Outline: LM.016.07 - Edit my registered details - Telephone - After press edit
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<telephone>"
        Then    I add a "<telephone>"
        And     I validate "<telephone>" the field is editable
        Examples:
            |telephone|user|MyData|
            |telephone|99791|MyData|
    @regression
    @telephone
    @edition
    Scenario Outline: LM.016.07 - Edit my registered details - Telephone - After press edit and add phone
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<telephone>"
        Then    I add a "<telephone>"
        And     I validate "<telephone>" the field is editable
        Examples:
            |telephone|user|MyData|
            |telephone|99791|MyData|

    @regression
    @telephone
    @edition
    Scenario Outline: LM.016.07 - Edit my registered details - Telephone - Cancel Behaviour
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<telephone>"
        Then    I validate "<telephone>" the field is editable
        And     I validate I am able to press cancel
        And     I validate "<telephone>" the field is not editable
        Examples:
            |telephone|user|MyData|
            |telephone|99791|MyData|
    @regression
    @telephone
    @edition
    Scenario Outline:  LM.016.07 - Edit my registered details - Telephone - Empty fields
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<telephone>"
        Then    I add a "<telephone>"
        And     I am able to select a date of change "<ASAP>"
        And     I press the submit button
        And     I verify the field error has error
        Examples:
            |telephone|user|MyData|ASAP|
            |telephone|99791|MyData|CURRENT|
    @regression
    @telephone
    @edition
    Scenario Outline:  LM.016.07 - Edit my registered details - Telephone - Fill invalid phone number
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<telephone>"
        Then    I add a "<telephone>"
        And     I am fill the "<telephone>" with the "<number>" value
        And     I am able to select a date of change "<ASAP>"
        And     I press the submit button
        And     I verify the field error has error
        Examples:
            |telephone|number|user|MyData|ASAP|
            |telephone|56-12345-123456789|99791|MyData|CURRENT|
    @regression
    @telephone
    @edition
    Scenario Outline:  LM.016.07 - Edit my registered details - Telephone- After press edit  and delete phone
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<telephone>"
        Then    I add a "<telephone>"
        And     I add a "<telephone>"
        And     I validate I am able to delete a "<telephone>"
        Examples:
            |telephone|user|MyData|
            |telephone|99791|MyData|
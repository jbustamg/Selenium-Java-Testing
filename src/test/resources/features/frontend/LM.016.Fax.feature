Feature: [LM.016] Edit my registered details
    @regression
    @fax
    @edition
    Scenario Outline:  LM.016.07 - Edit my registered details - Fax - After press edit and add phone
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<fax>"
        Then    I add a "<fax>"
        And     I validate "<fax>" the field is editable
        Examples:
            |fax|user|MyData|
            |fax|99791|MyData|
    @regression
    @fax
    @edition
    Scenario Outline:  LM.016.08 - Edit my registered details - Fax - After press edit
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<fax>"
        Then    I add a "<fax>"
        And     I validate "<fax>" the field is editable
        Examples:
            |fax|user|MyData|
            |fax|99791|MyData|
    @regression
    @fax
    @edition
    Scenario Outline:  LM.016.08 - Edit my registered details - Fax - Empty fields
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<fax>"
        Then    I add a "<fax>"
        And     I am able to select a date of change "<ASAP>"
        And     I press the submit button
        And     I verify the field error has error
        Examples:
            |fax|user|MyData|ASAP|
            |fax|99791|MyData|CURRENT|
    @regression
    @fax
    @edition
    Scenario Outline:  LM.016.08 - Edit my registered details - Fax - Fill invalid phone number
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<fax>"
        Then    I add a "<fax>"
        And     I am fill the "<fax>" with the "<number>" value
        And     I am able to select a date of change "<ASAP>"
        And     I press the submit button
        And     I verify the field error has error
        Examples:
            |fax|number|user|MyData|ASAP|
            |fax|56-12345-123456789|99791|MyData|CURRENT|
    @regression
    @fax
    @edition
    Scenario Outline:  LM.016.07 - Edit my registered details - Telephone - Cancel Behaviour
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<fax>"
        Then    I validate "<fax>" the field is editable
        And     I validate I am able to press cancel
        And     I validate "<fax>" the field is not editable
        Examples:
            |fax|user|MyData|
            |fax|99791|MyData|
    @regression
    @fax
    @edition
    Scenario Outline:  LM.016.08 - Edit my registered details - After press edit  and delete phone
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<fax>"
        Then    I add a "<fax>"
        And     I add a "<fax>"
        And     I validate I am able to delete a "<fax>"
        Examples:
            |fax|user|MyData|
            |fax|99791|MyData|
Feature: [LM.016] Edit my registered details
    @regression
    @DataProtection
    @edition
    Scenario Outline:  LM.016.09 - Edit my registered details - Data Protection Settings - Cancel behavior
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<DataProtection>"
        Then    I validate I am able to press cancel
        Examples:
            |DataProtection|user|MyData|
            |DataProtection|99791|MyData|
    @regression
    @DataProtection
    @edition
    Scenario Outline:  LM.016.09 - Edit my registered details - Data Protection Settings - Flag is Editable
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When     I press edit "<DataProtection>"
        Then     I validate "<DataProtection>" the field is editable
        Examples:
            | DataProtection|user|MyData|
            |DataProtection|99791|MyData|
Feature: [LM.016] Edit my registered details
    @regression
    @name
    @edition
    Scenario Outline:   LM.016.01 - Edit my registered details - Name maximum length + Lastname length
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<name>"
        Then    I fill the "<firstname>" and the "<lastname>"
        And     I am able to select a date of change "<ASAP>"
        And     I press the submit button
        And     I verify the field error has error
        Examples:
            |name|firstname|lastname|user|MyData|ASAP|
            |name|qwertyuiopasdfghjklñzxcvbnmqweqwertyuiopasdfghj|qwertyuiopasdfghjklñzxcvbnmqweqwertyuiopasdfghj|99791|MyData|CURRENT|
    @regression
    @name
    @edition
    Scenario Outline:  LM.016.01 - Edit my registered details - Empty Name
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<name>"
        Then    I fill the "<firstname>" and the "<lastname>"
        And     I am able to select a date of change "<ASAP>"
        And     I press the submit button
        And     I verify the field error has error
        Examples:
            |name|firstname|lastname|user|MyData|ASAP|
            |name|    |        |99791 |MyData|CURRENT|
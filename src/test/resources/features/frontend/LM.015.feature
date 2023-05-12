Feature: LM.015.01 - View my registered details

    @regression
    Scenario Outline:   LM.015.01 - View my registered details - Without Protection Fields Displayed
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        Then    I validate "<field>" attribute exist have value
        Examples:
            |field|user|MyData|
            |REPNumber|99791|MyData|
            |DateOfEntry|99791|MyData|
            |Name|99791|MyData|
            |Address|99791|MyData|
            |Nationality|99791|MyData|
            |PreferredLanguage|99791|MyData|
    @regression
    Scenario Outline:   LM.015.01 - View my registered details - Protection Fields Displayed
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        Then    I validate "<field>" exist
        Examples:
            |field|user|MyData|
            |Telephone|99791|MyData|
            |Fax|99791|MyData|
            |Email|99791|MyData|
            |Website|99791|MyData|
    Scenario Outline:   [LM.015.01] View my registered details - Without Protection Fields Displayed
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        Then   I validate "<REPNumber>" attribute exist have value
        And    I validate "<DateOfEntry>" attribute exist have value
        And    I validate "<Name>" attribute exist have value
        And    I validate "<Address>" attribute exist have value
        And    I validate "<Nationality>" attribute exist have value
        And    I validate "<PreferredLanguage>" attribute exist have value
        And    I validate "<Telephone>" attribute exist have value
        And    I validate "<Fax>" attribute exist have value
        And    I validate "<Email>" attribute exist have value
        And    I validate "<Website>" attribute exist have value
        Examples:
            | REPNumber|DateOfEntry|Name|Address|Nationality|PreferredLanguage|Telephone|Fax|Email|Website|user|MyData|
            | REPNumber|DateOfEntry|Name|Address|Nationality|PreferredLanguage|Telephone|Fax|Email|Website|99791|MyData|
Feature: [LM.016] Edit my registered details
    @regression
    @PublicallyVisible
    @edition
    Scenario Outline:  LM.016.09 - Edit my registered details - Publically Visible - Cancel behavior
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<PublicallyVisible>"
        And     I validate I am able to press cancel
        Then    I validate the field is not check able
        Examples:
            |PublicallyVisible|user|MyData|
            |PublicallyVisible|99791|MyData|
    @regression
    @PublicallyVisible
    @edition
    Scenario Outline:  LM.016.09 - Edit my registered details - Publically Visible - Flag is editable
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<PublicallyVisible>"
        Then    I am fill the "<PublicallyVisible>" with the "<check>" value
        Examples:
            |PublicallyVisible|check|user|MyData|
            |PublicallyVisible|phone|99791|MyData|
            |PublicallyVisible|fax|99791|MyData|
            |PublicallyVisible|email|99791|MyData|
            |PublicallyVisible|webSite|99791|MyData|
            |PublicallyVisible|selectAllConsented|99791|MyData|
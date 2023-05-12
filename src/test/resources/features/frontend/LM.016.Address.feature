Feature: [LM.016] Edit my registered details
    @regression
    @address
    @edition
    Scenario Outline: LM.016.04 - Edit my registered details - Address  - Cancel Behaviour
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I press edit "<Address>"
        Then    I validate I am able to press cancel
        And     I validate "<field>" the field is not editable
        Examples:
            | Address | field |user|MyData|
            | Address |address\.addressLine1|99791|MyData|
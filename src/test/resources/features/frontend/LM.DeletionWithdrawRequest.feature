Feature: Deletion Withdraw Legal Representative
    @regression
    @E2E
    @withdraw
    Scenario Outline:  Deletion Legal Representative - Withdraw
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I click in delete
        When    I am able to select a date of deletion  "<ASAP>"
        When    I am able to check for understood the articles for my deletion
        When    I validate I am able to signed by "<name>"
        When    I press the Save and Review button
        When    I press Submit
        When    DG5 Administrative Employee is logged in to PWB
        When    I select a ticket in PWB for the "<frepid>"
        When    I claim the ticket PWB
        When    I found deficiencies on the changes with comment
        When    I confirm the approve of the changes
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I validate the link for download documents deficiencies appears
        When    I press in remedy deletion deficiency button
        Then    I am able to press withdraw for deletion
        Examples:
           |MyData|name|ASAP|frepid|user|
           |MyData|Test|CURRENT|9209750|99795|
    @regression
    @E2E
    @withdraw
    Scenario Outline:  Deletion Legal Representative - Withdraw
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I click in delete
        When    I am able to select a date of deletion  "<ASAP>"
        When    I am able to check for understood the articles for my deletion
        When    I validate I am able to edit my address
        When    I validate the dropdown "<country>" showed the "<countryState>" selected
        When    I validate I am able to signed by "<name>"
        When    I press the Save and Review button
        When    I press Submit
        When    DG5 Administrative Employee is logged in to PWB
        When    I select a ticket in PWB for the "<frepid>"
        When    I claim the ticket PWB
        When    I found deficiencies on the changes with comment
        When    I confirm the approve of the changes
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I validate the link for download documents deficiencies appears
        When    I press in remedy deletion deficiency button
        Then    I am able to press withdraw for deletion
        Examples:
            |MyData|name|ASAP|frepid|user|country|countryState|
            |MyData|Test|CURRENT|9209750|99795|nationality|Albanie|
    @regression
    @E2E
    Scenario Outline:  Deletion Legal Representative - Cancel the deletion
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I click in delete
        When    I am able to select a date of deletion  "<ASAP>"
        When    I am able to check for understood the articles for my deletion
        When    I validate I am able to signed by "<name>"
        When    I press the Save and Review button
        Then    I press the cancel request of deletion
        Examples:
            |MyData|name|ASAP|user|
            |MyData|Test|CURRENT|99795|
    @regression
    @edition
    Scenario Outline:  Deletion Legal Representative - Edition Signed
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I click in delete
        When    I validate I am able to signed by "<name>"
        Examples:
            |MyData|name|user|
            |MyData|Test|99795|
    @regression
    @edition
    Scenario Outline:  Deletion Legal Representative - Edition address
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I click in delete
        When    I validate I am able to edit my address
        Examples:
            |MyData|user|
            |MyData|99795|
    @regression
    @edition
    Scenario Outline:  Deletion Legal Representative - Edition country
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I click in delete
        When    I validate the dropdown "<country>" showed the "<countryState>" selected
        Examples:
            |MyData|user|country|countryState|
            |MyData|99795|nationality|Albanie|
    @regression
    @edition
    Scenario Outline:  Deletion Legal Representative - Edition effective date
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<MyData>"
        When    I click in delete
        When    I am able to select a date of deletion  "<ASAP>"
        Examples:
            |MyData|ASAP|user|
            |MyData|CURRENT|99795|
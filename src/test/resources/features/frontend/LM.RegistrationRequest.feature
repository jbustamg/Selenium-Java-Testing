Feature: Registration a Professional Representative

    @regression
    @registration
    Scenario Outline: Enter Registration Request Details - Edition of Section One Edition
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I fill the "<name>" and the "<lastname>"
        When    I select "<yes>" part of contracting state
        When    I validate the dropdown "<nationality>" showed the "<countryState>" selected
        When    I validate the dropdown "<language>" showed the "<French>" selected
        When    I validate I am able to edit my address
        When    I validate the dropdown "<country>" showed the "<countryState>" selected
        When    I validate I am able to check I passed the European qualifying examination
        Then    I validate I am able to signed by "<name>"
        Examples:
            | Registration |Section|name|lastname|user|yes|nationality|countryState|country|language|French|
            |Registration|Section 1|LYSANDER|SPOONER|99814 TCS test user 99814|Yes|nationality|Austria|country|language|French|
    @regression
    @registration
    Scenario Outline: Enter Registration Request Details - Edition of Section Two Edition
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        Then    I validate I am able to check to share my public information us "<check>"
        Examples:
            | Registration |Section|user|check|
            |Registration|Section 2|99814 TCS test user 99814|personal|
            |Registration|Section 2|99814 TCS test user 99814|postal|
    @regression
    @registration
    Scenario Outline: Enter Registration Request Details - Edition of Section Three Edition
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I filled the "<telephone>" with the value "<number>"
        When    I filled the "<fax>" with the value "<number>"
        When    I filled the "<website>" with the value "<page>"
        When    I filled the "<email>" with the value "<mail>"
        Then    I am fill the "<PublicallyVisible>" with the "<item>" value
        Examples:
            | Registration |Section|user|telephone|fax|number|website|page|email|mail|PublicallyVisible|item|
            |Registration|Section 3|99814 TCS test user 99814|telephone|fax|34-12345-123456789|website|www.google.com|email|test@test.com|PublicallyVisible|all|
    @regression
    @registration
    Scenario Outline: Enter Registration Request Details - Edition of Section Four Edition
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I validate I am able to write the "<year>" of European Qualifying Examination
        Examples:
            | Registration |Section|user|year|
            |Registration|Section 4|99814 TCS test user 99814|2022|
    @regression
    @registration
    Scenario Outline: Enter Registration Request Details - Edition of Section Five Edition
        Given   I log-in with an authorised "<user>" in NUA
        And     I download the document evidence
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I add evidence on the registration
        Examples:
            | Registration |Section|user|
            |Registration|Section 5|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: Enter Registration Request Details - I get to of Section Six
        Given   I log-in with an authorised "<user>" in NUA
        And     I download the document evidence
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        Examples:
            | Registration |Section|user|
            |Registration|Section 6|99814 TCS test user 99814|
    @regression
    @registration
    @E2E
    Scenario Outline: Registration of Professional Representative
    Given   I log-in with an authorised "<user>" in NUA
    And     I download the document evidence
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    When    DG5 Administrative Employee is logged in to PWB
    When    I select a ticket in PWB for the name "<name>"
    When    I claim the ticket PWB
    When    I approve the changes with comment
    Then    I confirm the approve of the changes
        Examples:
            | Registration |Section|user|name|
            |Registration|Section Done|99814 TCS test user 99814|LYSANDER SPOONER|
    @regression
    @registration
    Scenario Outline:  LM.002.03 - Enter Registration Request Details - Nationality - Select a country
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<name>"
        When    I go to "<Section>"
        When    I select "<value>" part of contracting state
        Then    I validate I am able to press the dropdown to select a "<country>"
        Examples:
            | name |value|country|user|Section|
            |Registration|Yes|Austria|99814 TCS test user 99814|Section 1|
    @regression
    @registration
    Scenario Outline:  LM.002.03 - Enter Registration Request Details - Nationality - For Non EPC
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<name>"
        When    I go to "<Section>"
        When    I select "<value>" part of contracting state
        Then    I validate I am able to press the dropdown to select a "<country>"
        Examples:
            | name |value|country|user|Section|
            |Registration|No|Algeria|99814 TCS test user 99814|Section 1|
    @regression
    @registration
    Scenario Outline:  LM.002.03 - Enter Registration Request Details - Nationality - Select a country showed
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<name>"
        When    I go to "<Section>"
        When    I select "<value>" part of contracting state
        Then    I validate the dropdown "<nationality>" showed the "<country>" selected
        Examples:
            | name |value|country|nationality|user|Section|
            |Registration|Yes|Austria|nationality|99814 TCS test user 99814|Section 1|
    @regression
    @registration
    Scenario Outline:  LM.002.03 - Enter Registration Request Details - For Non EPC  showed
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<name>"
        When    I go to "<Section>"
        When    I select "<value>" part of contracting state
        Then    I validate the dropdown "<nationality>" showed the "<country>" selected
        Examples:
            | name |value|country|nationality|user|Section|
            |Registration|No|Algeria|nationality|99814 TCS test user 99814|Section 1|
    @regression
    @registration
    Scenario Outline: LM.002.07 - Enter Registration Request Details - Website - Fill field
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        Then    I filled the "<website>" with the value "<page>"
        And     I validate the "<website>" is showed
        Examples:
            | Registration |Section|website|page|user|
            |Registration|Section 3|website|www.google.com|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.07 - Enter Registration Request Details - Website - Fill invalid website
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I filled the "<website>" with the value "<page>"
        When    I press the next button
        And     I verify the field error has error
        Examples:
            | Registration |Section|website|page|user|
            |Registration|Section 3|website|google|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.07 - Enter Registration Request Details - Website - Empty fields
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I filled the "<website>" with the value "<page>"
        When    I press the next button
        And     I verify the field error has error
        Examples:
            | Registration |Section|website|page|user|
            |Registration|Section 3|website| |99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.08 - Enter Registration Request Details  - Telephone - Fill invalid the phone number
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I filled the "<telephone>" with the value "<number>"
        When    I press the next button
        And     I verify the field error has error
        Examples:
            | Registration |Section|telephone|number|user|
            |Registration|Section 3|telephone|56-12345-123456789|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.08 - Enter Registration Request Details - Telephone - Fill the phone number
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I filled the "<telephone>" with the value "<number>"
        Then    I press the next button
        Examples:
            | Registration |Section|telephone|number|user|
            |Registration|Section 3|telephone|34-12345-123456789|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.02 - Enter Registration Request Details - Name minimum values
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        Then    I fill the "<name>" and the "<lastname>"
        And     I validate the "<name>" is showed
        And     I validate the "<lastname>" is showed
        Examples:
            | Registration |Section|name|lastname|user|
            |Registration|Section 1|n|l|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname equal length 48
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        Then    I fill the "<name>" and the "<lastname>"
        And     I validate the "<name>" is showed
        And     I validate the "<lastname>" is showed
        Examples:
            | Registration |Section|name|lastname|user|
            |Registration|Section 1|Namewithtwetycharacters|Namewithtwetycharacterso|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname between 2<48
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        Then    I fill the "<name>" and the "<lastname>"
        And     I validate the "<name>" is showed
        And     I validate the "<lastname>" is showed
        Examples:
            | Registration |Section|name|lastname|user|
            |Registration|Section 1|Test|Test|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname over 48 length
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        Then    I fill the "<name>" and the "<lastname>"
        And     I validate the "<name>" is showed
        And     I validate the "<lastname>" is showed
        Examples:
            | Registration |Section|name|lastname|user|
            |Registration|Section 1|Namewithtwetycharacterso|Namewithtwetycharacters|99814 TCS test user 99814|
    @regression
    @registration
    Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname below 2 length
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I fill the "<name>" and the "<lastname>"
        Then    I press the next button
        And     I verify the field error has error
        Examples:
            | Registration |Section|name|lastname|user|
            |Registration|Section 1|T||99814 TCS test user 99814|
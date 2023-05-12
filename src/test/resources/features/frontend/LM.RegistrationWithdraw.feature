Feature: Registration Withdraw a Professional Representative

    @regression
    @registrationwithdraw
    @E2E
    Scenario Outline: Registration Withdraw of Professional Representative
        Given   I log-in with an authorised "<user>" in NUA
        And     I download the document evidence
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    DG5 Administrative Employee is logged in to PWB
        When    I select a ticket in PWB for the name "<name>"
        When    I claim the ticket PWB
        When    I found deficiencies on the changes with comment
        When    I confirm the approve of the changes
        When    I navigate to the desired NUA menu section "<Registration>"
        Then    I validate the link for download appears
        And     I am able to press withdraw for Registration
        Examples:
            |Registration|Section|user|name|
            |Registration|Section Done|99814 TCS test user 99814|LYSANDER SPOONER|
    @regression
    @registrationwithdraw
    @E2E
    Scenario Outline: Registration Withdraw of Professional Representative checking all fields
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
        When    I validate I am able to signed by "<name>"
        When    I press the next button
        When    I validate I am able to check to share my public information us "<check>"
        When    I press the next button
        When    I filled the "<telephone>" with the value "<number>"
        When    I filled the "<fax>" with the value "<number>"
        When    I filled the "<website>" with the value "<page>"
        When    I filled the "<email>" with the value "<mail>"
        When    I am fill the "<PublicallyVisible>" with the "<item>" value
        When    I press the next button
        When    I validate I am able to write the "<year>" of European Qualifying Examination
        When    I press the next button
        When    I download the document
        When    I add evidence on the registration
        When    I press the next button
        When    I press the next button
        When    I select a ticket in PWB for the name "<fullname>"
        When    I claim the ticket PWB
        When    I found deficiencies on the changes with comment
        When    I confirm the approve of the changes
        When    I navigate to the desired NUA menu section "<Registration>"
        Then    I validate the link for download appears
        And     I am able to press withdraw for Registration
       
        Examples:
            | Registration |Section|user|year|yes|nationality|countryState|country|language|French|name|lastname|fullname|check|telephone|fax|number|website|page|email|mail|PublicallyVisible|item|
            |Registration|Section 1|99814 TCS test user 99814|2022|Yes|nationality|Austria|country|language|French|LYSANDER|SPOONER|LYSANDER SPOONER|personal|telephone|fax|34-12345-123456789|website|www.google.com|email|test@test.com|PublicallyVisible|all|
    @regression
    @registrationwithdraw
    @E2E
    Scenario Outline: Registration Withdraw of Professional Representative starting from section 2
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I validate I am able to check to share my public information us "<check>"
        When    I press the next button
        When    I filled the "<telephone>" with the value "<number>"
        When    I filled the "<fax>" with the value "<number>"
        When    I filled the "<website>" with the value "<page>"
        When    I filled the "<email>" with the value "<mail>"
        When    I am fill the "<PublicallyVisible>" with the "<item>" value
        When    I press the next button
        When    I validate I am able to write the "<year>" of European Qualifying Examination
        When    I press the next button
        When    I download the document
        When    I add evidence on the registration
        When    I press the next button
        When    I press the next button
        When    I select a ticket in PWB for the name "<name>"
        When    I claim the ticket PWB
        When    I found deficiencies on the changes with comment
        When    I confirm the approve of the changes
        When    I navigate to the desired NUA menu section "<Registration>"
        Then    I validate the link for download appears
        And     I am able to press withdraw for Registration

        Examples:
            | Registration |Section|user|year|name|check|telephone|fax|number|website|page|email|mail|PublicallyVisible|item|
            |Registration|Section 2|99814 TCS test user 99814|2022|LYSANDER SPOONER|personal|telephone|fax|34-12345-123456789|website|www.google.com|email|test@test.com|PublicallyVisible|all|
    @regression
    @registrationwithdraw
    @E2E
    Scenario Outline: Registration Withdraw of Professional Representative not checking to share public information
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I filled the "<telephone>" with the value "<number>"
        When    I filled the "<fax>" with the value "<number>"
        When    I filled the "<website>" with the value "<page>"
        When    I filled the "<email>" with the value "<mail>"
        When    I am fill the "<PublicallyVisible>" with the "<item>" value
        When    I press the next button
        When    I validate I am able to write the "<year>" of European Qualifying Examination
        When    I press the next button
        When    I download the document
        When    I add evidence on the registration
        When    I press the next button
        When    I press the next button
        When    I select a ticket in PWB for the name "<name>"
        When    I claim the ticket PWB
        When    I found deficiencies on the changes with comment
        When    I confirm the approve of the changes
        When    I navigate to the desired NUA menu section "<Registration>"
        Then    I validate the link for download appears
        And     I am able to press withdraw for Registration

        Examples:
            | Registration |Section|user|year|name|telephone|fax|number|website|page|email|mail|PublicallyVisible|item|
            |Registration|Section 3|99814 TCS test user 99814|2022|LYSANDER SPOONER|telephone|fax|34-12345-123456789|website|www.google.com|email|test@test.com|PublicallyVisible|all|
    @regression
    @registrationwithdraw
    @E2E
    Scenario Outline: Registration Withdraw of Professional Representative not adding phone fax or selecting public visibility
        Given   I log-in with an authorised "<user>" in NUA
        When    I navigate to the desired NUA menu section "<Registration>"
        When    I go to "<Section>"
        When    I validate I am able to write the "<year>" of European Qualifying Examination
        When    I press the next button
        When    I download the document
        When    I add evidence on the registration
        When    I press the next button
        When    I press the next button
        When    I select a ticket in PWB for the name "<name>"
        When    I claim the ticket PWB
        When    I found deficiencies on the changes with comment
        When    I confirm the approve of the changes
        When    I navigate to the desired NUA menu section "<Registration>"
        Then    I validate the link for download appears
        And     I am able to press withdraw for Registration

        Examples:
            | Registration |Section|user|year|name|
            |Registration|Section 4|99814 TCS test user 99814|2022|LYSANDER SPOONER|
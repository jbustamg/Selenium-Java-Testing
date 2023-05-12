Feature: Registered Professional Representative Edition
  @regression
  @name
  @E2E
  Scenario Outline:  Edit my registered name and get approved for DG5 Administrative
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<name>"
    When    I fill the "<firstname>" and the "<lastname>" with evidence
    When    I am able to select a date of change "<ASAP>"
    When    I press the submit button
    When    DG5 Administrative Employee is logged in to PWB
    When    I select a ticket in PWB for the "<frepid>"
    When    I claim the ticket PWB
    When    I am able to edit the the changes
    When    I am able to see all the representative data
    When    I approve the changes with comment
    Then    I confirm the approve of the changes
    Examples:
      |MyData|name|firstname|lastname|frepid|user|ASAP|
      |MyData|name|Maria Zenarosa|Nichol|9264740|99819 TCS test user 99819|CURRENT|
  @regression
  @nationality
  @E2E
  Scenario Outline:  Edit my registered nationality and get approved for DG5 Administrative
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<nationality>"
    When    I validate I am able to press the dropdown to select a "<country>" with evidence
    When     I am able to select a date of change "<ASAP>"
    When    I press the submit button
    When    DG5 Administrative Employee is logged in to PWB
    When    I select a ticket in PWB for the "<frepid>"
    When    I claim the ticket PWB
    When    I am able to edit the the changes
    When    I am able to see all the representative data
    When    I approve the changes with comment
    Then    I confirm the approve of the changes
    Examples:
      | MyData | nationality | country |frepid|user|ASAP|
      | MyData | nationality | United Kingdom | 9264740 |99819 TCS test user 99819|CURRENT|
  @regression
  @address
  @E2E
  Scenario Outline:  Edit my registered address and get approved for DG5 Administrative
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<address>"
    When    I validate I am able to edit my address
    When     I am able to select a date of change "<ASAP>"
    When    I press the submit button
    When    DG5 Administrative Employee is logged in to PWB
    When    I select a ticket in PWB for the "<frepid>"
    When    I claim the ticket PWB
    When    I am able to edit the the changes
    When    I am able to see all the representative data
    When    I approve the changes with comment
    Then    I confirm the approve of the changes
    Examples:
      |MyData|address|frepid|user|ASAP|
      |MyData|address|9264740|99819 TCS test user 99819|CURRENT|
  @preferredLanguage
  @E2E
  Scenario Outline: Edit my registered details - Preferred Language
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<preferredLanguage>"
    When     I am able to select a date of change "<ASAP>"
    When    I validate I am able to press the dropdown to select a "<French>"
    Then    I press the submit button
    Examples:
      |MyData|preferredLanguage|French|user|ASAP|
      |MyData|preferredLanguage|French|99819 TCS test user 99819|CURRENT|
      |MyData|preferredLanguage|English|99819 TCS test user 99819|CURRENT|
  @website
  Scenario Outline: Edit my registered details - Website
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<website>"
    Then    I am fill the "<website>" with the "<page>" value
    And     I am able to select a date of change "<ASAP>"
    And    I press the submit button
    Examples:
      |MyData|website|user|page|ASAP|
      |MyData|website|99819 TCS test user 99819|http://www.epo.org|CURRENT|
      |MyData|website|99819 TCS test user 99819|http://www.google.com|CURRENT|
  @mail
  Scenario Outline: Edit my registered details - Mail
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<email>"
    Then    I am fill the "<email>" with the "<mail>" value
    And     I am able to select a date of change "<ASAP>"
    And    I press the submit button
    Examples:
      |MyData|email|user|mail|ASAP|
      |MyData|email|99819 TCS test user 99819|test@test.com|CURRENT|
      |MyData|email|99819 TCS test user 99819|test@dg5.com|CURRENT|
  @telephone
  Scenario Outline: Edit my registered details - Telephone
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<telephone>"
    Then    I am fill the "<telephone>" with the "<phone>" value
    And     I am able to select a date of change "<ASAP>"
    And     I press the submit button
    Examples:
      |MyData|telephone|user|phone|ASAP|
      |MyData|telephone|99819 TCS test user 99819|31-12345-1234567|CURRENT|
      |MyData|telephone|99819 TCS test user 99819|33-123-123456789|CURRENT|
  @fax
  Scenario Outline: Edit my registered details - Fax
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<fax>"
    Then    I am fill the "<fax>" with the "<phone>" value
    And     I am able to select a date of change "<ASAP>"
    And     I press the submit button
    Examples:
      |MyData|fax|user|phone|ASAP|
      |MyData|fax|99819 TCS test user 99819|31-12345-1234567|CURRENT|
      |MyData|fax|99819 TCS test user 99819|33-123-123456789|CURRENT|
  @DataProtection
  @E2E
  Scenario Outline: Edit my registered details - Data Protection
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<DataProtection>"
    Then    I am fill the "<DataProtection>" with the "<check>" value
    And     I am able to select a date of change "<ASAP>"
    And     I press the submit button
    Examples:
      |MyData|DataProtection|user|check|ASAP|
      |MyData|DataProtection|99819 TCS test user 99819|withdraw|CURRENT|
      |MyData|DataProtection|99819 TCS test user 99819|object|CURRENT|
  @PublicallyVisible
  @E2E
  Scenario Outline: Edit my registered details - Data Protection
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<PublicallyVisible>"
    Then    I am fill the "<PublicallyVisible>" with the "<item>" value
    And     I am able to select a date of change "<ASAP>"
    And     I press the submit button
    Examples:
      |MyData|PublicallyVisible|user|item|ASAP|
      |MyData|PublicallyVisible|99819 TCS test user 99819|selectAllConsented|CURRENT|
      |MyData|PublicallyVisible|99819 TCS test user 99819|phone|CURRENT|
      |MyData|PublicallyVisible|99819 TCS test user 99819|fax|CURRENT|
      |MyData|PublicallyVisible|99819 TCS test user 99819|email|CURRENT|
      |MyData|PublicallyVisible|99819 TCS test user 99819|webSite|CURRENT|
  @regression
  @E2E
  Scenario Outline:  Edit my registered for value restored
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When    I press edit "<name>"
    When    I fill the "<firstname>" and the "<lastname>" with evidence
    When    I press edit "<address>"
    When    I validate I am able to edit my address
    When    I press edit "<preferredLanguage>"
    When    I validate I am able to press the dropdown to select a "<French>"
    When    I press edit "<telephone>"
    When    I am fill the "<telephone>" with the "<phone>" value
    When    I press edit "<fax>"
    When    I am fill the "<fax>" with the "<phone>" value
    When    I press edit "<email>"
    When    I am fill the "<email>" with the "<mail>" value
    When    I press edit "<website>"
    When    I am fill the "<website>" with the "<page>" value
    When     I am able to select a date of change "<ASAP>"
    When    I press the submit button
    When    DG5 Administrative Employee is logged in to PWB
    When    I select a ticket in PWB for the "<frepid>"
    When    I claim the ticket PWB
    When    I am able to edit the the changes
    When    I am able to see all the representative data
    When    I approve the changes with comment
    Then    I confirm the approve of the changes
    Examples:
      |MyData|name|firstname|lastname|frepid|user|fax|telephone|phone|email|website|mail|page|address|preferredLanguage|French|ASAP|
      |MyData|name|Maria Zenarosa|Nichol|9264740|99819 TCS test user 99819|fax|telephone|34-12345-123456788|email|website|dg5@dg5.com|http://www.gmail.com|address|preferredLanguage|French|CURRENT|
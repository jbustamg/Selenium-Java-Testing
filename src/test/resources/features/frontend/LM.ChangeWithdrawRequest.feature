Feature: Edition Withdraw Professional Representative Information

  @regression
  @E2E
  @withdraw
  @test
  Scenario Outline:  DG5 - Withdraw after edit all the values
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
    When    I found deficiencies on the changes with comment
    When    I confirm the approve of the changes
    When    I navigate to the desired NUA menu section "<MyData>"
    Then    I validate the link for download appears
    And     I am able to press withdraw
    Examples:
      |MyData|name|firstname|lastname|frepid|user|fax|telephone|phone|email|website|mail|page|address|preferredLanguage|French|ASAP|
      |MyData|name|Test|Test|9222390|99791|fax|telephone|34-12345-123456788|email|website|test@test.com|http://www.test.com|address|preferredLanguage|French|CURRENT|
  @regression
  @name
  @E2E
  @withdraw
  Scenario Outline:  DG5 - Withdraw after edit name
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
    When    I found deficiencies on the changes with comment
    When    I confirm the approve of the changes
    When    I navigate to the desired NUA menu section "<MyData>"
    Then    I validate the link for download appears
    And     I am able to press withdraw
    Examples:
      |MyData|name|firstname|lastname|frepid|user|ASAP|
      |MyData|name|Test|Test|9222390|99791|CURRENT|
  @regression
  @nationality
  @E2E
  @withdraw
  Scenario Outline:  DG5 - Withdraw after edit nationality
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
    When    I found deficiencies on the changes with comment
    When    I confirm the approve of the changes
    When    I navigate to the desired NUA menu section "<MyData>"
    Then    I validate the link for download appears
    And     I am able to press withdraw
    Examples:
      | MyData|nationality|country|frepid|user|ASAP|
      | MyData|nationality|United Kingdom|9222390|99791|CURRENT|

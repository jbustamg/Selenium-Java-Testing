Feature: [LM.002] Enter Registration Request Details

  Scenario Outline:  LM.002.03 - Enter Registration Request Details - Nationality - Select a country
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<name>"
    When    I go to "<Section>"
    When    I select "<value>" part of contracting state
    Then    I validate I am able to press the dropdown to select a "<country>"
    Examples:
      | name |value|country|user|Section|
      |Registration|Yes|Austria|99778|Section 1|
  
  
  Scenario Outline:  LM.002.03 - Enter Registration Request Details - Nationality - For Non EPC
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<name>"
    When    I go to "<Section>"
    When    I select "<value>" part of contracting state
    Then    I validate I am able to press the dropdown to select a "<country>"
    Examples:
      | name |value|country|user|Section|
      |Registration|No|Algeria|99798|Section 1|
  
  
  Scenario Outline:  LM.002.03 - Enter Registration Request Details - Nationality - Select a country showed
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<name>"
    When    I go to "<Section>"
    When    I select "<value>" part of contracting state
    Then    I validate the dropdown "<nationality>" showed the "<country>" selected
    Examples:
      | name |value|country|nationality|user|Section|
      |Registration|Yes|Austria|nationality|99798|Section 1|
  
  
  Scenario Outline:  LM.002.03 - Enter Registration Request Details - For Non EPC  showed
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<name>"
    When    I go to "<Section>"
    When    I select "<value>" part of contracting state
    Then    I validate the dropdown "<nationality>" showed the "<country>" selected
    Examples:
      | name |value|country|nationality|user|Section|
      |Registration|No|Algeria|nationality|99798|Section 1|
  Scenario Outline:  LM.002.03 -  Enter Registration Request Details - Not select a country
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I select "<yes>" part of contracting state
    Then    I verify I received an error message when I am not set my nationality
    Examples:
      | Registration |yes|user|
      |Registration|Yes|99798|
  
  
    Scenario Outline: LM.002.07 - Enter Registration Request Details - Website - Fill field
      Given   I log-in with an authorised "<user>" in NUA
      When    I navigate to the desired NUA menu section "<Registration>"
      When    I go to "<Section>"
      Then    I filled the "<website>" with the value "<page>"
      And     I validate the "<website>" is showed
    Examples:
      | Registration |Section|website|page|user|
      |Registration|Section 3|website|www.google.com|99798|
  
  
  Scenario Outline: LM.002.07 - Enter Registration Request Details - Website - Fill invalid website
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    When    I filled the "<website>" with the value "<page>"
    When    I press the next button
    And     I verify the field error has error
    Examples:
      | Registration |Section|website|page|user|
      |Registration|Section 3|website|google|99798|
  
  
  Scenario Outline: LM.002.07 - Enter Registration Request Details - Website - Empty fields
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    When    I filled the "<website>" with the value "<page>"
    When    I press the next button
    And     I verify the field error has error
    Examples:
      | Registration |Section|website|page|user|
      |Registration|Section 3|website| |99798|
  
  
  Scenario Outline: LM.002.08 - Enter Registration Request Details  - Telephone - Fill invalid the phone number
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    When    I filled the "<telephone>" with the value "<number>"
    When    I press the next button
    And     I verify the field error has error
    Examples:
      | Registration |Section|telephone|number|user|
      |Registration|Section 3|telephone|56-12345-123456789|99798|
  
  
  Scenario Outline: LM.002.08 - Enter Registration Request Details - Telephone - Fill the phone number
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    When    I filled the "<telephone>" with the value "<number>"
    Then    I press the next button
    Examples:
      | Registration |Section|telephone|number|user|
      |Registration|Section 3|telephone|34-12345-123456789|99798|
  
  
  Scenario Outline: LM.002.02 - Enter Registration Request Details - Name minimum values
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    Then    I fill the "<name>" and the "<lastname>"
    And     I validate the "<name>" is showed
    And     I validate the "<lastname>" is showed
    Examples:
      | Registration |Section|name|lastname|user|
      |Registration|Section 1|n|l|99798|
  
  
  Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname equal length 48
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    Then    I fill the "<name>" and the "<lastname>"
    And     I validate the "<name>" is showed
    And     I validate the "<lastname>" is showed
    Examples:
      | Registration |Section|name|lastname|user|
      |Registration|Section 1|Namewithtwetycharacters|Namewithtwetycharacterso|99798|
  
  
  Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname between 2<48
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    Then    I fill the "<name>" and the "<lastname>"
    And     I validate the "<name>" is showed
    And     I validate the "<lastname>" is showed
    Examples:
      | Registration |Section|name|lastname|user|
      |Registration|Section 1|Test|Test|99798|
  
  
  Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname over 48 length
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    Then    I fill the "<name>" and the "<lastname>"
    And     I validate the "<name>" is showed
    And     I validate the "<lastname>" is showed
    Examples:
      | Registration |Section|name|lastname|user|
      |Registration|Section 1|Namewithtwetycharacterso|Namewithtwetycharacters|99798|
  
  
  Scenario Outline: LM.002.02 - Enter Registration Request Details - Name + Lastname below 2 length
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<Registration>"
    When    I go to "<Section>"
    When    I fill the "<name>" and the "<lastname>"
    Then    I press the next button
    And     I verify the field error has error
    Examples:
      | Registration |Section|name|lastname|user|
      |Registration|Section 1|T||99798|
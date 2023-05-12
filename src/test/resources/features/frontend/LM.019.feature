Feature: [LM.019] Provide Requested Evidence
  Background:
    Given   I log-in with an authorised user in NUA
    When    I navigate to the desired NUA menu section MyData
  Scenario Outline:   WP.LM.019 - Sign and Submit Change Request - Document Download Link
    Then    I validate the link for download appears
    Examples:
      |name|lastname|
      |name|lastname|
  Scenario Outline:   LM.019 - Sign and Submit Change Request - Document Download
    Then    I validate the link for download appears
    And     I download the document
    Examples:
      |name|lastname|
      |name|lastname|


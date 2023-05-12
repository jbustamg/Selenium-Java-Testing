Feature: LM.018 - Provide Requested Evidence
  @regression
  @upload
  Scenario Outline:  LM.018 - Provide Requested Evidence - Upload evidence
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    Then 	I upload a evidence file for "<field>"
    Examples:
      |field|user|MyData|
      |name|99791|MyData|
      |nationality|99791|MyData|

  @regression
  @upload
  Scenario Outline:   LM.018 - Provide Requested Evidence -  Upload evidence and Deleting
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    Then 	I upload a evidence file for "<field>"
    And     I verify I am able to delete the uploaded evidence file
    Examples:
      |field|user|MyData|
      |name|99791|MyData|
      |nationality|99791|MyData|
  @regression
  @upload
  Scenario Outline:   LM.018 - Provide Requested Evidence -  Upload evidence & Submit
    Given   I log-in with an authorised "<user>" in NUA
    When    I navigate to the desired NUA menu section "<MyData>"
    When 	I upload a evidence file for "<field>"
    When    I fill the "<name>" and the "<lastname>"
    When     I am able to select a date of change "<ASAP>"
    When     I press the submit button
    Then     I verify the field error has error
    Examples:
      | field |name|lastname|user|MyData|ASAP|
      |name|       |        |99791|MyData|CURRENT|

Feature: [LM.025] List Pending RepList Change Actions

  Scenario Outline:  LM.025 - List Pending RepList Change Actions
    Given   DG5 Administrative Employee is logged in to PWB
    When    I select a ticket in PWB for the "<frepid>"
    When    I claim the ticket PWB
    When    I approve the changes with comment
    Then    I confirm the approve of the changes
    Examples:
      |frepid|
      |9209070|

  Scenario:  LM.025 - List Pending RepList Change Actions
    Given   DG5 Administrative Employee is logged in to PWB
    When    I am able to edit the the changes
    When    I am able to see all the representative data

  Scenario:  LM.025 - List Pending RepList Change Actions
    Given   DG5 Administrative Employee is logged in to PWB
    When    I am able to see all the representative data


  Scenario:  LM.025 - List Pending RepList Change Actions
    Given   DG5 Administrative Employee is logged in to PWB
    When    I approve the changes with comment
    Then    I confirm the approve of the changes


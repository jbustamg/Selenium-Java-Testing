Feature: I get tokens to get access to the services

  Scenario Outline: I get tokens to connect to the services
    Given An epo user and password
    When  I get the token from NUA "<representativeId>"
    Then  I get the response of the legal representative
    Examples:
      | representativeId|
      | 99819|
  Scenario Outline: I get tokens to connect to the services
    Given An epo user and password
    When  I get the token from NUA "<representativeId>"
    Then  I check I am able to change the "<payloads>"
    Examples:
      | representativeId |payloads|
      | 99819|valid-name|
      | 99819|valid-nationality|
      | 99819|valid-language|
      | 99819|valid-fax|
      | 99819|valid-phone|
  Scenario Outline: I check iam able to make changes by request
    Given An epo user and password
    When  I get the token from NUA "<representativeId>"
    Then  I check I am able to change the "<payloads>"
    Examples:
      | representativeId |payloads|
      | 99819|valid-name|
  @regression
  Scenario Outline: I check the validation of the fields with invalid request
    Given An epo user and password
    When  I get the token from NUA "<representativeId>"
    Then  I check I am able to check the elements don't change the "<payloads>"
    Examples:
      | representativeId |payloads|
      | 99791|telephone|
      | 99791|fax|
      | 99791|name|
      | 99791|firstname|
      | 99791|nationality|
      | 99791|preferredLanguage|
      | 99791|addressOne|
      | 99791|addressTwo|
      | 99791|addressThree|
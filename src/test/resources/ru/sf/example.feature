#Gherkin
Feature: Find goods
  #Позитивный сценарий: вводим в поисковую строку наименование товара и находим его
  Scenario: find good
    Given url 'https://www.21vek.by/'
    Then accept all cookies
    Then  start search 'Мобильный телефон Philips Xenium E111 (черный)'
    And assert that chosen good is 'Мобильный телефон Philips Xenium E111 (черный)'
  #Негатинвый сценарий: вход в личный кабинет с невалидными данными
  Scenario: login to account with invalid data
    Given url 'https://www.21vek.by/'
    Then accept all cookies
    Then input the wong e-mail '123456'
    And assert that user got message 'Неправильный формат электронной почты'
    Then close browser

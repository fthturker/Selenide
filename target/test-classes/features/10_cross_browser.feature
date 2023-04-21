@tumu
Feature: cross browser
  @headless
  Scenario: TC01 headless
    Given kullanici browser tipini "headless" olarak secer
    Given kullanici "https://www.amazon.com" adresine gider
    Then tum ekran goruntusu alir

  @firefox
  Scenario: TC02 firefox
    Given kullanici browser tipini "firefox" olarak secer
    Given kullanici "https://www.amazon.com" adresine gider
    Then tum ekran goruntusu alir

  @edge
  Scenario: TC03 edge
    Given kullanici browser tipini "edge" olarak secer
    Given kullanici "https://www.amazon.com" adresine gider
    Then tum ekran goruntusu alir
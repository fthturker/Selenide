Feature: screenshots
  @tumekrangoruntusu
  Scenario: tum ekran goruntusu
    Given kullanici "https://www.amazon.com/" adresine gider
    And tum ekran goruntusu alir

    @googleimage
    Scenario: belirli elementin ekran goruntusu
      Given kullanici "https://www.google.com/" adresine gider
      And google image goruntusunu al

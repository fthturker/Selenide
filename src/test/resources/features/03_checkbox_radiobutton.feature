Feature: checkbox ve radio button
  @checkbox
  Scenario: TC01 checkbox
    Given kullanici "https://testcenter.techproeducation.com/index.php?page=checkboxes" adresine gider
    And "Checkbox 1" secili degilse sec
    And "Checkbox 2" secili degilse sec
    And sayfayi acik tutar
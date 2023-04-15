package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestCenterPage;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.impl.Html.text;

public class TestCenterStepDefinitions {
    TestCenterPage testCenterPage=new TestCenterPage();
    @Given("kullanici adini gir")
    public void kullanici_adini_gir() {
        testCenterPage.kullaniciAdi.setValue("techproed");
    }
    @Given("kullanici sifresini gir")
    public void kullanici_sifresini_gir() {
        testCenterPage.kullaniciSifresi.setValue("SuperSecretPassword");
    }
    @When("submit butonuna tikla")
    public void submit_butonuna_tikla() {
        testCenterPage.submitButton.click();
    }
    @Then("giris yapildigini test et")
    public void giris_yapildigini_test_et() {
        //Assert.assertTrue(testCenterPage.girisMesaji.isDisplayed()); // JUnit
        testCenterPage.girisMesaji.shouldBe(visible); // SELENIDE ASSERTION
        // fail ederse ekran goruntusu otomatik olarak alinir ve build dosyasina kaydeder
    }


    @And("{string} secili degilse sec")
    public void seciliDegilseSec(String arg0) {
        // eger text = Checkbox 1 ve Checkbox 1 secili degilse, Checkbox 1 'e tıkla
        if(text.equals("Checkbox 1") && testCenterPage.checkbox1.isSelected()){
            testCenterPage.checkbox1.click();
            //Assert.assertTrue(testCenterPage.checkbox1.isSelected());
            testCenterPage.checkbox1.shouldBe(checked);
        }
        if (text.equals("Checkbox 2") && !testCenterPage.checkbox2.isSelected()){
            testCenterPage.checkbox2.shouldNotBe(checked); // secili olmadıgını dogrulamak icin
            testCenterPage.checkbox2.click();
            testCenterPage.checkbox2.shouldBe(checked); // secili oldugunu dogrulamak icin
        }
    }
}

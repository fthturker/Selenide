package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestCenterPage;

import static com.codeborne.selenide.Condition.visible;

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
}

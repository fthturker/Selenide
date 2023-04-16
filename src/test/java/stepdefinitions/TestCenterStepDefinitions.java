package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestCenterPage;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.impl.Html.text;
import static java.lang.Thread.sleep;

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
        if(text.equals("Checkbox 1") && !testCenterPage.checkbox1.isSelected()){
            testCenterPage.checkbox1.click();
            //Assert.assertTrue(testCenterPage.checkbox1.isSelected());
            testCenterPage.checkbox1.shouldBe(checked);
        }
        if (text.equals("Checkbox 2") && !testCenterPage.checkbox2.isSelected()){
            testCenterPage.checkbox2.shouldNotBe(checked); // secili olmadıgını dogrulamak icin
            testCenterPage.checkbox2.click();
            testCenterPage.checkbox2.shouldBe(checked); // secili oldugunu dogrulamak icin
        }
        if (text.equals("Red") && !testCenterPage.redbox.isSelected()){
            testCenterPage.redbox.shouldNotBe(checked); // secili olmadigini test et
            testCenterPage.redbox.click(); // sec
            testCenterPage.redbox.shouldBe(checked); // secili oldugunu test et
        }
        if (text.equals("Football") && !testCenterPage.footballbox.isSelected()){
            testCenterPage.footballbox.shouldNotBe(checked); // secili olmadigini test et
            testCenterPage.footballbox.click(); // sec
            testCenterPage.footballbox.shouldBe(checked); // secili oldugunu test et
        }
    }

    // dropdowmn step definitions
    @And("kullanici yil olarak {int}, ay olarak {string}, gun olarak {int}")
    public void kullaniciYilOlarakAyOlarakGunOlarak(int yil, String ay, int gun) throws InterruptedException {
        //testCenterPage.yil.selectOption(String.valueOf(yil)); // metin = "2000"
        testCenterPage.yil.selectOptionByValue(String.valueOf(yil));  // value = "2000"
        sleep(5000);

        testCenterPage.ay.selectOption(ay); // gorunen metin ile sec="June"

        sleep(3000);

        //testCenterPage.gun.selectOptionByValue(String.valueOf(gun)); // value = "15"
        testCenterPage.gun.selectOption(gun-1); // index = 25-1=24 bu 25. gunu secer
        sleep(3000);
    }
    // alert step definitions
    @And("alert prompt butonuna tiklar")
    public void alertPromptButonunaTiklar() {
        testCenterPage.promptButton.click();
    }

    @And("kullanici alerte {string} metnini yazar ve OK e tiklar")
    public void kullaniciAlerteMetniniYazarVeOKETiklar(String arg0) throws InterruptedException {
        switchTo().alert().sendKeys(arg0); // alerte feature den gelen metni girelim
        sleep(3000);
        switchTo().alert().accept(); // OK e tıklayalim
        sleep(3000);
    }

    @And("kullanici sonucu {string} icerdigini dogrular")
    public void kullaniciSonucuIcerdiginiDogrular(String arg0) {
        testCenterPage.sonuc.shouldHave(text(arg0)); // feature den gelen metnin sonuc elementinde icerildigini dogrula
    }
}

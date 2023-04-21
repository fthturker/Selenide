package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.TestCenterPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.codeborne.selenide.impl.Html.text;
import static java.lang.Thread.sleep;

public class TestCenterStepDefinitions {
    TestCenterPage testCenterPage = new TestCenterPage();

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
        if (text.equals("Checkbox 1") && !testCenterPage.checkbox1.isSelected()) {
            testCenterPage.checkbox1.click();
            //Assert.assertTrue(testCenterPage.checkbox1.isSelected());
            testCenterPage.checkbox1.shouldBe(checked);
        }
        if (text.equals("Checkbox 2") && !testCenterPage.checkbox2.isSelected()) {
            testCenterPage.checkbox2.shouldNotBe(checked); // secili olmadıgını dogrulamak icin
            testCenterPage.checkbox2.click();
            testCenterPage.checkbox2.shouldBe(checked); // secili oldugunu dogrulamak icin
        }
        if (text.equals("Red") && !testCenterPage.redbox.isSelected()) {
            testCenterPage.redbox.shouldNotBe(checked); // secili olmadigini test et
            testCenterPage.redbox.click(); // sec
            testCenterPage.redbox.shouldBe(checked); // secili oldugunu test et
        }
        if (text.equals("Football") && !testCenterPage.footballbox.isSelected()) {
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
        testCenterPage.gun.selectOption(gun - 1); // index = 25-1=24 bu 25. gunu secer
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

    @And("switch to frame {int}")
    public void switchToFrame(int frame) {
        switchTo().frame(frame - 1); // 0. indeks = 1. iframe
    }
    @And("kullanici back to techproeducation.com linkine tiklar")
    public void kullaniciBackToTechproeducationComLinkineTiklar() throws InterruptedException {
        testCenterPage.techProLink.click();
        System.out.println("Techpro Linkine tiklandi ve Yeni pencere acildi");
        Thread.sleep(3000);
        // System.out.println("SAYFA URL I: " + WebDriverRunner.url());
        System.out.println("SAYFA URL I: " + url()); // Driver hala test page de olacak
    }

    @And("switch to window {int}")
    public void switchToWindow(int targetWindow) throws InterruptedException {
        switchTo().window(targetWindow - 1, Duration.ofSeconds(5)); // index. Duration.ofSeconds(5) zorunlu değil
        System.out.println("Yeni pencereye gecis yapildi");
        Thread.sleep(3000);
        System.out.println("YENI SAYFA URL I: " + url()); // yeni sayfa url ni verecektir.
    }

    @And("kullanici source elementi target elementine surukler")
    public void kullaniciSourceElementiTargetElementineSurukler() {
        //selenium da
        //Actions actions=new Actions();
        //selenide de kısaca actions()
        // 1. drapAndDrop
        actions()
                .dragAndDrop(testCenterPage.kaynak, testCenterPage.source) // kaynak elementi hedefe surukle
                .build() // baglantiyi olustur (OPTIONAL)
                .perform(); // verilen komutlari yap (ZORUNLU)
    }

    @And("kullanici source elementini {int} by {int} koordinatlarina surukler")
    public void kullaniciSourceElementiniByKoordinatlarinaSurukler(int arg0, int arg1) {
        actions()
                .dragAndDropBy(testCenterPage.kaynak, arg0, arg1)
                .build()
                .perform();
    }

    @And("verilen koordinatlara {int} by {int} suruklendigini dogrula")
    public void verilenKoordinatlaraBySuruklendiginiDogrula(int arg0, int arg1) {
        String styleValue = testCenterPage.kaynak.getAttribute("style");
        System.out.println(styleValue);
        Assert
                .assertTrue(styleValue.contains(String.valueOf(arg0)) && styleValue.contains(String.valueOf(arg1)));
    }

    @Given("start butonuna tiklar")
    public void start_butonuna_tiklar() {
       testCenterPage.startBotton.click();
    }
    @Then("kullanici {string} metnini dogrular")
    public void kullanici_metnini_dogrular(String arg0) {
      // Assert.assertEquals(arg0,testCenterPage.helloWorld.getText()); // fail. wait problemi

        // 1. WebDriverWait
        //WebDriverWait wait=new WebDriverWait(WebDriverRunner.getWebDriver(),Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(testCenterPage.helloWorld)); // explicit wait
        //Assert.assertEquals(arg0,testCenterPage.helloWorld.getText()); // Pass. explicit wait ile problem cozuldu

        // 2. Selenide Wait
        //testCenterPage.helloWorld.should(visible,Duration.ofSeconds(10));
        //Assert.assertEquals(arg0,testCenterPage.helloWorld.getText());

        // 3. Selenide Wait
        testCenterPage.helloWorld.shouldHave(text("Hello World!"),Duration.ofSeconds(10)); // selenide wait
    }


    @And("google image goruntusunu al")
    public void googleImageGoruntusunuAl() {
        testCenterPage.googleImage.screenshot();
    }

    @And("footer elementi gorunur sekilde goster")
    public void footerElementiGorunurSekildeGoster() {
        //testCenterPage.amazonFooter
        executeJavaScript("arguments[0].scrollIntoView(true);",testCenterPage.amazonFooter);

    }
}

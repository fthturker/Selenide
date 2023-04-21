package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Date;

import static com.codeborne.selenide.Selenide.*;

public class CommonStepDefinitions {
    @Given("kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String string) {
        open(string);
    }

    @Then("{int} saniye bekler")
    public void saniye_bekler(Integer int1) {
        // selenide default olarak 4 saniye bekler.
        // 4 saniyeden fazla beklemek icin sleep metotu kullanilir
        // sleep fonksiyonu millisecond kabul eder. saniyeye çevirmek icin 1000 ile carpilir.
        sleep(int1 * 1000);
    }

    @Then("onceki sayfaya gider")
    public void onceki_sayfaya_gider() {
        back();
    }

    @Then("sonraki sayfaya gider")
    public void sonraki_sayfaya_gider() {
        forward();
    }

    @Then("sayfayi yeniler")
    public void sayfayi_yeniler() {
        refresh();
    }

    @Then("sayfayi acik tutar")
    public void sayfayi_acik_tutar() {
        // varsayılan selenide ayarlarında, browser otomatik olarak kapanmaktadir
        Configuration.holdBrowserOpen = false; // varsayilan
        Configuration.holdBrowserOpen = true;
    }

    @And("tum ekran goruntusu alir")
    public void tumEkranGoruntusuAlir() {
        // screenshot(new Date().toString()); // ekran goruntusune dinamik isim verildi.
        screenshot("image");
    }

    @Given("kullanici browser tipini {string} olarak secer")
    public void kullaniciBrowserTipiniOlarakSecer(String browserTipi) {
        switch (browserTipi) {
            case "headless":
                Configuration.headless = true;
                break;
            case "firefox":
                Configuration.browser = "firefox";
                break;
            case "edge":
                Configuration.browser = "edge";
                break;
            case "chrome":
                Configuration.browser = "chrome";
                break;
            default:
                Configuration.browser = "chrome";
                break;
        }
    }
}

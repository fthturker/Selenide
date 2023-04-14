package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class TestCenterPage {
    // kullanici adi
    public SelenideElement kullaniciAdi=$(By.id("exampleInputEmail1"));
    // kullanici sifresi
    public SelenideElement kullaniciSifresi=$("#exampleInputPassword1");
    // submit butonu
    public SelenideElement submitButton=$(By.xpath("//button[@class='btn btn-primary']"));
    // giris mesajı
    public SelenideElement girisMesaji=$(By.xpath("//*[contains(text(),'You logged into a secure area!')]"));
}

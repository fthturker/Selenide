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
    public SelenideElement submitButton=$(By.xpath("//button[@type='submit']"));
    // giris mesajı
    public SelenideElement girisMesaji=$(By.xpath("//*[contains(text(),'You logged into a secure area!')]"));

    // checkbox elementleri
    public SelenideElement checkbox1=$(By.id("box1"));

    public SelenideElement checkbox2=$(By.id("box2"));

    // radio elementleri
    public SelenideElement redbox=$(By.id("red"));

    public SelenideElement footballbox=$(By.id("football"));

    // dropdown elementleri
    public  SelenideElement yil=$(By.id("year"));

    public SelenideElement ay=$(By.id("month"));

    public SelenideElement gun=$(By.id("day"));

    // alert elementleri
    public SelenideElement promptButton=$(By.xpath("//button[@onclick='jsPrompt()']"));

    public SelenideElement sonuc=$("#result");

    // iframe elementleri
    public SelenideElement techProLink=$(By.xpath("//a[@type='button']"));

    // actions elementleri
    public SelenideElement kaynak=$("#draggable");

    public SelenideElement source=$("#droppable");

    // explicit elementleri
    public SelenideElement startBotton=$(By.xpath("//div[@id='start']//button"));

    public SelenideElement helloWorld=$(By.xpath("//div[@id='finish']//h4"));

    // Screenshot
    public SelenideElement googleImage=$(".lnXdpd");

    // Java Script Executor Elementi
    public SelenideElement amazonFooter=$(".navFooterMoreOnAmazon");

}

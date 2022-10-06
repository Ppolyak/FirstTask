import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Test {
    // 1. Открыть браузер на странице регистрации
    // 2. Ввести зипкод 3. нажать продолжить 4. нажать рег кнопку 5. проверить сообщения папку
    WebDriver driver;

    @org.testng.annotations.Test
    public void verifyRegPageTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();  
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String textError = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(textError,"Oops, error on page. Some of your fields have invalid data or email " +
                "was previously used");
        //если ошибка, то код после ассертов не выполняется, поэтому после ассертов лучше ничего не писать
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}

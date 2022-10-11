import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class firstCaseTest {
    // 1. Открыть браузер на странице регистрации
    // 2. Ввести зипкод 3. нажать продолжить 4. нажать рег кнопку 5. проверить сообщения папку
    WebDriver driver;

    @BeforeClass

    @Test //добавить импорт
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

    @Test
    public void allFieldsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Namwwwe");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Nameeee");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("asdasdasd@mail.qw");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("Qweqwe123");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("Qweqwe123");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String  successMessage = driver.findElement(By.xpath("//span[@class='confirmation_message']"))
                .getText();
        Assert.assertEquals(successMessage,"Account is created!");
    }

    @Test
    public void differentPasswordFieldsTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Namwwwe");
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Nameeee");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("asdasdasd@mail.qw");
        driver.findElement(By.xpath("//input[@name='password1']")).sendKeys("Qweqwe123");
        driver.findElement(By.xpath("//input[@name='password2']")).sendKeys("Qweqwe3333");
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        String textError = driver.findElement(By.xpath("//span[@class='error_message']")).getText();
        Assert.assertEquals(textError,"Oops, error on page. Some of your fields have invalid data or email " +
                "was previously used");
    }

    @Test
    public void requiredDisplayedTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        String text = String.valueOf(driver.findElement(By.xpath("//span[@class='required_text']"))
                .isDisplayed());
    }

//    @org.testng.annotations.Test
//    public void freeTest(){
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://www.sharelane.com/cgi-bin/register.py");
//        driver.findElement(By.xpath("//input[@name='zip_code']")).sendKeys("12345");
//        driver.findElement(By.xpath("//input[@value='Continue']")).click();
//        driver.findElement(By.name("keyword")).getText();
//        String testSome = driver.findElement(By.xpath("//input[@name='keyword']")).getText();
//        Assert.assertEquals(testSome,"Search");
//    }

//    @AfterClass
//    public void closeBrowser(){
//        driver.quit();
//    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TestiniumGittiGidiyor {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\z84177291\\Downloads\\chromedriver.exe");
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver driver=new ChromeDriver(capabilities);
        //driver.get("");
        driver.navigate().to("https://www.gittigidiyor.com/");
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WebElement giris_element=driver.findElement(By.xpath("//*[@id=\"main-header\"]/div[3]/div/div/div/div[3]/div/div[1]/div/div[2]"));
        giris_element.click();
        WebElement giris=driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[3]/div/div[1]/div[2]/div/div/div/a"));
        giris.click();
        WebElement username_field= driver.findElement(By.id("L-UserNameField"));
        username_field.sendKeys("TestConnection202101@gmail.com");

        WebElement password_field=driver.findElement(By.id("L-PasswordField"));
        password_field.sendKeys("nimda2021");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement giris_on=driver.findElement(By.id("gg-login-enter"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        giris_on.click();

        //input bilgisayar

       WebElement pc= driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input"));
       pc.click();
       pc.sendKeys("bilgisayar");
       driver.findElement(By.xpath("/html/body/div[1]/header/div[3]/div/div/div/div[2]/form/div/div[2]/button")).click();

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //Actions action=new Actions(driver);
        WebElement element=driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div[5]/ul/li[2]/a"));
        //action.moveToElement(element).build().perform();
        element.click();

        Random random=new Random();
        int upper=8;
        int rand_item= random.nextInt(upper);
        WebElement item= driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/div[2]/div[3]/div[2]/ul/li["+rand_item+"]"));
        item.click();

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
        driver.findElement(By.id("add-to-basket")).click();
    }
}

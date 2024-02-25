import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.w3c.dom.html.HTMLInputElement;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

public class Project2 {
    @Test
public <WebDriverWait, Faker> void test() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://open.spotify.com/");


        driver.findElement(By.cssSelector("[data-testid='login-button']")).click();
        String validUsername = "nara.ali@gmail.com";
        String validPassword = "N123456789!@";
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='login-username']"));
        usernameInput.sendKeys(validUsername);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='login-password']"));
        passwordInput.sendKeys(validPassword);
        passwordInput.sendKeys(Keys.ENTER);

        driver.findElement(By.cssSelector("[aria-label='Search']")).click();

        WebElement searchInput = driver.findElement(By.cssSelector("[placeholder]"));
        searchInput.sendKeys("Adele Hello");


       Actions actions = new Actions(driver);
       actions.sendKeys(Keys.ENTER).perform();

        driver.findElement(By.cssSelector("[aria-label='Play']")).click();



        String expectedSong = "Hello";
        String actualSong = driver.findElement(By.cssSelector("[data-testid='context-item-link']")).getText();
        Assert.assertEquals(expectedSong, actualSong);

        String expectedSinger = "Adele";
        String actualSinger = driver.findElement(By.cssSelector("[data-testid='context-item-info-artist']")).getText();
        Assert.assertEquals(expectedSinger, actualSinger);

        Thread.sleep(15000);
        driver.findElement(By.cssSelector("[data-testid='user-widget-link']")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[data-testid='user-widget-dropdown-logout']")).click();

        String expectedButton = "Log in";
        String actualButton = driver.findElement(By.cssSelector("[data-testid='login-button']")).getText();
        Assert.assertEquals(expectedButton, actualButton);



    }
}
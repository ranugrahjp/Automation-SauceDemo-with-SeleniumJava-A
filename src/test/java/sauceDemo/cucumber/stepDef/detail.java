package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class detail {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user have login in website")
    public void user_have_login_in_website() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }

    @When("user click name of the product")
    public void user_click_name_of_the_product() {
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
    }

    @Then("page will show detail of product")
    public void page_will_show_detail_of_product()  {
        Assert.assertEquals("Sauce Labs Backpack",driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText());
        System.out.println("Scenario : Show Product Detail");
        System.out.println("If Success Choose Product Detail " + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + ", You Can See Title Product Name " + driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText() + " in Product Detail Page");
        driver.quit();
    }
}

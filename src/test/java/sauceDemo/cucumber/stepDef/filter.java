package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
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

public class filter {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user success login")
    public void user_success_login() throws InterruptedException {
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

    @When("user click icon on top right of page")
    public void user_click_icon_on_top_right_of_page() throws Exception{
        driver.findElement(By.xpath("//select[@class='product_sort_container']")).click();
        Thread.sleep(500);
    }

    @And("user choose price low to high")
    public void user_choose_price_low_to_high() throws Exception {
        driver.findElement(By.xpath("//option[@value='lohi']")).click();
        Thread.sleep(500);
    }

    @Then("page will display low until high price of product")
    public void page_will_display_low_until_high_price_of_product() {
        Assert.assertEquals("$7.99",driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        System.out.println("Scenario : choose price (low to high)");
        System.out.println("If Success sorting Price Low to High, You Can See price of First Product " + driver.findElement(By.xpath("//div[@class='inventory_list']//div[1]//div[2]//div[2]//div[1]")).getText());
        driver.quit();
    }
}

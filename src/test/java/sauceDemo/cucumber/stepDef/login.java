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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("user open sauce demo website")
    public void user_open_sauce_demo_website() throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();

        driver = new ChromeDriver(opt);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @When("user input valid username")
    public void user_input_valid_username() throws Exception {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(500);
    }
    @And("input valid password")
    public void input_valid_password() throws Exception{
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(500);
    }
    @When("user click login button")
    public void user_click_login_button() throws Exception {
        driver.findElement(By.id("login-button")).click();
        Thread.sleep(500);
    }
    @Then("product page will appear")
    public void product_page_will_appear() {
        Assert.assertEquals("Products",driver.findElement(By.className("title")).getText());
        System.out.println("Scenario : Login as valid username");
        System.out.println("If Success Login, You Can See Title Name " + driver.findElement(By.className("title")).getText());
        driver.quit();
    }
    @And("input invalid password")
    public void input_invalid_password() throws Exception {
        driver.findElement(By.id("password")).sendKeys("123456");
        Thread.sleep(500);
    }
    @Then("user got error message")
    public void user_got_error_message() {
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        System.out.println("Scenario : Login as invalid username");
        System.out.println("If Failed Login, You Can See Error " + driver.findElement(By.xpath("//h3[contains(text(),'Epic sadface: Username and password do not match a')]")).getText());
        driver.quit();
    }
}

package Test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;


// I have used automationexercise.com website for this test. 



public class EcommerceTest {
	public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\WALTON\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        
        
        // Login
        
        try {
            driver.get("https://www.automationexercise.com/login");
            driver.findElement(By.name("email")).sendKeys("lyxa@mail.com");
            driver.findElement(By.name("password")).sendKeys("Test_Lyxa");
            driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=' Logged in as ']")));
            System.out.println("✅ Logged in successfully");
            takeScreenshot(driver, "screenshots/1_login_success.png");

      
            
            
            
            //Item search and selection            
            
            try {
      
                WebElement productsLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(text(),'Products') or @href='/products']")));
                productsLink.click();
            } catch (Exception e) {
        
                System.out.println("Products link not found, navigating directly to the products URL");
                driver.get("https://www.automationexercise.com/products");
            }
       
            WebElement searchBox = driver.findElement(By.id("search_product"));
            searchBox.sendKeys("Tshirt");
            driver.findElement(By.id("submit_search")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Searched Products']")));
            takeScreenshot(driver, "screenshots/2_search_results.png");

            driver.findElement(By.xpath("(//a[contains(text(), 'View Product')])[1]")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='product-information']")));
            takeScreenshot(driver, "screenshots/3_product_view.png");

            driver.findElement(By.name("quantity")).clear();
            driver.findElement(By.name("quantity")).sendKeys("1");
            driver.findElement(By.cssSelector("button[type='button']")).click();
            System.out.println("Item searched and selected successfully");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.modal-content")));
            driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

            
            
            
            //Adding item to cart and proceeding to checkout            
            
//            System.out.println("Item added to cart");

            driver.findElement(By.linkText("Cart")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active' and contains(text(),'Shopping Cart')]")));
            takeScreenshot(driver, "screenshots/4_cart.png");

            driver.findElement(By.linkText("Proceed To Checkout")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Address Details']")));
            takeScreenshot(driver, "screenshots/5_checkout.png");

            System.out.println("✅ Checkout page reached successfully");

        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }

    private static void takeScreenshot(WebDriver driver, String filePath) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(filePath);
        dest.getParentFile().mkdirs();
        FileUtils.copyFile(src, dest);
    }
}
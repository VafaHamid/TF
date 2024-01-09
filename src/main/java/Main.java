import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://192.168.112.84:8080/Herour/index.html?v=Ni4yNy4wLjA=");
        Thread.sleep(2000);

        WebElement button = driver.findElement(By.id("signInBtn"));
        Actions actions = new Actions(driver);
        actions.click(button).perform();

        String mainWindow = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        Thread.sleep(2000);

        WebElement usernameField = driver.findElement(By.name("identity"));
        usernameField.sendKeys("0036616761");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("T@123");

        Thread.sleep(3000);



        WebElement submitButton = driver.findElement(By.name("go"));
        submitButton.click();

        Thread.sleep(4000);
        WebElement Menubutton = driver.findElement(By.className("ng-binding"));
        Menubutton.click();
        Thread.sleep(4000);
        driver.quit();


    }
}

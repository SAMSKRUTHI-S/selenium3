package selenium2;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testwelcome {
	WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        String page = new File("webpage/welcome.html")
                .getAbsoluteFile()
                .toURI()
                .toString();

        driver.get(page);
    }

    @Test
    public void welcomeMessageTest() {
        String message = driver.findElement(By.tagName("h1")).getText();

        System.out.println("Message: " + message);

        Assert.assertEquals(message, "Welcome to DevOps");
    }

    @Test
    public void pageTitleTest() {
        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        Assert.assertEquals(title, "Welcome");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {
    private Logger log = LoggerFactory.getLogger("TestBase.class");

    public WebDriver driver;

    @BeforeEach
    void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        log.info("Driver initialized properly");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        log.info("Driver quit properly");
    }

}

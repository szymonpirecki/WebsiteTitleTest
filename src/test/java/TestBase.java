import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class TestBase {

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

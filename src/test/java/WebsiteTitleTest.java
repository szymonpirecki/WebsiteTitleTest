import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTitleTest {
    private WebDriver driver;

    @BeforeEach
    void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @ParameterizedTest(name = "Test {index}: {2}")
    @CsvFileSource(resources = "shouldCheckWebsiteTitleParameters.csv")
    @Tag("REGRESSION")
    public void shouldCheckWebsiteTitle(String url, String expectedTitle, String testName) {
        driver.get(url);
        String title = driver.getTitle();
        assertThat(title).isEqualTo(expectedTitle);
    }
}

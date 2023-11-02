import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteTitleTest extends TestBase {

    @ParameterizedTest(name = "Test {index}: {2}")
    @CsvFileSource(resources = "shouldCheckWebsiteTitleParameters.csv")
    @Tag("REGRESSION")
    public void shouldCheckWebsiteTitle(String url, String expectedTitle, String testName) {
        driver.get(url);
        String title = driver.getTitle();
        assertThat(title).isEqualTo(expectedTitle);
    }
}
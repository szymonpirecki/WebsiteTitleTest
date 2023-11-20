import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class WebsiteTitleTest extends TestBase {


    @ParameterizedTest(name = "Test {index}: {2}")
    @CsvFileSource(resources = "shouldCheckWebsiteTitleParameters.csv")
    public void shouldCheckWebsiteTitle(String url, String expectedTitle, String testName) {
        log.info("Start test: " + testName);
        driver.get(url);
        log.debug("Going to the website: " + url);
        String title = driver.getTitle();
        log.debug("Website title equals: " + title);
        log.debug("Expected title equals: " + expectedTitle);
        log.info("Comparing titles");
        try {
            assertThat(title).isEqualTo(expectedTitle);
            log.info(testName + " passed");
        } catch (AssertionError error) {
            log.error(testName + " failed - The received title is different from the expected one");
            throw error;
        }
        log.info(testName + " finalized");
    }
}
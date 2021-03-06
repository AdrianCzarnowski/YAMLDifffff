
import configuration.BrowserConfig;
import configuration.EnvironmentFactory;
import configuration.models.Environment;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

    private static Logger log = LoggerFactory.getLogger("TestBase.class");
    public static final String VALIDATION_PASS = "♛♛♛♛♛♛♛♛♛♛♛♛♛VALIDATION PASS♛♛♛♛♛♛♛♛♛♛♛♛♛";
    protected static WebDriver driver;
    private static BrowserConfig browserConfig;
    private static Environment environmentModel;

    public static Environment getEnvironmentModel() {
        return environmentModel;
    }

    public static void setEnvironmentModel(Environment environmentModel) {
        TestBase.environmentModel = environmentModel;
    }

    @BeforeAll
    static void beforeAll() {
        environmentModel = EnvironmentFactory.getInstance();
        browserConfig = new BrowserConfig(environmentModel);
        driver = browserConfig.getDriver();
    }

    @AfterEach
    void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        log.info("<<<<<<<<<<<<<<Driver CLOSE<<<<<<<<<<<<<<<<");
    }
}





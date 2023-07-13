package amazon.utils;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.filterElements;
import amazon.pages.filteredPageElements;
import amazon.pages.homePageElements;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver;
    private filteredPageElements filteredpageelements;
    private filterElements filterelements;
    private homePageElements homepageelements;
    private scrollInto scrollinto;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        filteredpageelements = new filteredPageElements(driver);
        homepageelements = new homePageElements(driver);
        filterelements =  new filterElements(driver);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public filteredPageElements filteredpageelements(){
        return filteredpageelements;
    }
     public filterElements filterelements(){
         return filterelements;
     }
     public homePageElements homepageelements(){
        return homepageelements;
     }
    public  scrollInto scrollinto(){
        return scrollinto;
    }
}

import amazon.config.EnvFactory;
import amazon.pages.filterElements;
import amazon.utils.BaseTest;
import org.junit.jupiter.api.Test;
import com.typesafe.config.Config;

public class E2E extends BaseTest {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");

    @Override
    public filterElements filterelements() {
        return super.filterelements();
    }

    @Test
    public void searchTVProducts(){
        getDriver().get(HOME_PAGE_URL);
        homepageelements().clickHamberger();
        filterelements().clickTvAppliences();



    }
}

package amazon;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import org.openqa.selenium.WebDriver;

public class Base {
    public WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }


}

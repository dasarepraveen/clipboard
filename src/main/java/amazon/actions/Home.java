package amazon.actions;

import amazon.Base;
import amazon.pages.homePageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.FindElement;

public class Home extends Base {
    public Home(WebDriver driver) {
        super(driver);
    }

    public Home clickHambergermenu(){
        //findElement(homePageElements.hambergerMenu).click();
        return this;
    }
}

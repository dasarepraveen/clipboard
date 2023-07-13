package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePageElements {
    WebDriver driver;
    public homePageElements(WebDriver driver){
        this.driver=driver;
    }
    By hambergerMenu = By.id("nav-hamburger-menu");
    public void clickHamberger(){
        driver.findElement(hambergerMenu).click();
    }
}

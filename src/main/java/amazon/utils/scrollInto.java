package amazon.utils;

import amazon.Base;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class scrollInto extends Base {


    public scrollInto(WebDriver driver) {
        super(driver);
    }

    public void scrollToThGivenElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);

    }
}

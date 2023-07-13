package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class filteredPageElements {
    WebDriver driver;
    public filteredPageElements(WebDriver driver){
        this.driver=driver;
    }
    By results = By.id("s-result-sort-select");
    By secondElement = By.xpath("(//span[@class=\"a-price-whole\"])[2]");

    public void selectFilterBy(){
        driver.findElement(results).click();
    }
    public void clickOnSecondHighest(){
        driver.findElement(secondElement).click();
    }


}

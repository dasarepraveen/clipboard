package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class filterElements {
    WebDriver driver;

    public filterElements(WebDriver driver){
        this.driver=driver;
    }
    By TV_Appliences = By.xpath("//div[text()='TV, Appliances, Electronics']");
    By Telivision = By.xpath("//a[text()='Televisions']");
    By Samsung = By.xpath("//span[text()='Samsung']");

    public void clickTvAppliences(){
        driver.findElement(TV_Appliences).click();
    }
    public void clickTelivision(){
        driver.findElement(Telivision).click();
    }
    public void filterbyBrand(){
        driver.findElement(Samsung).click();
    }


}

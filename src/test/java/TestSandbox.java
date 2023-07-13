import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import com.typesafe.config.Config;
import net.jodah.failsafe.internal.util.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSandbox {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    @Tag("smokeTest")
    @DisplayName("This test is for demo purpose only to show that the basic code works." +
            "You have to use the best practices that you normally use to design your tests")
    @Test
    void assertThatHomePageTitleIsCorrect() {
        driver.get(HOME_PAGE_URL);

        //assertEquals("Amazon.com. Spend less. Smile more.", driver.getTitle());

        //find hamberger menu
        driver.findElement(By.id("nav-hamburger-menu")).click();

        //scroll to tv and click
        WebElement TV_Appliences =driver.findElement(By.xpath("//div[text()='TV, Appliances, Electronics']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",
                TV_Appliences);
        TV_Appliences.click();

        //click teleivision
        driver.findElement(By.xpath("//a[text()='Televisions']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //scroll down and fitler by samsung
        WebElement tvBrand=driver.findElement(By.xpath("//span[text()='Samsung']"));
        js.executeScript("arguments[0].scrollIntoView(true);",
                tvBrand);
        tvBrand.click();
        //sort by price high to low
        WebElement sortBy = driver.findElement(By.id("s-result-sort-select"));
        Select highToLow = new Select(sortBy);
        highToLow.selectByVisibleText("Price: High to Low");

        // select second highest element

//       List<WebElement> price = driver.findElements(By.xpath("//span[@class=\"a-price-whole\"]"));
//        int[] val = new int[price.size()];
//        int i=0;
//       for(WebElement individualPrice : price){
//           val[i]=Integer.parseInt(individualPrice.getText());
//           i++;
//           System.out.println("value "+individualPrice.getText());
//       }
//        int secondHigest = val[1];
//        System.out.println("Second higest is "+secondHigest);
        String currentHandle= driver.getWindowHandle();
        driver.findElement(By.xpath("(//span[@class=\"a-price-whole\"])[2]")).click();
        Set<String> handles=driver.getWindowHandles();
        for(String actual: handles) {
            if(!actual.equalsIgnoreCase(currentHandle)) {
                driver.switchTo().window(actual);
            }
        }
        WebElement aboutThis = driver.findElement(By.xpath("//h1[text()=' About this item ']"));
        assertEquals("About this item", aboutThis.getText());


    }

}

package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ValidationFunctions extends Base{

     public boolean verifyElementDoesNotExist(By by) {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        final List<WebElement> eList = driver.findElements(by);
        final int i = eList.size();
        if (i > 0) {
            for (final WebElement webElement : eList) {
                if (webElement.isDisplayed()) {
                    return false;
                }
            }
        }
        return true;
    }
}

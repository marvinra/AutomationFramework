package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/**
 * Created by eugeniuaftenii on 6/15/2017.
 */
public class HighLight {

    //color: yellow; solid yellow
    public static void highlightElement(WebElement element, Object driver) throws InterruptedException{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "border: solid red;");
            Thread.sleep(1000);
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");

    }

}

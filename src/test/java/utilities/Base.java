package utilities;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base extends PageObject {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
}
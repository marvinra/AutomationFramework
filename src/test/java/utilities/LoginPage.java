package utilities;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by eugeniuaftenii on 10/3/2017.
 */
public class LoginPage extends Base {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='usernameEntered']")
    public WebElement userNameElmt;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordElmt;

    @FindBy(name = "SUBMIT2")
    public WebElement submitbtn;




    HighLight highLight = new HighLight();

    public void userLogsInToApp(String userName, String password) throws InterruptedException {
        userNameElmt.clear();
        highLight.highlightElement(userNameElmt, driver);
        userNameElmt.sendKeys(userName);
        highLight.highlightElement(passwordElmt, driver);
        passwordElmt.sendKeys(password);
        highLight.highlightElement(submitbtn, driver);
        submitbtn.click();


//        List<WebElement> list = driver.findElements(By.xpath(".//*[@id='placeholderForInactivityCheckForm']/center/p[2]/a"));
//        if (list.size()>0)list.get(0).click();


    }
}

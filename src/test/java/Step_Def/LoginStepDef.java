package Step_Def;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import utilities.Base;
import utilities.LoginPage;
import utilities.ReadPropertyFile;

public class LoginStepDef extends Base{

    LoginPage userLoginPage = new LoginPage();
    ReadPropertyFile data = new ReadPropertyFile();

    @Given("^user goes to url$")
    public void user_goes_to_url() throws Throwable {
        String server = System.getProperty("target.server");
        String url = data.geturl();

        switch (server) {
            case "App":
                driver.get(url);
                userLoginPage.userLogsInToApp(data.getUserName(), data.getPassword());
                break;


        }
    }
}

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(plugin={"pretty","html:target/cucumber","json:target/cucumber.json"},
		features={"classpath:features"},
		tags={"@login"}, dryRun = false)

public class CukesRunner {

}

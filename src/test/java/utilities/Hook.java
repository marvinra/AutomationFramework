package utilities;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hook implements DriverSource{

	DataBaseUtils dataBaseUtils = new DataBaseUtils();

	private static WebDriver driver;
	private static WebDriverWait wait;
	
	// Timing
	public static final int TIMEOUT_LOW = 15;
	public static final int TIMEOUT_NORMAL = 30;
	public static final int TIMEOUT_HIGH = 45;
	
	// Windows
	public static final String CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = "./src/test/resources/browser_drivers/chromedriver.exe";
	public static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_PATH = "./src/test/resources/browser_drivers/geckodriver.exe";
	public static final String IEXPLORER_DRIVER = "webdriver.ie.driver";
	public static final String IEXPLORER_DRIVER_PATH = "./src/test/resources/browser_drivers/IEDriverServer.exe";
	public static final String PHANTOMJS_DRIVER = "webdriver.phantomjs.driver";
	public static final String PHANTOMJS_DRIVER_PATH = "./src/test/resources/browser_drivers/phantomjs.exe";
	
	// Linux
	public static final String PHANTOMJS_DRIVER_LINUX = "webdriver.phantomjs.driver";
	public static final String PHANTOMJS_DRIVER_PATH_LINUX = "./src/test/resources/browser_drivers/phantomjs";
	public static final String CHROME_DRIVER_LINUX = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH_LINUX = "/usr/bin/chromedriver";
//	public static final String CHROME_DRIVER_PATH_LINUX = "./src/test/resources/browser_drivers/chromedriver";
	public static final String CHROME_BIN_PATH_LINUX = "/usr/bin/google-chrome";
	public static final String FIREFOX_DRIVER_LINUX = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_PATH_LINUX = "./src/test/resources/browser_drivers/geckodriver";
	public static final String FIREFOX_BIN_PATH_45_7_LINUX = "/usr/bin/firefox";
	

	// Implement DriverSource in the Hook
	@Before
	public void setUp() {

		//dataBaseUtils.startDBConnection();

		// display new properties
		// set up new properties object from file "application.properties"
		FileInputStream propFile;
		try {
			propFile = new FileInputStream("./src/test/resources/application.properties");
			Properties p = new Properties(System.getProperties());
			p.load(propFile);
			System.setProperties(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String os = Utils.OSDetector();
		System.out.println("SO:" + os);

		// Selection of Browser
		String browser = System.getProperty("webDriver");
		if (browser == null) {
			//browser = "gridfirefox";
			browser = "firefox45.7";
			//browser = "gridchrome";
			//browser = "chrome";
		}
		System.out.println(browser);
		if (driver == null || ((RemoteWebDriver) driver).getSessionId() == null) {
			if (os.equalsIgnoreCase("Windows")) {
				switch (browser) {
				case "firefox":
					System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);
	
					// To disable the 'Your connection is not secure'
					ProfilesIni profile = new ProfilesIni();
					FirefoxProfile testprofile = profile.getProfile("default");
					testprofile.setAcceptUntrustedCertificates(true);
					testprofile.setAssumeUntrustedCertificateIssuer(true);
					driver = new FirefoxDriver(testprofile);
					break;
					
				case "firefox45.7":
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", false);
					String firefoxBinPath45_7 = System.getProperty("firefox_bin_path_45_7");
					capabilities.setCapability("firefox_binary",firefoxBinPath45_7);
					capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
					driver = new FirefoxDriver(capabilities);
					break;

					/** IMPLEMENTING DOCKER */
					case "gridchrome":
						DesiredCapabilities gridChromeCapabilities = DesiredCapabilities.chrome();
						gridChromeCapabilities.setBrowserName("chrome");
						gridChromeCapabilities.setPlatform(Platform.LINUX);
						try {
//							String url = System.getProperty("remotewebdriver.url");
							String url = System.getProperty("put selenium grid hub url here");
							//String url ="http://automationdc1.aocms.gtwy.dcn:4445/wd/hub";
									driver = new RemoteWebDriver(new URL(url), gridChromeCapabilities);
							// allow screenshots to be taken
							driver = new Augmenter().augment(driver);
							// Allow files from the host to be uploaded to a remote browser
							((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;

					case "gridfirefox":
						DesiredCapabilities gridFirefoxCapabilities = DesiredCapabilities.firefox();
						gridFirefoxCapabilities.setBrowserName("firefox");
						gridFirefoxCapabilities.setPlatform(Platform.LINUX);
						try {
							//String url = System.getProperty("remotewebdriver.url");
							String url ="http://automationdc1.aocms.gtwy.dcn:4444/wd/hub";
							driver = new RemoteWebDriver(new URL(url), gridFirefoxCapabilities);
							// allow screenshots to be taken
							driver = new Augmenter().augment(driver);
							// Allow files from the host to be uploaded to a remote browser
							((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
						} catch (MalformedURLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;


					case "iexplorer":
					System.setProperty(IEXPLORER_DRIVER, IEXPLORER_DRIVER_PATH);
					driver = new InternetExplorerDriver();
					break;
	
				case "chrome":
				default:
					System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
//					// terminal command to check chromedriver version
//					String command = CHROME_DRIVER_PATH+" --v";
//					String output = Utils.executeCommand(command);
//					System.out.println("Output: "+output);
	
					// To disable the save of credentials
					ChromeOptions options = new ChromeOptions();
					Map<String, Object> prefs = new HashMap<String, Object>();
					prefs.put("credentials_enable_service", false);
					options.setExperimentalOption("prefs", prefs);
					driver = new ChromeDriver(options);
					break;
				}
			} else {
				switch (browser) {
				case "firefox45.7":
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
					capabilities.setCapability("marionette", false);
					capabilities.setCapability("firefox_binary",FIREFOX_BIN_PATH_45_7_LINUX);
					driver = new FirefoxDriver(capabilities);
					break;

                    /** IMPLEMENTING DOCKER */
                    case "gridchrome":
                        DesiredCapabilities gridChromeCapabilities = DesiredCapabilities.chrome();
                        gridChromeCapabilities.setBrowserName("chrome");
                        gridChromeCapabilities.setPlatform(Platform.LINUX);
                        try {
//							String url = System.getProperty("remotewebdriver.url");
                            String url ="http://automationdc1.aocms.gtwy.dcn:4444/wd/hub";
                            driver = new RemoteWebDriver(new URL(url), gridChromeCapabilities);
                            // allow screenshots to be taken
                            driver = new Augmenter().augment(driver);
                            // Allow files from the host to be uploaded to a remote browser
                            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                        } catch (MalformedURLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;

                    case "gridfirefox":
                        DesiredCapabilities gridFirefoxCapabilities = DesiredCapabilities.firefox();
                        gridFirefoxCapabilities.setBrowserName("firefox");
                        gridFirefoxCapabilities.setPlatform(Platform.LINUX);
                        try {
                            //String url = System.getProperty("remotewebdriver.url");
                            String url ="http://automationdc1.aocms.gtwy.dcn:4444/wd/hub";
                            driver = new RemoteWebDriver(new URL(url), gridFirefoxCapabilities);
                            // allow screenshots to be taken
                            driver = new Augmenter().augment(driver);
                            // Allow files from the host to be uploaded to a remote browser
                            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
                        } catch (MalformedURLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        break;
					
				case "chrome":
				default:
					System.setProperty(CHROME_DRIVER_LINUX, CHROME_DRIVER_PATH_LINUX);
//					// To disable the save of credentials
//					ChromeOptions options = new ChromeOptions();
//					Map<String, Object> prefs = new HashMap<String, Object>();
//					prefs.put("credentials_enable_service", false);
//					options.setExperimentalOption("prefs", prefs);
//					driver = new ChromeDriver(options);
					ChromeOptions options = new ChromeOptions();
					options.setBinary(CHROME_BIN_PATH_LINUX);
					// Change permission for CHROME_DRIVER_PATH_LINUX
//			        File file=new File(CHROME_DRIVER_PATH_LINUX);
//			        if (file.exists()) {
//			            System.out.println("Read="+file.canRead());
//			            System.out.println("Write="+file.canWrite());
//			            System.out.println("Execute="+file.canExecute());
//			            System.out.println("Changing CHROME_DRIVER_PATH_LINUX execute permission");
//			            file.setExecutable(true);
//			            System.out.println("Execute="+file.canExecute());
//			        }     
					// terminal command to check chromedriver version
//					String command = "/opt/google/chrome/chromedriver --v";
//					String output = Utils.executeCommand(command);
//					System.out.println("Output: "+output);
					
					driver = new ChromeDriver(options);
					break;
				}

			}
			driver.manage().timeouts().implicitlyWait(TIMEOUT_HIGH, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TIMEOUT_HIGH, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		Base.driver = driver;
		Base.wait = new WebDriverWait(driver, TIMEOUT_HIGH);
		System.out.println(driver);
	}
	
	public static WebDriver getDriver() { // Getter for convenience
		return driver;
	}
	
	@Override
    public WebDriver newDriver() {
        return Base.driver;
    }
	
	@Override
    public boolean takesScreenshots() {
        return true;
    }
	
	@After

	public void tearDown(Scenario scenario) throws Exception {

		//dataBaseUtils.stopDBConnection();

		// take a screenshot if scenario fails
		if (scenario.isFailed()) {
	        try {
	            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	            scenario.embed(screenshot, "image/png" );
	            scenario.write("URL at failure: " + driver.getCurrentUrl());
	        } catch (WebDriverException wde) {
	        	scenario.write("Embed Failed " + wde.getMessage());
	        } catch (ClassCastException cce) {
	            cce.printStackTrace();
	        }
	    }

		if (driver != null) {
			System.out.println(Serenity.getWebdriverManager().getCurrentDriver());
			driver.quit();
			Serenity.getWebdriverManager().closeDriver();
		}
	}	
}
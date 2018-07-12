package utilities;


import jline.internal.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Utils extends Base {

    HighLight highLight = new HighLight();

	public static String OSDetector() {
		String os = System.getProperty("os.name").toLowerCase();
		if (os.contains("win")) {
			return "Windows";
		} else if (os.contains("nux") || os.contains("nix")) {
			return "Linux";
		} else if (os.contains("mac")) {
			return "Mac";
		} else if (os.contains("sunos")) {
			return "Solaris";
		} else {
			return "Other";
		}


	}


	public void waitForPresenceOfElement(WebElement element) {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(200, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.visibilityOf(element));
	}


	public static void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};

		Wait<WebDriver> wait = new WebDriverWait(driver,10);
		try {
			wait.until(expectation);
		} catch (Throwable error) {
		}
	}

	public String convertDateFormat(String OriginalFormat, String TargetFormat, String Date){
		/*
		 * This function will convert given date "Date" with "OriginalFormat" to "TargetFormat"
		 *
		 * Like:
		 * 		2015-02-13 in 02/13/2015
		 *
		 */

		DateFormat original = new SimpleDateFormat(OriginalFormat, Locale.ENGLISH);
		DateFormat target = new SimpleDateFormat(TargetFormat);
		String formattedDate = null;
		try {
			Date date = original.parse(Date);
			formattedDate = target.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formattedDate;
	}


	public boolean verifyElementDoesNotExist(final By by) {
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		final List<WebElement> eList = getDriver().findElements(by);
		final int i = eList.size();
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (i > 0) {
			for (final WebElement webElement : eList) {
				if (webElement.isDisplayed()) {
					return false;
				}
			}
		}
		return true;
	}

	public String getTodayDate(String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);

	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickWithJS(WebElement element) {
//		int i=0;
//		boolean displayed = true;
//		do {
//			i++;
//			try {
//				displayed=element.isDisplayed();
//			} catch (NoSuchElementException e) {
//				System.out.println("NoSuchElementException : " + i);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException m) {
//					m.printStackTrace();
//				}
//			}
//		}while(i<10&&(!displayed));
		Actions action = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(0," + element.getLocation().y + ");", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element );
//		action.moveToElement(element).doubleClick().build().perform();
//		element.sendKeys(Keys.ENTER);
	}

	public void waitForElement(String xpath) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Long.valueOf(30), TimeUnit.SECONDS)
				.pollingEvery(200, TimeUnit.MILLISECONDS).ignoring
						(NoSuchElementException.class).ignoring(StaleElementReferenceException.class).ignoring
						(ElementNotVisibleException.class).ignoring(WebDriverException.class);
		waitForStaleElement(driver.findElement(By.xpath(xpath)));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	public void waitForStaleElement(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<>(driver);
		Log.info("Waiting for stale element");
		try {
			wait.until(ExpectedConditions.stalenessOf(element));
		}catch (Exception e) {
			try {
				Thread.sleep(500);
			}catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		}
	}

	public void clickOnElementByText(String text) throws InterruptedException{
		String xpath = "//*[contains(text(), '"+text+"')]";
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for(WebElement element:list) {
			if (element.isDisplayed()) {
				highLight.highlightElement(element, driver);
				element.click();
				break;
			}
		}
	}

	public void clickOnElementByText2(String text) throws InterruptedException{
		String xpath = "//li[contains(text(), '"+text+"')]";
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for(WebElement element:list) {
			if (element.isDisplayed()) {
				highLight.highlightElement(element, driver);
				element.click();
				break;
			}
		}
	}

	public void clickOnElement(String xpath) throws InterruptedException{
		waitForElement(xpath);
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for(WebElement element:list) {
			if (element.isDisplayed()) {
				highLight.highlightElement(element, driver);
				element.click();
				break;
			}
		}
	}

	public void inputData(String xpath,String arg) throws InterruptedException{
		waitForElement(xpath);
		List<WebElement> list = driver.findElements(By.xpath(xpath));
		for(WebElement element:list){
			if(element.isDisplayed()) {
				highLight.highlightElement(element, driver);
				element.clear();
				element.sendKeys(arg);
				break;
			}
		}
	}

	public void waitForStaleElementPresent(WebElement element) {
		int y = 0;
		boolean clicked = false;
		while (y <= 4 && !clicked) {
			try {
				waitUntilElementIsDisplayed(element);
				clicked = true;
			} catch (StaleElementReferenceException st) {
				Log.warn("::::::::: Trying to recover from a stale element :::::::::");
				y++;
				Log.info("::  Attempt Number :: " + y);
			} catch (WebDriverException we) {
				Log.warn("::::::::: WebDriverException Found :::::::::");
				y++;
				Log.info("::  Attempt Number :: " + y);
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void waitUntilElementIsDisplayed(WebElement element) {
		int i = 0;
		if (!element.isDisplayed()) {
			Log.warn("{ Element not Displayed, PLEASE WAIT... }");
			do {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
				Log.warn("Waiting ...." + i);
			} while ((!element.isDisplayed()) && (i < 4));
		}
		if (!element.isDisplayed()) {
			Log.error("------------ Timeout ------------");
			Log.error("??? Element not displayed yet ???");
		}
	}



}
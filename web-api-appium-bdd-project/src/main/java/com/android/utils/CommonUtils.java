package com.android.utils;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import com.backend.executor.WebDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;

public class CommonUtils {
	public static void waitTillSpinnerGone() {

	}

	public static AndroidElement getAndroidElement(String locator, String args) {
		return (AndroidElement) WebDriverManager.getAndroidDriver().findElement(By.xpath(String.format(locator, args)));
	}

	public static IOSElement getIOSElement(String locator, String args) {
		return (IOSElement) WebDriverManager.getIOSDriver().findElement(By.xpath(String.format(locator, args)));
	}

	public static void swipeVertical(SwipeDirection direction) throws InterruptedException {
		Dimension size = WebDriverManager.getDriver().manage().window().getSize();
		int starty = 0;
		int endy = 0;
		switch (direction) {
		case BottomToTop:
			starty = (int) (size.height * 0.20);
			endy = (int) (size.height * 0.80);
			break;
		case TopToBottom:
			starty = (int) (size.height * 0.80);
			endy = (int) (size.height * 0.20);
			break;
		}
		int startx = size.width / 2;
		WebDriverManager.getAndroidDriver().swipe(startx, endy, startx, starty, 1000);
	}

	private static void sendNumericKeys(String keySequence) {
		List<IOSElement> keyBoardList = WebDriverManager.getIOSDriver().findElementsByClassName("XCUIElementTypeKey");
		HashMap<String, IOSElement> keyBoardMap = new HashMap<String, IOSElement>();
		for (IOSElement ele : keyBoardList) {
			keyBoardMap.put(ele.getAttribute("label"), ele);
		}
		String[] keyArray = keySequence.split("(?!^)");
		for (String chr : keyArray) {
			keyBoardMap.get(chr).click();
		}
	}

	public static void tabByCoordinates(WebElement element, int fingers, int duration) {
		WebDriverManager.getAppiumDriver().tap(fingers, element, duration);
	}

	public static void tabByElement(WebElement element, int fingers, int duration) {
		Point point = element.getLocation();
		WebDriverManager.getAppiumDriver().tap(fingers, point.x, point.y, duration);
	}

	public static void scrollToNativeElement1(WebElement element) {
		// WebDriverManager.getAppiumDriver().scrollTo(element.getText().toString());
	}

	public static void clickWebElement(WebElement element) throws InterruptedException {
		try {
			element.click();
		} catch (Exception e) {
			Thread.sleep(2000);
			element.click();
		}
	}

	public static void clickOnElement(AppiumDriver driver, WebElement elementToBeClicked) {
		if ((boolean) elementToBeClicked.getAttribute("clickable").equalsIgnoreCase("false")) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("Argument[0].setAttribute('clickable','true')", elementToBeClicked);
		}
		elementToBeClicked.click();
	}

	public static void scrollToNativeElement(WebElement element) {
		// driver.scrollTo(element.getText().toString());
	}

	public static void scrollToHalfScreensize(int startx, int starty, int endx, int endy, int duration) {
		WebDriverManager.getAppiumDriver().swipe(startx, starty, endx, endy, duration);
	}

	public static void swipeToNativeElement(AppiumDriver driver, WebElement elementStart, WebElement elementEnd,
			int duration) {
		// int
		// startx=driver.scrollTo(elementStart.getText()).getLocation().getX();
		// int
		// starty=driver.scrollTo(elementStart.getText()).getLocation().getY();;
		//
		// int endx=driver.scrollTo(elementEnd.getText()).getLocation().getX();
		// int endy=driver.scrollTo(elementEnd.getText()).getLocation().getY();
		// driver.swipe(startx, starty, endx, endy, duration);
		// }
	}

	public static void scrollToTop(String eleText, String platform) {
		/*
		 * WebElement qafElement = null; WebDriver driver1 ;
		 * 
		 * if (platform.contains(CommonProperties.PlatformName.Android)) {
		 * ((AppiumDriver) driver1).scrollTo(eleText); ((AppiumDriver)
		 * driver1).swipe(100, 1275, 100, 275, 1000); } else if
		 * (platform.contains(CommonProperties.PlatformName.iOS)) { int i = 0;
		 * TouchAction touchAction = new TouchAction((MobileDriver) driver1);
		 * Point point = null; try { point = driver1 .findElement("")
		 * .getLocation(); } catch (Exception e) { } int y = point.getY(); i =
		 * 0; while ((i < 15) || driver1 .findElement(String.format("",
		 * eleText)) .getLocation().getY() < 300) { touchAction.press(50,
		 * 1300).moveTo(50, 1250).release(); ((MobileDriver) driver1)
		 * .performTouchAction(touchAction); i++; }
		 * 
		 * }
		 */

	}

	public static void scrollTillDisplayed(String eleText, String platform) {
		/*
		 * boolean isElementDisplayed = false;
		 * 
		 * 
		 * if (platform.contains(CommonProperties.PlatformName.Android))
		 * ((AndroidDriver) androidDriver).scrollTo(eleText); else if
		 * (platform.contains(CommonProperties.PlatformName.iOS)) { IOSDriver
		 * driver2 ; try { if
		 * (driver2.findElementByPartialLinkText(eleText).isDisplayed()) {
		 * isElementDisplayed = true; } } catch (WebDriverException e) {
		 * e.printStackTrace(); } while (!isElementDisplayed) {
		 * driver2.swipe(750, 1000, 750, 850, 1000); if
		 * (driver2.findElementByPartialLinkText(eleText).isDisplayed()) {
		 * isElementDisplayed = true; }
		 * 
		 * } }
		 */

	}

	public static void swipeRight(WebElement ele) {
		Point point = ele.getLocation();
		int startx = point.getX();
		int endx = startx + 500;
		int starty = point.getY() + 20;
		int endy = starty;
		WebDriverManager.getAppiumDriver().swipe(startx, starty, endx, endy, 500);
	}

	public static void swipHalfScreenUp() {

		TouchAction touchAction = new TouchAction(WebDriverManager.getMobileDriver());
		WebDriverManager.getIOSDriver().swipe(550, 1120, 550, 1290, 2);
		touchAction.press(550, 1290).moveTo(550, 1120).waitAction(2000).release();
	}

	public static void clickKeyBoardKey(String genericLocator, String keyValue) {
		// try {
		// getIOSElement(genericLocator, keyValue).click();
		// } catch (Exception e) {
		// WebDriverManager.getIOSDriver().tap(1,
		// element,
		// keyValue, keyValue)),
		// 1);
		// }

	}

	public static void selectFromSinglePicker(String text) {
		// try {
		// element.click();
		// } catch (Exception e) {
		// IOsDriver.tap(1, element, 1);
		// }
	}

	public static void scrollToEle(String exactText) {
		// try {
		// AppiumDriver appiumDriver ;
		// appiumDriver.scrollTo(exactText);
		// } catch (SeleniumException e) {
		// new getDriver().getTouchScreen().flick(0,
		// (CommonUtilityFunctions.getIntNum("400")));
		// }
	}
}

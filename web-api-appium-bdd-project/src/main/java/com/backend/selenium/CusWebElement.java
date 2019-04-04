package com.backend.selenium;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.backend.executor.WebDriverManager;



public abstract class CusWebElement implements WebElement {
	
	WebElement element;
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(WebDriverManager.getDriver());

	// explicit wait
		public void waitForVisible(long timeout){
			wait.withTimeout(timeout, TimeUnit.MILLISECONDS)
			.pollingEvery(2000, TimeUnit.MILLISECONDS)
			.ignoring(NoSuchElementException.class)
			.until(ExpectedConditions.visibilityOf(this));
		};

//		void waitForNotVisible(long... timeout);
//
//		void waitForDisabled(long... timeout);
//
//		void waitForEnabled(long... timeout);

		void waitForPresent(long... timeout){
			
		};

//		void waitForNotPresent(long... timeout);
//
//		void waitForText(String text, long... timeout);
//
//		void waitForText(StringMatcher matcher, long... timeout);
//
//		void waitForNotText(String text, long... timeout);
//
//		void waitForNotText(StringMatcher matcher, long... timeout);
//
//		void waitForValue(Object value, long... timeout);
//
//		void waitForNotValue(Object value, long... timeout);
//
//		void waitForSelected(long... timeout);
//
//		void waitForNotSelected(long... timeout);
//
//		void waitForAttribute(String attr, String value, long... timeout);
//
//		void waitForNotAttribute(String attr, String value, long... timeout);
//
//		void waitForAttribute(String attr, StringMatcher value, long... timeout);
//
//		void waitForNotAttribute(String attr, StringMatcher value, long... timeout);
//
//		void waitForCssClass(String className, long... timeout);
//
//		void waitForNotCssClass(String className, long... timeout);
//
//		void waitForCssStyle(String prop, String value, long... timeout);
//
//		void waitForNotCssStyle(String prop, String value, long... timeout);
//		
//		/**
//		 * Special method to wait for css color property. For other css properties use {@link #waitForCssStyle(String, String, String...)}
//		 * @param prop css style property for color to validate. For example: color, background-color
//		 * @param value expected value - valid color name or rgb or rgba or hax
//		 * @param timeout optional timeout and interval
//		 */
//		void waitForCssStyleColor(String prop, String value, long... timeout);
//
//		/**
//		 * Special method to wait for css color property. For other css properties use {@link #waitForNotCssStyle(String, String, String...)}
//		 * @param prop css style property for color to validate. For example: color, background-color
//		 * @param value expected value - valid color name or rgb or rgba or hax
//		 * @param timeout optional timeout and interval
//		 */
//		void waitForNotCssStyleColor(String prop, String value, long... timeout);
//
//		// verifications
//		boolean verifyPresent(String... label);
//
//		boolean verifyNotPresent(String... label);
//
//		boolean verifyVisible(String... label);
//
//		boolean verifyNotVisible(String... label);
//
//		boolean verifyEnabled(String... label);
//
//		boolean verifyDisabled(String... label);
//
//		boolean verifyText(String text, String... label);
//
//		boolean verifyText(StringMatcher matcher, String... label);
//
//		boolean verifyNotText(String text, String... label);
//
//		boolean verifyNotText(StringMatcher matcher, String... label);
//
//		<T> boolean verifyValue(T t, String... label);
//
//		<T> boolean verifyNotValue(T t, String... label);
//
//		boolean verifySelected(String... label);
//
//		boolean verifyNotSelected(String... label);
//
//		boolean verifyAttribute(String attr, String value, String... label);
//
//		boolean verifyAttribute(String attr, StringMatcher matcher, String... label);
//
//		boolean verifyNotAttribute(String attr, String value, String... label);
//
//		boolean verifyNotAttribute(String attr, StringMatcher matcher, String... label);
//
//		boolean verifyCssClass(String className, String... label);
//
//		boolean verifyNotCssClass(String className, String... label);
//
//		boolean verifyCssStyle(String prop, String value, String... label);
//
//		boolean verifyNotCssStyle(String prop, String value, String... label);
//		
//		/**
//		 * Special method to validate css color property. For other css properties use {@link #verifyCssStyle(String, String, String...)}
//		 * @param prop css style property for color to validate. For example: color, background-color
//		 * @param value expected value - valid color name or rgb or rgba or hax
//		 * @param label optional label to use in report. If not provided it will use description if available
//		 */
//		boolean verifyCssStyleColor(String prop, String value, String... label);
//
//		/**
//		 * Special method to validate css color property. For other css properties use {@link #verifyNotCssStyle(String, String, String...)}
//		 * @param prop css style property for color to validate. For example: color, background-color
//		 * @param value expected value - valid color name or rgb or rgba or hax
//		 * @param label optional label to use in report. If not provided it will use description if available
//		 */
//		boolean verifyNotCssStyleColor(String prop, String value, String... label);
//
//		// preconditions
//		void givenPresent();
//
//		void givenNotPresent(String... label);
//
//		// assertions
//		void assertPresent(String... label);
//
//		void assertNotPresent(String... label);
//
//		void assertVisible(String... label);
//
//		void assertNotVisible(String... label);
//
//		void assertEnabled(String... label);
//
//		void assertDisabled(String... label);
//
//		void assertText(String text, String... label);
//
//		void assertNotText(String text, String... label);
//
//		void assertText(StringMatcher matcher, String... label);
//
//		void assetNotText(StringMatcher matcher, String... label);
//
//		<T> void assertValue(T t, String... label);
//
//		<T> void assertNotValue(T t, String... label);
//
//		void assertSelected(String... label);
//
//		void assertNotSelected(String... label);
//
//		void assertAttribute(String attr, String value, String... label);
//
//		void assertAttribute(String attr, StringMatcher matcher, String... label);
//
//		void assertNotAttribute(String attr, String value, String... label);
//
//		void assertNotAttribute(String attr, StringMatcher matcher, String... label);
//
//		void assertCssClass(String className, String... label);
//
//		void assertNotCssClass(String className, String... label);
//
//		void assertCssStyle(String prop, String value, String... label);
//
//		void assertNotCssStyle(String prop, String value, String... label);
//		
//		/**
//		 * Special method to validate css color property. For other css properties use {@link #assertCssStyle(String, String, String...)}
//		 * @param prop css style property for color to validate. For example: color, background-color
//		 * @param value expected value - valid color name or rgb or rgba or hax
//		 * @param label optional label to use in report. If not provided it will use description if available
//		 */
//		void assertCssStyleColor(String prop, String value, String... label);
//
//		/**
//		 * Special method to validate css color property. For other css properties use {@link #assertNotCssStyle(String, String, String...)}
//		 * @param prop css style property for color to validate. For example: color, background-color
//		 * @param value expected value - valid color name or rgb or rgba or hax
//		 * @param label optional label to use in report. If not provided it will use description if available
//		 */
//		void assertNotCssStyleColor(String prop, String value, String... label);

}

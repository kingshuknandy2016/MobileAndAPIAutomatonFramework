package com.android.steps;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;

import com.android.utils.CommonUtils;
import com.android.utils.SwipeDirection;
import com.backend.executor.WebDriverManager;

public class EmployeeDetailsPage extends WebDriverManager {

	public EmployeeDetailsPage() throws MalformedURLException {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	public void scrollToElementAndTap(String name) throws InterruptedException {
		AndroidElement nameOfEmp;
		try {
			nameOfEmp = CommonUtils.getAndroidElement("//*[contains(@text,'%s')]", name);
			if (nameOfEmp.isDisplayed()) {
				nameOfEmp.tap(1, 10);
			}
		} catch (Exception e) {
			CommonUtils.swipeVertical(SwipeDirection.BottomToTop);
			scrollToElementAndTap(name);
		}
	}
}

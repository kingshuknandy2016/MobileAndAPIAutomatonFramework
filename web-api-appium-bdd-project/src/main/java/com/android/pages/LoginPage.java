package com.android.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.support.PageFactory;

import com.backend.executor.WebDriverManager;




import io.appium.java_client.DeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginPage extends WebDriverManager {

	public LoginPage() throws MalformedURLException {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
	}

	/*public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}*/
//
//	@FindBy(how = How.CLASS_NAME, using = "android.widget.TextView")
//	private CusWebElement header;

	@AndroidFindBy(id = "com.automationtest:id/editTextEmail")
	private AndroidElement username;

	@AndroidFindBy(id = "com.automationtest:id/editTextPassword")
	private AndroidElement password;

	@AndroidFindBy(id = "com.automationtest:id/buttonLogin")
	private AndroidElement loginBtn;
	
	@AndroidFindBy(id = "com.automationtest:id/snackbar_text")
	private AndroidElement errorMsg;

//	public CusWebElement getHeader() {
//		return header;
//	}

	public AndroidElement getUsername() {
		return username;
	}

	public AndroidElement getPassword() {
		return password;
	}

	public AndroidElement getLoginBtn() {
		return loginBtn;
	}
	
	public AndroidElement getErrMsg() {
		return errorMsg;
	}

	public void waitForPageToLoad() {
		//getHeader().waitForVisible(4000);
	}

	public void enterUserNamePass(String username, String password) {
		try {
			getUsername().sendKeys(username);
			getPassword().sendKeys(password);
		} catch (Exception e1) {
			System.out.println("Exception Occured. Exception:"+e1.getMessage());
		}
	}
	
	public void clickLogin() {
		try {
			//AndroidDriver driver=(AndroidDriver) WebDriverManager.getDriver();
			((DeviceActionShortcuts) getDriver()).hideKeyboard();
			getLoginBtn().click();
		} catch (Exception e2) {
			System.out.println("Exception Occured. Exception:"+e2.getLocalizedMessage());
		}
	}

	public void validateSuccessfullLogin() {
		System.err.println("Message:"+getErrMsg().getText());
	}

}

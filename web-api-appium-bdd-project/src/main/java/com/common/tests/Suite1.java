package com.common.tests;

import java.net.MalformedURLException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.android.steps.LoginPageSteps;
import com.backend.utils.ConfigurationManager;
import com.backend.utils.ExcelUtils;

public class Suite1 {

	@DataProvider(name="loginCredentials")
	public Object[][] getLoginCredentials(){
		ExcelUtils data = new ExcelUtils(System.getProperty("user.dir") + "\\resources\\"
				+ ConfigurationManager.getBundle().getProperty("data.provider").toString(), "Sheet1");
		Object object[][] = new Object[data.getRowCount() - 1][3];
		for (int i = 0; i < data.getRowCount() - 1; i++) {
			for (int j = 0; j < 3; j++) {
				object[i][j] = data.getCellData(i + 1, j);
			}
		}
		return object;
	}
	
	@Test(dataProvider="loginCredentials")
	public void LoginFeatureVerification(String Email,String Password,String message) throws Throwable{
		//System.err.println(Email+":"+Password+":"+message);
		LoginPageSteps.launch();
		LoginPageSteps.userEntersUserNamePassword(Email, Password);
	}
}

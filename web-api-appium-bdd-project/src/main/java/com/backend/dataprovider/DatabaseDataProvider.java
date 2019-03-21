package com.backend.dataprovider;

import org.testng.annotations.DataProvider;

import com.backend.utils.DatabaseUtils;

public class DatabaseDataProvider {
	@DataProvider(name="dataProviderDB")
	public Object[][] getDataFromDB() {
		Object object[][]=DatabaseUtils.getData("select * from orders");
		return object;
	}
}

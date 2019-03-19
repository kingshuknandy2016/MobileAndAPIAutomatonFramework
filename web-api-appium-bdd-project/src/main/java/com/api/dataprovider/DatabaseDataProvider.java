package com.api.dataprovider;

public class DatabaseDataProvider {
	@DataProvider(name="dataProviderDB")
	public Object[][] getDataFromDB() {
		Object object[][]=DatabaseUtils.getData("select * from orders");
		return object;
	}
}

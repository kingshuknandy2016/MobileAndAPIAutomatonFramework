package com.api.backend.executor;

import org.testng.annotations.Factory;
import com.api.dataprovider.DatabaseDataProvider;
import com.api.dataprovider.ExcelDataProvider;

public class TestFactory {
@Factory
	public Object[] factoryMethod() {
		return new Object[] {new ExcelDataProvider(),new DatabaseDataProvider()};	
	}
}

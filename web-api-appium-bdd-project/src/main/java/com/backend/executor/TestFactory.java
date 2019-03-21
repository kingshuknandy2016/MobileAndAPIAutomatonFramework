package com.backend.executor;

import org.testng.annotations.Factory;

import com.backend.dataprovider.DatabaseDataProvider;
import com.backend.dataprovider.ExcelDataProvider;

public class TestFactory {
@Factory
	public Object[] factoryMethod() {
		return new Object[] {new ExcelDataProvider(),new DatabaseDataProvider()};	
	}
}

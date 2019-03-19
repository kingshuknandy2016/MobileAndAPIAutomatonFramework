package com.api.backend.executor;

public class TestFactory {
@Factory
	public Object[] factoryMethod() {
		return new Object[] {new ExcelDataProvider(),new DatabaseDataProvider()};	
	}
}

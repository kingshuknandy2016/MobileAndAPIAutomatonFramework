package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.listners.RetryAnalyzer;

public class TestSuite1 {
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void Test1(){
		Assert.assertEquals(false, true);
	}
	
	@Test
	public void Test2(){
		Assert.assertEquals(false, true);
	}
}

package com.api.dataprovider;

public class ExcelDataProvider {
	@DataProvider(name = "dataProviderExcel")
	public Object[][] getDataFromExcel() {
		ExcelUtils data = new ExcelUtils(System.getProperty("user.dir") + "\\resources\\"
				+ ConfigurationManager.getBundle().getProperty("data.provider").toString(), "userDetails");
		Object object[][] = new Object[data.getRowCount() - 1][3];
		for (int i = 0; i < data.getRowCount() - 1; i++) {
			for (int j = 0; j < 3; j++) {
				object[i][j] = data.getCellData(i + 1, j);
			}
		}
		return object;
	}

	public static void main(String[] args) {
		ExcelUtils data = new ExcelUtils(System.getProperty("user.dir") + "\\resources\\"
				+ ConfigurationManager.getBundle().getProperty("data.provider").toString(), "userDetails");
		data.getCellData(1, 0);
	}
}

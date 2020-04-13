package amazon.AppiumFramework;

import org.testng.annotations.DataProvider;

public class TestData {

	@DataProvider(name ="InputData1")
	public Object[][] getDataforEditField() {
		//entering already registered account into the edit field
		Object[][] obj = new Object[][]
				{
			{"12345678"}
				};
				return obj;
	}
	
	@DataProvider(name ="InputData2")
	public Object[][] getDataforPassField() {
		//entering password for the account in password field
		Object[][] obj = new Object[][]
				{
			{"12345678"}
				};
				return obj;
	}
	
	@DataProvider(name ="InputData3")
	public Object[][] getDataforSearchField() {
		//entering password for the account in password field
		Object[][] obj = new Object[][]
				{
			{"65-inch TV"}
				};
				return obj;
	}
}

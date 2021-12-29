package Practices;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest {
	@Test(dataProvider = "getData")
	
	public void readDataFromDataProvider(String name, int qty) {
		System.out.println("Mobile name....)"+name+"...Mobile Quantity....)"+qty);
		
	}
	
@DataProvider
public Object[][]getData() 
{
	
	Object[][] objArr=new Object[3][2];
	
	objArr[0][0]="I Phone";
	objArr[0][1]=10;
	
	objArr[1][0]="Samsung";
	
	objArr[1][1]=20;
	
	objArr[2][0]="Vivo";
	objArr[2][1]=30;
	return objArr;
	

	
}
}


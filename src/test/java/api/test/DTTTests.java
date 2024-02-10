package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.Dataprovider;
import io.restassured.response.Response;

public class DTTTests {
	
	//post request for multiple users
	
	@Test(priority=1, dataProvider="Data" , dataProviderClass=Dataprovider.class)
	public void testPostUser(String userID,String userName , String fname,String lanme,String userEmail,String pwd,String ph ){
	 User userPayload=new User();
	 
	 userPayload.setId(Integer.parseInt(userID));
	 userPayload.setUsername(userName);
	 userPayload.setFirstName(fname);
	 userPayload.setLastName(lanme);
	 userPayload.setEmail(userEmail);
	 userPayload.setPassword(pwd);
	 userPayload.setPhone(ph);
	 
	 
		Response response=Userendpoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority=2, dataProvider="UserNames",dataProviderClass=Dataprovider.class)
	public void testDeleteUserByName(String userName) {
		
		
		Response response=Userendpoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	

}

package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.endpoints.Userendpoints2properties;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2properties {

	Faker faker;
	User userPayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		faker =new Faker();
		userPayload=new User();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		
		logger=LogManager.getLogger(this.getClass());
		logger.debug("******** dubigging*********");
	}
	
	@Test(priority=1)
	public void testPostUser(){
		
		
		logger.info("***********Creating user *************");
		Response response=Userendpoints2properties.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************ user is created ************");

	}
	@Test(priority=2)
	public void testGetUserByName() {
		logger.info("**********Reading user Info**************");

		Response response=Userendpoints2properties.readUser(this.userPayload.getUsername());
		response.then().log().all();
		//response.statusCode();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("************user info is displayed **************");

	}
	@Test(priority=3)
	public void updateUserByName() {
		
		//Update data usig payload
		//userPayload.setUsername(faker.name().username());
		logger.info("***********Updating user ************");

		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=Userendpoints.updateUser(this.userPayload.getUsername(), userPayload);//(Existingusername,updated payload)
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*********user is updated************");

		//checking data after update
		Response afterupdate=Userendpoints2properties.readUser(this.userPayload.getUsername());//after updating we need to checl data correct or not
		//response.then().log().all();
		//response.statusCode();
		Assert.assertEquals(afterupdate.getStatusCode(),200);
	
	}
	
	@Test(priority=4)
	public void testDeleteUserByName() {
		logger.info("***********Delete user *************");

		Response response=Userendpoints2properties.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("********* user deleted *************");

	
	}
	

}

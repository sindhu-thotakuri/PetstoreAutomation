package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//user endponts.java
//created for perform CURD operations -->Create,Read,Update,Delete requests to the user API
public class Userendpoints {
	
	public static Response createUser(User payload) 
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);//we can access direct wit classname .varibale name
		return response;
		
	}
	public static Response readUser(String userName) 
	{
		Response response=given()
	    .pathParam("username", userName)
		.when()
		.get(Routes.get_url);//we can access direct wit classname .varibale name
		return response;
		
	}
	public static Response updateUser(String userName , User payload) 
	{
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.post(Routes.update_url);//we can access direct wit classname .varibale name
		return response;
		
	}
	public static Response deleteUser(String userName) 
	{
		Response response=given()
	    .pathParam("username", userName)
		.when()
		.get(Routes.delete_url);//we can access direct with classname .variable name
		return response;
		
	}

	
	

}

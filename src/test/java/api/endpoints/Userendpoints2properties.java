package api.endpoints;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


//user endponts.java
//created for perform CURD operations -->Create,Read,Update,Delete requests to the user API
public class Userendpoints2properties {
	
	//Create for getting URL from properties file
	static ResourceBundle getURL(){
		ResourceBundle routes=ResourceBundle.getBundle("Routes");      //load properties file
	
	  return routes;
	}
	
	
	public static Response createUser(User payload) 
	{
	String Post_URL	=getURL().getString("post_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Post_URL);
		return response;
		
	}
	public static Response readUser(String userName) 
	{
		String Get_URL	=getURL().getString("get_url");
		Response response=given()
	    .pathParam("username", userName)
		.when()
		.get(Get_URL);//we can access direct wit classname .varibale name
		return response;
		
	}
	public static Response updateUser(String userName , User payload) 
	{
		
		String Update_Url	=getURL().getString("update_url");
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.post(Update_Url);//we can access direct wit classname .varibale name
		return response;
		
	}
	public static Response deleteUser(String userName) 
	{

		String Delete_URL	=getURL().getString("delete_url");
		Response response=given()
	    .pathParam("username", userName)
		.when()
		.get(Delete_URL);//we can access direct with classname .variable name
		return response;
		
	}

	
	

}

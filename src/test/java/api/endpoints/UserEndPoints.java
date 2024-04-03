package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import freemarker.core.ReturnInstruction.Return;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//Here we are performing the CRUD operations (Create ,Read,Update ,Delete )on "user API /ends points"


public class UserEndPoints {

	//For post request need to send Payload to create a user for that we need to send parameter
		public static Response createUser(User payload) 
		
		{
			
			//While send post request need to create response variable 
			Response res=given()
		
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			
			.when()
				.post(Routes.Post_url);
			
			return res;
		 }
		
		public static Response readUser(String userName) 
		{
					
			Response res=given()
				.pathParam("username",userName)		
			
			.when()
				.get(Routes.get_url);
			
			return res;
								
		}
		
		//For post request need to send Payload to create a user for that we need to send parameter
			public static Response updateUser(String userName,User payload) 
			
			{
				
				//While send post request need to create response variable 
				
				Response res=given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username",userName)
					.body(payload)
				
				.when()
					.put(Routes.put_url);
				
				return res;
			 }
			
			public static Response deleteUser(String userName) 
			{
							
				Response res=given()
					.pathParam("username",userName)
				
				
				.when()
					.delete(Routes.Delete_url);
				
				return res;
					
							
			}
		
		
		
		
		
	
	
	
	
}

package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;



public class UserTests {
	
	Faker faker;
	User userpayload;
	
	@BeforeClass
	public void setUpdate() 
	{
		
		faker =new Faker();
		userpayload= new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority = 1)
	public void testPostUser() {
		
		Response res=UserEndPoints.createUser(userpayload);
		res.then().log().all();
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
		
	}
	@Test(priority = 2)
	public void testGetUserByName() {
		
		 Response res=UserEndPoints.readUser(this.userpayload.getUsername());
		 res.then().log().all();
		 AssertJUnit.assertEquals(res.getStatusCode(),200);
		
	}
	
	@Test(priority = 3)
	public void testUpdateUser() {
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response res=UserEndPoints.updateUser(this.userpayload.getUsername(),userpayload);
		res.then().log().body();
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
		
		//Checking data after update request 
		
		Response responseAfterUpdate =UserEndPoints.readUser(this.userpayload.getUsername());
		AssertJUnit.assertEquals(responseAfterUpdate.getStatusCode(),200);
		
	}
	
	@Test(priority = 4)
	public void testDeleteUserByName() {
		
		Response res=UserEndPoints.deleteUser(this.userpayload.getUsername());
		res.then().log().all();
		AssertJUnit.assertEquals(res.getStatusCode(), 200);
		
	}
	
	
	
	
	
	

}

package api.test;

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
		Assert.assertEquals(res.getStatusCode(), 200);
		
	}
	@Test(priority = 2)
	public void testGetUserByName() {
		
		 Response res=UserEndPoints.readUser(this.userpayload.getUsername());
		 res.then().log().all();
		 Assert.assertEquals(res.getStatusCode(),200);
		
	}
	

}

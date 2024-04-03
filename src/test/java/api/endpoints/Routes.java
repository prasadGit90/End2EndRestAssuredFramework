package api.endpoints;


/* 
 Using from source of Internet Swagger URI --> https://petstore.swagger.io
 In routes folder need to add only url's of the different modules 
*/

public class Routes {

	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User end points 

	
	public static String Post_url =base_url+ "/user";
	public static String get_url = base_url+"/user/{username}";
	public static String put_url = base_url+"/user/{username}";
	public static String Delete_url = base_url+"/user/{username}";
	
	
	//Store ends points 
	
	 
	//pet end points 
	
}

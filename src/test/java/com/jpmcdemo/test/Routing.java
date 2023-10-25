package com.jpmcdemo.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpmcdemo.javautil.GenericJavaMethods;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import pojos.Comments;
import pojos.Posts;
import pojos.Users;

public class Routing {
 	 Posts posts;
 	 Comments comments;
 	
 	public Routing(String baseUrl) {
 		RestAssured.baseURI = baseUrl;
 	}
	public Users[] getListOfUsers() throws JsonMappingException, JsonProcessingException {		
		Response response =  RestAssured.given().header("Content-Type", "application/json").request(Method.GET, "/users");
	    response.then().log().ifValidationFails().assertThat().statusCode(200);
		return  response.then().extract().as(Users[].class);		
	}
	
	public Users getUserById(String userId) throws JsonMappingException, JsonProcessingException {
		Response response = RestAssured.given().header("Content-Type", "application/json").request(Method.GET, "/users/"+userId);
		response.then().log().ifValidationFails().assertThat().statusCode(200);
		return  response.then().extract().as(Users.class);	
	}
	
	public Posts[] getListOfAllPosts() throws JsonMappingException, JsonProcessingException {		
		Response response = RestAssured.given().header("Content-Type", "application/json").request(Method.GET, "/posts");
		response.then().log().ifValidationFails().assertThat().statusCode(200);
		return response.then().extract().as(Posts[].class);		
	}
	
	public Posts[] getPostsByUserId(String userId) throws JsonMappingException, JsonProcessingException {
		Response response = null ;
	    response =  RestAssured.given().header("Content-Type", "application/json").request(Method.GET, "/posts?userId="+userId);		
		response.prettyPrint();
		response.then().log().ifValidationFails().assertThat().statusCode(200);
		return response.then().extract().as(Posts[].class);	
	}
	
	public Posts getPostsById(String postId) throws JsonMappingException, JsonProcessingException {		
		Response response =  RestAssured.given().header("Content-Type", "application/json").request(Method.GET, "/posts/"+postId);
		response.then().log().ifValidationFails().assertThat().statusCode(200);
		return response.then().extract().as(Posts.class);	
	}
	
	public Comments[] getCommentsByUserEmail(String email) throws JsonMappingException, JsonProcessingException {		
		Response response =  RestAssured.given().header("Content-Type", "application/json").request(Method.GET, "/comments?email="+email);
		response.then().log().ifValidationFails().assertThat().statusCode(200);
		return response.then().extract().as(Comments[].class);	
	}
	
	public Comments[] getCommentsByPostId(String postId) throws JsonMappingException, JsonProcessingException {		
		Response response =  RestAssured.given().header("Content-Type", "application/json").request(Method.GET, "/comments?postId="+postId);
		response.then().log().ifValidationFails().assertThat().statusCode(200);
		return response.then().extract().as(Comments[].class);	
	}
	
	public int createPost(String userId) throws JsonMappingException, JsonProcessingException  {
		posts = new Posts();
		posts.setUserId(Integer.parseInt(userId));
		posts.setTitle(GenericJavaMethods.getInstance().getPostTitle());
		posts.setBody(GenericJavaMethods.getInstance().getPostBody());		
		Response response =  RestAssured.given().header("Content-Type", "application/json").body(posts).request(Method.POST, "/posts");
	    response.then().log().all();
	    if(response.getStatusCode()==201) {
	    	Posts posts = response.then().extract().as(Posts.class);
			return posts.getId();
			}else {
				return 0;
			}
	}
	
	public int createComment(String userId) throws JsonMappingException, JsonProcessingException  {
		Posts[] posts = getPostsByUserId(userId);
		Users user = getUserById(userId);
		comments = new Comments();
		comments.setBody(GenericJavaMethods.getInstance().getCommentBody());
		comments.setEmail(user.getEmail());
		comments.setName(user.getName());
		comments.setPostId(posts[0].getId());
		Response response =  RestAssured.given().header("Content-Type", "application/json").body(comments).request(Method.POST, "/comments");
		response.then().log().all();
		if(response.getStatusCode()==201) {
		Comments comments= response.then().extract().as(Comments.class);;
		return comments.getId();
		}else {
			return 0;
		}

	}
	public int updatePost(String postId, String postUpdateBody) throws JsonMappingException, JsonProcessingException {
		posts = new Posts();
		Posts post = getPostsById(postId);
		posts.setUserId(post.getUserId());
		posts.setTitle(post.getTitle());
		posts.setBody(postUpdateBody);
		Response response =  RestAssured.given().header("Content-Type", "application/json").body(posts).request(Method.PUT, "/posts/"+postId);
	    response.then().log().all();
	    if(response.getStatusCode()==200) {
			Posts posts= response.then().extract().as(Posts.class);
			return posts.getId();
			}else {
				return 0;
			}
	}

}

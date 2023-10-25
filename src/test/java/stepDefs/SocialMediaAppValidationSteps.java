package stepDefs;


import java.util.ArrayList;
import java.util.List;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pojos.Comments;
import pojos.Posts;
import pojos.Users;
import org.junit.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jpmcdemo.javautil.GenericJavaMethods;
import com.jpmcdemo.test.Routing;

public class SocialMediaAppValidationSteps {
	
	Routing routing = new Routing(GenericJavaMethods.getInstance().getBaseUrl());
	int postId;
	int updatedPostId;
	int commentId;
	Posts[] posts;
	Comments[] comments;
	Users user;
	Posts post;
	List<Comments[]> listOfCommentsOnPostsOfAnUser;
	
		
    @Given("the user with userId {string} creates a post")
	public void userCreatesAPost(String userId) throws JsonMappingException, JsonProcessingException {
			 postId = routing.createPost(userId);
	}
    
    @Then("the user should receive a successful response with the ID of the new post")
	public void userShouldReceiveSuccessfulResponseWithIDOfNewPost() {
		Assert.assertNotEquals("postId is 0, post creation failed", 0, postId);
	}
    
    @When("the user with userId {string} comments on any created post")
	public void userCommentsOnAnyCreatedPost(String userId) throws JsonMappingException, JsonProcessingException {
    	commentId=routing.createComment(userId);
	}
    
    @Then("the user should receive a successful response with the ID of the new comment")
	public void userShouldReceiveSuccessfulResponseWithIDOfNewComment() {
    	Assert.assertNotEquals("commentId is 0, comment creation failed",0, commentId);
	}
    
    @When("the user updates the body as {string} of the post with postId {string}")
	public void userUpdatesTheCreatedPost(String body, String postId) throws JsonMappingException, JsonProcessingException {
    	updatedPostId = routing.updatePost(postId, body);
	}
    
    @Then("the user should receive a successful response with updated body of the created post with postId {string}")
	public void userShouldReceiveSuccessfulResponseWithUpdatedTitleAndBodyOfCreatedPost(String postId) {
		Assert.assertEquals("Post id after updating the body is not equal to given Post id",Integer.parseInt(postId), updatedPostId);
	}
    
    @Given("the user with userId {string} tries to retreive all the posts")
	public void userRetreivesAllPosts(String userId) throws JsonMappingException, JsonProcessingException {
		 posts= routing.getPostsByUserId(userId);
	}
    
    @Then("the user should receive a successful response with a list of all posts")
	public void userShouldReceiveSuccessfulResponseWithListOfAllPosts() {
		Assert.assertEquals("Posts returned for an user is not equal to the posts present on server",10, posts.length);
	}
    
    @When("the user tries to see all the comments on the posts of any other user with userId {string}")
	public void userTriesToSeeCommentsMadeByAnyUser(String userId) throws JsonMappingException, JsonProcessingException {
    	listOfCommentsOnPostsOfAnUser = new ArrayList<>();
    	posts = routing.getPostsByUserId(userId);
    	    for(Posts post : posts) {
    	    	 comments = routing.getCommentsByPostId(String.valueOf(post.getId()));
    	    	 listOfCommentsOnPostsOfAnUser.add(comments);
    	    }
	}
    
    @Then("the user should receive a successful response with a list of all comments on the posts for that user")
	public void userShouldReceiveSuccessfulResponseWithListOfAllCommentsForThatUser() {
		Assert.assertEquals("Comemnts returned for an user is not equal to the comments present on server against the posts", 50, comments.length*listOfCommentsOnPostsOfAnUser.size());		
	}
    
    @Given("an un-registered user tries to access a post")
	public void anUnRegisteredUserCreatesAPost() throws JsonMappingException, JsonProcessingException {
    	Users[] users = routing.getListOfUsers();
    	String unregisteredUserId = String.valueOf(users[users.length-1].getId()+1);
		posts = routing.getPostsByUserId(unregisteredUserId);
	}
    
    @Then("the user should not be able to access the post")
	public void userShouldNotBeAbleToCreatePost() {
			Assert.assertEquals("Un-registered user is able to access the post of any user",0, posts.length);
	}

}


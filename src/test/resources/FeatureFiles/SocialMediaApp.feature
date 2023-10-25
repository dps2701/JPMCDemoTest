Feature: Social media application

@SocialMediaAppTest
Scenario: Create a post and comment on it and then update the post and comment
Given the user with userId "5" creates a post
Then the user should receive a successful response with the ID of the new post
When the user with userId "5" comments on any created post
Then the user should receive a successful response with the ID of the new comment
When the user updates the body as "New body" of the post with postId "50"
Then the user should receive a successful response with updated body of the created post with postId "50"

@SocialMediaAppTest
Scenario: List all posts and comments for a user
Given the user with userId "6" tries to retreive all the posts
Then the user should receive a successful response with a list of all posts
When the user tries to see all the comments on the posts of any other user with userId "9"
Then the user should receive a successful response with a list of all comments on the posts for that user

@SocialMediaAppNegativeTest
Scenario: Un-registered user accessing a post
Given an un-registered user tries to access a post
Then the user should not be able to access the post

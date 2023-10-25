$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("classpath:FeatureFiles/SocialMediaApp.feature");
formatter.feature({
  "name": "Social media application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Create a post and comment on it and then update the post and comment",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SocialMediaAppTest"
    }
  ]
});
formatter.step({
  "name": "the user with userId \"5\" creates a post",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userCreatesAPost(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should receive a successful response with the ID of the new post",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userShouldReceiveSuccessfulResponseWithIDOfNewPost()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user with userId \"5\" comments on any created post",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userCommentsOnAnyCreatedPost(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should receive a successful response with the ID of the new comment",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userShouldReceiveSuccessfulResponseWithIDOfNewComment()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user updates the body as \"New body\" of the post with postId \"50\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userUpdatesTheCreatedPost(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should receive a successful response with updated body of the created post with postId \"50\"",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userShouldReceiveSuccessfulResponseWithUpdatedTitleAndBodyOfCreatedPost(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "List all posts and comments for a user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SocialMediaAppTest"
    }
  ]
});
formatter.step({
  "name": "the user with userId \"6\" tries to retreive all the posts",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userRetreivesAllPosts(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should receive a successful response with a list of all posts",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userShouldReceiveSuccessfulResponseWithListOfAllPosts()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user tries to see all the comments on the posts of any other user with userId \"9\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userTriesToSeeCommentsMadeByAnyUser(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should receive a successful response with a list of all comments on the posts for that user",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userShouldReceiveSuccessfulResponseWithListOfAllCommentsForThatUser()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Un-registered user accessing a post",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SocialMediaAppNegativeTest"
    }
  ]
});
formatter.step({
  "name": "an un-registered user tries to access a post",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.anUnRegisteredUserCreatesAPost()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user should not be able to access the post",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefs.SocialMediaAppValidationSteps.userShouldNotBeAbleToCreatePost()"
});
formatter.result({
  "status": "passed"
});
});
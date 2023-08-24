package ca.jrvs.apps.twitter.controller;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import org.junit.Test;

public class TwitterControllerTest {

  @Test
  public void postTweet() throws Exception {
    String CONSUMER_KEY="rwMczoM4f2UPnXvT5SwgWPZ7z";
    String CONSUMER_SECRET="gETJOuzYPzWQ4APLLCPtu0WX4apiORFkCAh3ObkfLGlcYdFVe2";
    String ACCESS_TOKEN="1650184222412361729-pHWqhlrGJQvwgkiZwGZBG6Im6jmT6W";
    String TOKEN_SECRET="rdHhvODdFBU8r3AZI5YoixDGMHhaq76nCuGdWGR9NW7RL";

    HttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);
    TwitterDao twitterDao = new TwitterDao(twitterHttpHelper);
    Service twitterService  = new TwitterService(twitterDao);
    Controller twitterController = new TwitterController(twitterService);
    twitterController.postTweet(new String[]{"post", "123"});
  }

  @Test
  public void deleteTweet() {
  }
}
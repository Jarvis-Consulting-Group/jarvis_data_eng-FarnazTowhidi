package ca.jrvs.apps.twitter.dao.helper;

import static org.junit.Assert.*;

import java.net.URI;
import org.junit.Test;

public class TwitterHttpHelperTest {
  private static String CONSUMER_KEY="rwMczoM4f2UPnXvT5SwgWPZ7z";
  private static String CONSUMER_SECRET="gETJOuzYPzWQ4APLLCPtu0WX4apiORFkCAh3ObkfLGlcYdFVe2";
  private static String ACCESS_TOKEN="1650184222412361729-pHWqhlrGJQvwgkiZwGZBG6Im6jmT6W";
  private static String TOKEN_SECRET="rdHhvODdFBU8r3AZI5YoixDGMHhaq76nCuGdWGR9NW7RL";



  public TwitterHttpHelperTest() throws Exception {

    TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);
    twitterHttpHelper.httpDelete(URI.create("https://api.twitter.com/2/tweets/1654542517247909890"));



  }

  @Test
  public void httpDelete() throws Exception {
    TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);
    twitterHttpHelper.httpDelete(URI.create("https://api.twitter.com/2/tweets/1654542517247909890"));

  }

  @Test
  public void httpPost() {
  }

  @Test
  public void httpGet() {
  }

  @Test
  public void testHttpDelete() {

  }
}
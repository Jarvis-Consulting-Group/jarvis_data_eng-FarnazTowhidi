package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterDaoTest extends TestCase {
  private static String CONSUMER_KEY="rwMczoM4f2UPnXvT5SwgWPZ7z";
  private static String CONSUMER_SECRET="gETJOuzYPzWQ4APLLCPtu0WX4apiORFkCAh3ObkfLGlcYdFVe2";
  private static String ACCESS_TOKEN="1650184222412361729-pHWqhlrGJQvwgkiZwGZBG6Im6jmT6W";
  private static String TOKEN_SECRET="rdHhvODdFBU8r3AZI5YoixDGMHhaq76nCuGdWGR9NW7RL";

  @Test
  public void testPostDao() throws Exception {
    TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);

    Tweet tweet = new Tweet();
    tweet.setText("Today is a test day10");
    TwitterDao twitterDao = new TwitterDao(twitterHttpHelper);
    Tweet createdTweet = twitterDao.create(tweet);
    System.out.println(createdTweet.getText());

  }
}
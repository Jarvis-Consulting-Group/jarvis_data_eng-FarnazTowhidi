package ca.jrvs.apps.twitter.example;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import java.net.URI;

public class TwitterHttpHelperTest {

  private static String CONSUMER_KEY="rwMczoM4f2UPnXvT5SwgWPZ7z";
  private static String CONSUMER_SECRET="gETJOuzYPzWQ4APLLCPtu0WX4apiORFkCAh3ObkfLGlcYdFVe2";
  private static String ACCESS_TOKEN="1650184222412361729-pHWqhlrGJQvwgkiZwGZBG6Im6jmT6W";
  private static String TOKEN_SECRET="rdHhvODdFBU8r3AZI5YoixDGMHhaq76nCuGdWGR9NW7RL";

  public static void main(String[] args) throws Exception {

    TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);
    TwitterDao twitterDao = new TwitterDao(twitterHttpHelper);

    //twitterDao.deleteById("1656045006015062017");

    twitterHttpHelper.httpPost(URI.create("https://api.twitter.com/2/tweets"), "parinazzzzz");
    //twitterHttpHelper.httpDelete(URI.create("https://api.twitter.com/2/tweets/1655583278097743876"));
  }




}
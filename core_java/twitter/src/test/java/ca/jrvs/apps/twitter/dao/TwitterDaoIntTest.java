package ca.jrvs.apps.twitter.dao;

import static org.junit.Assert.*;

import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import java.io.IOException;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwitterDaoIntTest {
  private TwitterDao twitterDao;


  @BeforeClass
  public static void beforeClass() throws Exception {

  }

  @Before
  public void setUp() throws Exception {
    String CONSUMER_KEY=System.getenv("CONSUMER_KEY");
    String CONSUMER_SECRET=System.getenv("CONSUMER_SECRET");
    String ACCESS_TOKEN=System.getenv("ACCESS_TOKEN");
    String TOKEN_SECRET=System.getenv("TOKEN_SECRET");
    System.out.println(CONSUMER_KEY + "|" + CONSUMER_SECRET + "|" + ACCESS_TOKEN + "|" + TOKEN_SECRET);

    TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);
    this.twitterDao = new TwitterDao((twitterHttpHelper));

  }

  @Test
  public void create() throws Exception {
    Tweet tweet = new Tweet();
    tweet.setText("This is a new Day");
    Tweet createTweet = twitterDao.create(tweet);
  }

  @Test
  public void deleteById() {
  }
}
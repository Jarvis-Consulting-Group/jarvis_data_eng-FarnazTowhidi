package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.entity.StringEntity;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;


public class TwitterDaoUnitTest {

  TwitterDao twitterDao;
  @Mock
  TwitterHttpHelper mockTwitterHttpHelper = mock(TwitterHttpHelper.class);
  @Mock
  HttpResponse mockHttpResponse = mock(HttpResponse.class);
  @Mock
  private StatusLine mockStatusLine = mock(StatusLine.class);
  @Mock
  private StringEntity mockStringEntity = mock(StringEntity.class);
  @Mock
  private HttpEntity mockHttpEntity = mock(HttpEntity.class);
  @Mock
  private InputStream mockInputStream = mock(InputStream.class);

  @Test
  public void testPostDao() throws Exception {

    this.twitterDao = new TwitterDao((mockTwitterHttpHelper));
    Tweet tweet = new Tweet();
    tweet.setText("Today is a test day 400");
    String tweetJason = "{\"text\": \"" + tweet.getText() + "\"}";
    StringEntity stringEntity = new StringEntity(tweetJason);

    when(mockHttpEntity.getContent()).thenReturn(stringEntity.getContent());
    when(mockHttpResponse.getEntity()).thenReturn(mockHttpEntity);
    when(mockStatusLine.getStatusCode()).thenReturn(201);
    when(mockHttpResponse.getStatusLine()).thenReturn(mockStatusLine);
    when(mockTwitterHttpHelper.httpPost(URI.create("https://api.twitter.com/2/tweets"),tweet.getText())).thenReturn(mockHttpResponse);
    Tweet postTweet = twitterDao.create(tweet);
  }
  @Test
  public void testDeleteById() throws Exception {
    //TwitterHttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);
    //TwitterDao twitterDao = new TwitterDao(twitterHttpHelper);
    //Tweet deletedTweet = twitterDao.deleteById("1659247037592764416");
    //Assert.assertNotNull(deletedTweet);
  }
}
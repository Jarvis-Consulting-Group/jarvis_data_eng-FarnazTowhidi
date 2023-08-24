package ca.jrvs.apps.twitter.example;

import com.google.gdata.util.common.base.PercentEscaper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;


public class TwitterApiTest {
//  private static String CONSUMER_KEY=System.getenv("consumerKey");
//  private static String CONSUMER_SECRET=System.getenv("consumerSecret");
//  private static String ACCESS_TOKEN=System.getenv("accessToken");
//  private static String TOKEN_SECRET=System.getenv("tokenSecret");
  private static String CONSUMER_KEY="rwMczoM4f2UPnXvT5SwgWPZ7z";
  private static String CONSUMER_SECRET="gETJOuzYPzWQ4APLLCPtu0WX4apiORFkCAh3ObkfLGlcYdFVe2";
  private static String ACCESS_TOKEN="1650184222412361729-pHWqhlrGJQvwgkiZwGZBG6Im6jmT6W";
  private static String TOKEN_SECRET="rdHhvODdFBU8r3AZI5YoixDGMHhaq76nCuGdWGR9NW7RL";

  public static void main(String[] args) throws Exception {
    //Setup OathPATH
    System.out.println(System.getenv("CONSUMER_SECRET"));

    OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

    //Create an HTTP get request
    String status = "Today is a amazing day";
    PercentEscaper percentEscaper = new PercentEscaper("", false);
    //HttpPost request = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status="+percentEscaper.escape(status));
    HttpPost request = new HttpPost("https://api.twitter.com/2/tweets");

    //HttpPost request = new HttpPost("https://api.twitter.com/2/tweets/1654237681990213632");


    consumer.sign(request);
    System.out.println("Http Request Headers:");
    Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

    HttpClient httpClient = HttpClientBuilder.create().build();
    HttpResponse response = httpClient.execute(request);

    System.out.println("Http Entity:");
    System.out.println(EntityUtils.toString(response.getEntity()));
  }
}

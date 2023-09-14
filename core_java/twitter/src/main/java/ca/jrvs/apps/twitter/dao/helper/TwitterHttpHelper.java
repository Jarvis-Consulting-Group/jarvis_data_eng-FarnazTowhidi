package ca.jrvs.apps.twitter.dao.helper;

import java.io.IOException;
import java.net.URI;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.*;
import org.apache.http.HttpResponse;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class TwitterHttpHelper implements HttpHelper {
  private final OAuthConsumer consumer;
  private final HttpClient httpClient;
/**
 * Constructor for setting up the consumer key, consumer secret, access token and token secret for
 * the OAuthConsumer object.
 * @param consumerKey consumer key. API consumer key.
 * @param consumerSecret consumer secret. API consumer secret.
 * @param accessToken access token. API access token.
 * @param tokenSecret token secret. API token secret.
 */
  public TwitterHttpHelper( String consumerKey, String consumerSecret, String accessToken, String tokenSecret ) throws Exception {
    consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
    consumer.setTokenWithSecret(accessToken,tokenSecret);
    httpClient = HttpClientBuilder.create().build();
  }

  @Override
  public HttpResponse httpPost(URI uri, String s) {
    try {
      System.out.println("Executing POST request...");
      HttpPost httpPost = new HttpPost(uri);
      if (s != null){
        httpPost.setHeader("Content-Type","application/json");
        String requestBody = "{\"text\": \"" + s + "\"}";
        httpPost.setEntity(new StringEntity(requestBody));
      }
      consumer.sign(httpPost);
      return httpClient.execute(httpPost);
    } catch (OAuthException | IOException e) {
      throw new RuntimeException("Failed to execute", e);
    }
  }

  @Override
  public HttpResponse httpGet(URI uri) {
    try {
      System.out.println("Executing GET request...");
      HttpGet httpGet = new HttpGet(uri);
      consumer.sign(httpGet);
      return httpClient.execute(httpGet);
    }
    catch (OAuthException | IOException e) {
      throw new RuntimeException("Exception Get", e);
    }
  }

  @Override
  public HttpResponse httpDelete(URI uri) {
    try {
      System.out.println("Executing DELETE request...");
      HttpDelete httpDelete = new HttpDelete(uri);
      consumer.sign(httpDelete);
      return httpClient.execute(httpDelete);
    } catch (IOException  | OAuthException  e) {
      throw new RuntimeException("Exception DELETE", e);
    }
  }
}

package ca.jrvs.apps.twitter.dao.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.*;
import org.apache.http.HttpResponse;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

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
  public HttpResponse httpPost(URI uri) {
    try {
      System.out.println("Executing POST request...");

      HttpPost httpPost = new HttpPost(uri);
      String body= "{\"text\":\"salam be royee mahe shoma\"}";
      StringEntity stringEntity = new StringEntity(body);
      httpPost.setEntity(stringEntity);
      httpPost.setHeader("Content-type", "application/json");

      consumer.sign(httpPost);
      return httpClient.execute(httpPost);
    } catch (OAuthMessageSignerException |
             OAuthExpectationFailedException |
             OAuthCommunicationException |
             IOException e) {
      throw new RuntimeException("Failed to execute", e);
    }
  }

  @Override
  public HttpResponse httpGet(URI uri) {
    return null;
  }

  @Override
  public HttpResponse httpDelete(URI uri) {
    try {
      System.out.println("Executing DELETE request...");
      HttpDelete httpDelete = new HttpDelete(uri);
      consumer.sign(httpDelete);
      return httpClient.execute(httpDelete);
    } catch (IOException  | OAuthMessageSignerException | OAuthCommunicationException | OAuthExpectationFailedException e) {
      throw new RuntimeException("Exception DELETE", e);
    }
  }
}
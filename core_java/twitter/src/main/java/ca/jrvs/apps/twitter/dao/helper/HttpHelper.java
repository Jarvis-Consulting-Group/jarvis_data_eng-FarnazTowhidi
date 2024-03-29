package ca.jrvs.apps.twitter.dao.helper;
import java.net.URI;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;

public interface HttpHelper {
  /**
   * Execute a HTTP Post call
   * @param uri
   * @return
   */
  HttpResponse httpPost(URI uri, String s)
      throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException;

  /**
   * Execute a HTTP Get call
   * @param uri
   * @return
   */
  HttpResponse httpGet(URI uri);

  /**
   * creates an httpDelete method that deletes given the Twitter v2 api
   * @param uri the uri to the delete endpoint (v2)
   * @return returns an HttpResponse after executing the request.
   */
  HttpResponse httpDelete(URI uri);


}

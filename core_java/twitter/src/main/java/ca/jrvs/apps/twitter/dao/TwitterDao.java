package ca.jrvs.apps.twitter.dao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.JsonUtil;
import java.io.IOException;
import java.net.URI;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class TwitterDao implements CrdDao<Tweet, String> {
  //Path for Post, get and delete
  private static final String API_BASE_URI="https://api.twitter.com";
  private static final String POST_PATH="/2/tweets/";
  private static final String SHOW_PATH="/2/tweets/";
  private static final String DELETE_PATH="/2/tweets/";
  //URI symbols
  private static final String QUERY_SYM = "?";
  private static final String AMPERSAND = "&";
  private static final String EQUAL = "=";
  //Response code
  private static final int HTTP_OK = 200;
  private final HttpHelper httpHelper;


  public TwitterDao(HttpHelper httpHelper) throws Exception {
    this.httpHelper = httpHelper;

  }



  @Override
  public Tweet create(Tweet entity) {
    return null;
  }


  @Override
  public Tweet findById(String s) {
    return null;
  }

  @Override
  public Tweet deleteById(String s) throws Exception {
    URI uri = URI.create(API_BASE_URI + DELETE_PATH + s);
    HttpResponse response =  httpHelper.httpDelete(uri);
    parseResponseBody(response,200);


//    catch (URISyntaxException e) {
//      throw new RuntimeException(e);
//    }

    return null;
  }

  public Tweet parseResponseBody(HttpResponse response, Integer expectedStatusCode)
      throws IOException {
    Tweet tweet = null;

    int status = response.getStatusLine().getStatusCode();
    String jsonStr = EntityUtils.toString(response.getEntity());
    System.out.println(jsonStr);
    if (status != expectedStatusCode){
      try {
        System.out.println(EntityUtils.toString(response.getEntity()));
      } catch (IOException e) {
        throw new RuntimeException("Response has no Entity",e);
      }
    }

    if (response.getEntity() == null){
      System.out.println("Empty response body");
    }

    //Convert JSON string to Tweet object
     tweet = JsonUtil.toObjectFromJson(jsonStr,Tweet.class);

    return tweet;
  }

}

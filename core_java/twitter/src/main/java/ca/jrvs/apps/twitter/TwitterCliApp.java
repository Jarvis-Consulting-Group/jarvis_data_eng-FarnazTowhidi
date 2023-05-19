package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.service.JsonUtil;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class TwitterCliApp {

  private final Controller controller;

  public TwitterCliApp(Controller controller) {
    this.controller = controller;
  }

  public static void main(String[] args) throws Exception {
    String CONSUMER_KEY="rwMczoM4f2UPnXvT5SwgWPZ7z";
    String CONSUMER_SECRET="gETJOuzYPzWQ4APLLCPtu0WX4apiORFkCAh3ObkfLGlcYdFVe2";
    String ACCESS_TOKEN="1650184222412361729-pHWqhlrGJQvwgkiZwGZBG6Im6jmT6W";
    String TOKEN_SECRET="rdHhvODdFBU8r3AZI5YoixDGMHhaq76nCuGdWGR9NW7RL";
    HttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);

    TwitterDao twitterDao = new TwitterDao(twitterHttpHelper);
    Service twitterService  = new TwitterService(twitterDao);
    Controller twitterController = new TwitterController(twitterService);
    TwitterCliApp twitterApp = new TwitterCliApp(twitterController);

    twitterApp.run(new String[]{"delete", "1659247037592764416,1656331964113207296"});
    //twitterApp.run(new String[]{"post", "test12345"});
    //twitterApp.run(new String[]{"show", "me"});
  }

  public void run(String[] args) throws Exception {
    if (args.length == 0){
      throw new IllegalArgumentException();
    }
    switch (args[0].toLowerCase()){
      case "post":
        controller.postTweet(args);
        break;
      case "show":
        controller.showTweet(args);
        break;
      case "delete":
        controller.deleteTweet(args);
    }
  }
}

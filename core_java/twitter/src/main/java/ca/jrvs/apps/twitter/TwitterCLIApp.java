package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import ca.jrvs.apps.twitter.spring.TwitterCLIBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TwitterCLIApp {

  private final Controller controller;

  public TwitterCLIApp(Controller controller) {
    this.controller = controller;
  }

  public static void main(String[] args) throws Exception {
    String CONSUMER_KEY=System.getenv("CONSUMER_KEY");
    String CONSUMER_SECRET=System.getenv("CONSUMER_SECRET");
    String ACCESS_TOKEN=System.getenv("ACCESS_TOKEN");
    String TOKEN_SECRET=System.getenv("TOKEN_SECRET");
    HttpHelper twitterHttpHelper = new TwitterHttpHelper(CONSUMER_KEY,  CONSUMER_SECRET, ACCESS_TOKEN, TOKEN_SECRET);

    TwitterDao twitterDao = new TwitterDao(twitterHttpHelper);
    Service twitterService  = new TwitterService(twitterDao);
    Controller twitterController = new TwitterController(twitterService);
    TwitterCLIApp twitterApp = new TwitterCLIApp(twitterController);

    twitterApp.run(new String[]{"post", "Twitter Test1"});
    //twitterApp.run(new String[]{"delete", "1668432514862530562,1656331964113207296"});
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

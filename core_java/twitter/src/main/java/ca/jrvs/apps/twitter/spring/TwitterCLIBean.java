package ca.jrvs.apps.twitter.spring;

import ca.jrvs.apps.twitter.TwitterCLIApp;
import ca.jrvs.apps.twitter.controller.Controller;
import ca.jrvs.apps.twitter.controller.TwitterController;
import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwitterCLIBean {

  @Bean
  public TwitterCLIApp twitterCLTApp (Controller controller) {
    return new TwitterCLIApp(controller);
  }

  @Bean
  public TwitterController controller(Service service) {
    return new TwitterController(service);
  }

  @Bean
  public TwitterService TwitterService(CrdDao dao) {
    return new TwitterService(dao);
  }

  @Bean
  public TwitterDao twitterDao (HttpHelper httpHelper) throws Exception {
    return new TwitterDao(httpHelper);
  }

  @Bean
  public TwitterHttpHelper twitterHelper () throws Exception {
    String CONSUMER_KEY=System.getenv("CONSUMER_KEY");
    String CONSUMER_SECRET=System.getenv("CONSUMER_SECRET");
    String ACCESS_TOKEN=System.getenv("ACCESS_TOKEN");
    String TOKEN_SECRET=System.getenv("TOKEN_SECRET");
    return new TwitterHttpHelper(CONSUMER_KEY,CONSUMER_SECRET,ACCESS_TOKEN,TOKEN_SECRET);
  }
}

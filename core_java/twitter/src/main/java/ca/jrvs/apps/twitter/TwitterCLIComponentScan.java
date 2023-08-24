package ca.jrvs.apps.twitter;

import ca.jrvs.apps.twitter.spring.TwitterCLIBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TwitterCLIAppIOC {

  public static void main(String[] args) throws Exception {
    ApplicationContext context = new AnnotationConfigApplicationContext(TwitterCLIBean.class);
    TwitterCLIApp app = context.getBean(TwitterCLIApp.class);
    app.run(new String[]{"post", "Today is farnaz day second"});
    app.run(new String[]{"delete", "1669700674777382915,1656331964113207296"});
  }
}

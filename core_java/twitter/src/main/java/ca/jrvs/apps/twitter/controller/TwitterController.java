package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import java.io.IOException;
import java.util.List;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

@org.springframework.stereotype.Controller
public class TwitterController implements Controller {
  private Service service;

  public TwitterController(Service service) {
    this.service = service;
  }


  @Override
  public Tweet postTweet(String[] args)
      throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
    if (args.length != 2) {
      throw new IllegalArgumentException("Illegal number of argument expected Two");
    }
    Tweet tweet = new Tweet();
    tweet.setText(args[1]);
    return service.postTweet(tweet);
  }

  @Override
  public Tweet showTweet(String[] args) throws IOException {
    if (args.length != 2) {
      throw new IllegalArgumentException("Illegal number of argument expected Two");
    }
    String ids = args[1];
    service.showTweet(ids, new String[]{"name", "username"});
    return null;
  }


  @Override
  public List<Tweet> deleteTweet(String[] args) throws Exception {
    if (args.length != 2) {
      throw new IllegalArgumentException("Illegal number of argument expected Two");
    }
    String[] ids = args[1].split(",");;
    return service.deleteTweets(ids);
  }
}

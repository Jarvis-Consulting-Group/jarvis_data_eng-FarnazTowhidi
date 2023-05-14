package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import java.io.IOException;
import java.util.List;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class TwitterService implements Service{
  private CrdDao dao;

  public TwitterService(CrdDao dao) {
    this.dao = dao;
  }

  @Override
  public Tweet postTweet(Tweet tweet) throws OAuthMessageSignerException, OAuthExpectationFailedException, IOException, OAuthCommunicationException {
    if (tweet.getText().length() > 140) {
      throw new IllegalArgumentException("Tweet text length exceeds 140 characters.");
    }
    return (Tweet) dao.create(tweet);
  }

  @Override
  public Tweet showTweet(String id, String[] fields) throws IOException {
    Tweet tweet = (Tweet) dao.findById(id);
    return null;
  }

  @Override
  public List<Tweet> deleteTweets(String[] ids) throws Exception {
    for (String id: ids){
      dao.deleteById(id);
    }
    return null;
  }

}

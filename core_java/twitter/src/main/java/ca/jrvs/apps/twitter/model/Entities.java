package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Entities {
  private List<Hashtags> hashtags;
  private List<Annotations>  annotations;
  private List<Mention>  mentions;

  public List<Hashtags> getHashtags() {
    return hashtags;
  }

  public void setHashtags(List<Hashtags> hashtags) {
    this.hashtags = hashtags;
  }

  public List<Annotations> getAnnotations() {
    return annotations;
  }

  public void setAnnotations(List<Annotations> annotations) {
    this.annotations = annotations;
  }

  public List<Mention> getMentions() {
    return mentions;
  }

  public void setMentions(List<Mention> mentions) {
    this.mentions = mentions;
  }
}

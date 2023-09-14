package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Tweet {
  private String id;
  private String text;
  private Date created_at;
  private Entities entities;


  public Entities getEntities() {
    return entities;
  }

  //private List<Entities> entities;

  public void setEntities(Entities entities) {
    this.entities = entities;
  }

  private String reply_settings;
  private String source;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Date getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }
}

package ca.jrvs.apps.twitter.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Annotations {
  private int start;
  private int end;
  private double probability;
  private String type;
  private String normalized_text;

  public int getStart() {
    return start;
  }

  public void setStart(int start) {
    this.start = start;
  }

  public int getEnd() {
    return end;
  }

  public void setEnd(int end) {
    this.end = end;
  }

  public double getProbability() {
    return probability;
  }

  public void setProbability(double probability) {
    this.probability = probability;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getNormalized_text() {
    return normalized_text;
  }

  public void setNormalized_text(String normalized_text) {
    this.normalized_text = normalized_text;
  }
}

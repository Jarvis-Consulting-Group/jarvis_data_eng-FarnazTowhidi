package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

@JsonPropertyOrder({
    "data"
})

public class Data {
  @JsonProperty("data")
  List<Tweet> data;
}

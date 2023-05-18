package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Map;

public class CompareMap {
  public static  <K,V> boolean  compareMaps(Map<K,V> m1, Map<K,V> m2){
    return (m1.equals(m2));
  }

  public static <K,V> boolean SteamApi(Map<K,V> m1, Map<K,V> m2){
    return m1.entrySet().stream().
        allMatch(e -> e.getValue().equals(m2.get(e.getKey())));
  }


  public static void main(String[] args) {
    Map<String, String> asiaCapital1 = new HashMap<String, String>();
    asiaCapital1.put("Japan", "Tokyo");
    asiaCapital1.put("South Korea", "Seoul");

    Map<String, String> asiaCapital2 = new HashMap<String, String>();
    asiaCapital2.put("South Korea", "Seoul");
    asiaCapital2.put("Japan", "Tokyo");
    System.out.println(compareMaps(asiaCapital1, asiaCapital2));
    System.out.println(SteamApi(asiaCapital1, asiaCapital2));
  }
}

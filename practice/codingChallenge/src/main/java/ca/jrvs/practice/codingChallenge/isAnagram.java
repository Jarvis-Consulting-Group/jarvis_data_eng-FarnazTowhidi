package ca.jrvs.practice.codingChallenge;

public class isAnagram {

  public static boolean isAnagram(String s, String t) {
    int[] freq = new int[26];
    for (int i = 0 ; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] != 0) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("abt", "tac"));
  }
}

package ca.jrvs.practice.codingChallenge;

public class Palindrome {
  public boolean isPalindrome(int x) {
    String s = String.valueOf(x);
    int n= s.length();
    for (int i=0; i<n/2; i++) {
      if (s.charAt(i)!=s.charAt(n-i-1)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Palindrome palindrome = new Palindrome();
    System.out.println(palindrome.isPalindrome(121));
  }
}

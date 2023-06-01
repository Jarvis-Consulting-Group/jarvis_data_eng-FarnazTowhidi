package ca.jrvs.practice.codingChallenge;
/*
Lettcode 65: Valid Number
https://leetcode.com/problems/valid-number/
 */

public class StringContainOnlyDigits {

  public static boolean OnlyDigit(String s) {
    for (int i=0; i<s.length(); i++) {
      if (s.charAt(i) < '0' || s.charAt(i) > '9')
        return false;
    }
    return true;
  }

  public static boolean IsDigit(String s) {
    for (int i=0; i<s.length(); i++) {
      System.out.println(s.charAt(i));
      if (!Character.isDigit(s.charAt(i)))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(IsDigit("111"));
  }
}


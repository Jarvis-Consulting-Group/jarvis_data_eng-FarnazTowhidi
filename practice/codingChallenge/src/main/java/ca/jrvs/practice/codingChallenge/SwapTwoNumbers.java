package ca.jrvs.practice.codingChallenge;

public class SwapTwoNumbers {
  public static void main (String[] a) {
    int x = 50;
    int y = 10;
    x = x + y;
    y = x - y;
    x = x - y;
    System.out.println("After swaping:" + " x = " + x + ", y = " + y);
  }
}

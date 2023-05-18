package ca.jrvs.practice.codingChallenge;

public class Fibonacci {
  private static long[] fiboCash;

  public static void main(String[] args) {
    int n= 10;
    fiboCash = new long[n+1];

    //System.out.println (fibonachi(n));
    fibonacciDynamicProgramming(n);
    for (int i=0; i<n; i++) {
      System.out.print(fiboCash[i] + " ");
    }


  }

  private static long fibonacciDynamicProgramming(int n) {
    if (n<=1) return n;

    if (fiboCash[n] != 0) {
      return fiboCash[n];
    }
    fiboCash[n]= fibonacciDynamicProgramming(n-1) + fibonacciDynamicProgramming(n-2);
    return fiboCash[n];
  }

  private static long fibonachi(int n) {
    if (n<=1) return n;
    return (fibonachi (n-1) + fibonachi(n-2));
  }

}

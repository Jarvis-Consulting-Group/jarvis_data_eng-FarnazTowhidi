package ca.jrvs.practice.codingChallenge;
import java.util.Scanner;

public class EvenOdd {
  public String EvenOddFunction(int number){
    if (number%2==0) {
      return ("even");
    }
    else {
      return ("odd");
    }
  }

  public static void main(String[] args) {
    EvenOdd evenOdd = new EvenOdd();
    System.out.println(evenOdd.EvenOddFunction(141));
  }
}

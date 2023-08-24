package ca.jrvs.practice.codingChallenge;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvenOddTest {

  @Test
  public void EvenoddTest() {
    EvenOdd evenOdd = new EvenOdd();
    assertEquals("even", evenOdd.EvenOddFunction(14));
    assertEquals("odd", evenOdd.EvenOddFunction(111));
  }
}
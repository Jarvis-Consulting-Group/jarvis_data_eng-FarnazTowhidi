package ca.jrvs.practice.codingChallenge;

import java.util.Stack;

public class IsValidParantesisSolution {

  public boolean isValid(String s) {

    Stack<Character> stackTemp = new Stack<>();

    for (int i=0; i<s.length(); i++) {
      char a = s.charAt(i);
      if (a=='(' || a=='{' || a=='[') stackTemp.push(a);
      else if (a==')' && stackTemp.pop()!='(') return false;
      else if (a=='}' && stackTemp.pop()!='{') return false;
      else if (a==']' && stackTemp.pop()!='[') return false;
    }
    return stackTemp.empty();
  }

  public static void main(String[] args) {
    IsValidParantesisSolution isValidParantesisSolution = new IsValidParantesisSolution();
    System.out.println(isValidParantesisSolution.isValid("([)"));
  }
}

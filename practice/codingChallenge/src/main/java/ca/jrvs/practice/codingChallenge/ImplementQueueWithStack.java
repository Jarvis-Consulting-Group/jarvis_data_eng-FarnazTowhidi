package ca.jrvs.practice.codingChallenge;
import java.util.Stack;
/*
Leetcode 232: Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/
*/
public class ImplementQueueWithStack {
  Stack<Integer> input = new Stack<>();
  Stack<Integer> output = new Stack<>();

  public void push(int x) {
    input.push(x);
  }

  public void pop() {
    peek();
    output.pop();
  }

  public Integer peek() {
    if (output.empty())
      while (!input.empty())
        output.push(input.pop());
    return output.peek();
  }

  public boolean empty() {
    return input.empty() && output.empty();
  }

}

package ca.jrvs.practice.codingChallenge;
import java.util.LinkedList;
import java.util.Queue;
/*
LeetCode 225: Implement Stack using Queues
https://leetcode.com/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingQueue {
  private Queue<Integer> queue = new LinkedList<>();

  public void push(int x) {
    queue.add(x);
    for (int i=1; i<queue.size(); i++)
      queue.add(queue.remove());
  }

  public void pop() {
    queue.remove();
  }

  public int top() {
    return queue.peek();
  }

  public boolean empty() {
    return queue.isEmpty();
  }
}

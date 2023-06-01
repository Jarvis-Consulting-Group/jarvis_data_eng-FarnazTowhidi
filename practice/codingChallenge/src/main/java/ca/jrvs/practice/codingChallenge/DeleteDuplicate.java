package ca.jrvs.practice.codingChallenge;

public class DeleteDuplicate {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode temp = head;
    while (temp != null && temp.next != null)
    {
      if (temp.next.val==temp.val)
      {
        temp.next=temp.next.next;
        continue;
      }
      temp=temp.next;
    }
    return head;
  }
}

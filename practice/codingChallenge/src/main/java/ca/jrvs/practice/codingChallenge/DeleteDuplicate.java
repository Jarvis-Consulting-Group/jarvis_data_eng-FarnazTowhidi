package ca.jrvs.practice.codingChallenge;
/*
Leetcode 83: Remove Duplicates from Sorted List
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
*/
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

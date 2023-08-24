package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;

/*
Leetcode 217: Contains Duplicate
https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {
  public boolean Solution(int[] nums) {
    HashSet<Integer> hset = new HashSet<Integer>();
    for (int idx = 0; idx < nums.length; idx ++){
      if (hset.contains(nums[idx])){
        return true;
      }
      hset.add(nums[idx]);
    }
    return false;
  }
}

/*
Leetcode 70: Climbing Stairs
https://leetcode.com/problems/climbing-stairs/
*/

class Solution {
  public int climbStairs(int n) {
    if (n==0) return 0;
    else if (n==1) return 1;
    else if (n==2) return 2;
    return climbStairs(n-1) + climbStairs (n-2);
  }

  public int climbStairs_DP(int n) {
    if (n==1) return 1;
    if (n==2) return 2;

    int[] da = new int[n];
    da[0] = 1;
    da[1] = 2;
    for (int i=2; i<n; i++) {
      da[i] = da[i-1] + da[i-2];
    }
    return da[n-1];
  }
}
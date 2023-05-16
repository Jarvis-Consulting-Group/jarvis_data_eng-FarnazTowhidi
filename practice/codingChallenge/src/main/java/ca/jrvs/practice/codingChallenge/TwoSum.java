package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
  public int[] TwoSumFunction(int[] nums, int target) {

    for (int i=0; i<nums.length; i++) {
      System.out.println("numi:" + nums[i]);
      for (int j=i+1; j<nums.length; j++) {
        System.out.println("numj:" + nums[j]);

        if(nums[i] + nums[j] == target) {
          System.out.println("First number index:" + i  );
          System.out.println("Second number index:" + j  );
          return new int[]{i,j};
        }
      }
    }
    return null;

  }

  public int[] TwoSumMap(int[] nums, int target) {
    Map<Integer,Integer> numMap = new HashMap<>();
    for (int i =0; i<nums.length; i++) {
      numMap.put(target-nums[i],0);
    }
    System.out.println(numMap);
    return new int[] {};
  }


  public static void main(String[] args) {
    int[] nums = {0,1,2,3};
    TwoSum twoSum = new TwoSum();
    //int[] outputPair = twoSum.TwoSumFunction(nums,3);
    int[] outputPair1 = twoSum.TwoSumMap(nums,3);
    System.out.println(Arrays.toString(outputPair1));
  }

}

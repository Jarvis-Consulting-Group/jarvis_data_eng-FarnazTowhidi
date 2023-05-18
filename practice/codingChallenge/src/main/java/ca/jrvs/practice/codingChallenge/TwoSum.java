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

  public int[] TwoSumMap(int[] numbers, int target) {

    HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
    for(int i = 0; i < numbers.length; i++){

      Integer diff = (Integer)(target - numbers[i]);
      if(hash.containsKey(diff)){
        int toReturn[] = {hash.get(diff), i};
        //System.out.println(hash.get(1));
        return toReturn;
      }
      System.out.println("number: " + numbers[i]);
      hash.put(numbers[i], i);
    }
    return null;
  }


  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    TwoSum twoSum = new TwoSum();
    //int[] outputPair = twoSum.TwoSumFunction(nums,3);
    int[] outputPair1 = twoSum.TwoSumMap(nums,5);
    System.out.println(Arrays.toString(outputPair1));
  }

}

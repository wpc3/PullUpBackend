package org.example;

import java.util.ArrayList;
import java.util.List;

public class TwoSum {
/**
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.



            Example 1:

    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:

    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    Example 3:

    Input: nums = [3,3], target = 6
    Output: [0,1]
*/
    public int[] twoSum(int[] nums, int target) {

        List<Integer> answer = new ArrayList<>();

        for(int i =0; i<nums.length; i++){
            if(nums[i] + nums[i+1] == target){
                answer.add(i);
                answer.add(i+1);
            }
//            for(int j = 0; j<nums.length-1; j++){
//                if(nums[i] + nums[j] == target){
//                    answer.add(i);
//                    answer.add(j);
//                }
//            }

        }
      int [] newAnswer = new int[answer.size()];
        for (int i =0; i<answer.size(); i++){
            newAnswer[i] = answer.get(i);
        }

    return newAnswer ;

    }
}

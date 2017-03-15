package RandomPickIndex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


/**
 * 398. Random Pick Index 
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 * Note
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 * Example:
 * int[] nums = new int[] {1,2,3,3,3}
 * Solution solution = new Solution(nums);
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning
 * solution.pick(3);
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1
 * solution.pick(1);
 * 
 * 先找到所有Target的下标存到list，然后再用随机数取list其中一个返回
 * @author CLara1
 *
 */
public class Solution {
	
	public int[] nums;
	
	public Solution(int[] nums) {
        this.nums=nums;
    }
    
    public int pick(int target) {
        List<Integer> list=new ArrayList<Integer>();
       // System.out.println(nums[0]);
        for(int i=0;i<nums.length;i++){
        	if(nums[i]==target){
        		list.add(i);
        	}
        }
        //Collections.shuffle(list);
        Random r=new Random();
        
        
        return list.get(r.nextInt(list.size()));
    }
    
    
    
    public static void main(String[] args){
    	int[] nums = new int[] {1,2,3,3,3};
    	Solution solution = new Solution(nums);

    	// pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
    	int result=solution.pick(3);
    	System.out.println(result);

    	// pick(1) should return 0. Since in the array only nums[0] is equal to 1.
    	result=solution.pick(1);
    	System.out.println(result);
    }
}

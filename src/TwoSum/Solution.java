package TwoSum;

import java.util.Scanner;
/*
 * [Title]:Two Sum
 * 
 * [Description]:
 * Given an array of integers, 
 * return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 * 
 * [Example]:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {
	public static int[] twoSum(int[] nums, int target) {
		int[] num = new int[2];
		for(int i=0;i<nums.length-1;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[j]==target-nums[i]){
					num[0]=i;
					num[1]=j;
					break;
				}
			}
		}
		return num;
    }
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		
		int n=in.nextInt();
		int[] nums=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=in.nextInt();
		}
		int target=in.nextInt();
		int[] result=twoSum(nums,target);
		
		System.out.println(result[0]+" "+result[1]);
	}
}

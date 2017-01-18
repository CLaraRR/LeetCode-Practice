package ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
/*
 * [Title]:3Sum
 * 
 * [Description]:Given an array S of n integers, 
 * are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * 
 * [Example]:For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 * 
 * [Note]:�ȶ�list����������������֮�����ǾͿ��Զ�����������ָ��ֱ��ǰ���������м�ɨ���ˣ�
 * ����� 2Sum�������ҵ�����ָ��֮��Ϊtarget��OK�ˣ�
 * �� 3Sum ���ƣ����ǿ����ȹ̶�һ������Ȼ��������������֮��Ϊ��һ�������෴���Ϳ����ˡ�
 */
public class Solution {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> resultList=new ArrayList<List<Integer>>();
		if(nums==null||nums.length<3)
			return resultList;
		Arrays.sort(nums);
		int length=nums.length;
		for(int i=0;i<length-2;i++){
			if(i>0&&nums[i]==nums[i-1])
				continue;
			int begin=i+1;
			int end=length-1;
			while(begin<end){
				if(nums[begin]+nums[end]+nums[i]==0){
					List<Integer> res=new ArrayList<Integer>();
				    res.add(nums[i]);
				    res.add(nums[begin]);
				    res.add(nums[end]);
				    resultList.add(res);
				    
				    while(begin<end&&nums[begin]==nums[begin+1])
				    	begin++;
				    while(begin<end&&nums[end]==nums[end-1])
				    	end--;
				    
				    begin++;
				    end--;
				
				}
				else if(nums[begin]+nums[end]+nums[i]<0)
					begin++;
				else
					end--;
			}
			
		}
		return resultList;
        
    }
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		//int n=in.nextInt();
		
		String line=in.nextLine();
		String numstr[]=line.split(",");
		int nums[]=new int[numstr.length];
		for(int i=0;i<numstr.length;i++){
			nums[i]=Integer.parseInt(numstr[i]);
		}
		
		List<List<Integer>> resultList=threeSum(nums);
		System.out.println(resultList);
	}

}

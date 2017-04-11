package triangle;

import java.util.ArrayList;

public class Solution {
	 public static int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	      
		 int size=triangle.size();
		 int[] sum=new int[size];
		 for(int i=0;i<triangle.get(size-1).size();i++){
			 sum[i]=triangle.get(size-1).get(i);
		 }
		 
		 for(int i=size-2;i>=0;i--){
			 for(int j=0;j<triangle.get(i).size();j++){
				 sum[j]=triangle.get(i).get(j)+Math.min(sum[j], sum[j+1]);
			 }
		 }
		 return sum[0];
	 }
	 
	 public static void main(String[] args){
		 ArrayList<Integer> intList1=new ArrayList<Integer>();
		 ArrayList<Integer> intList2=new ArrayList<Integer>();
		 ArrayList<Integer> intList3=new ArrayList<Integer>();
		 ArrayList<Integer> intList4=new ArrayList<Integer>();
		 
		 ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
		 
		 intList1.add(2);
		 
		 intList2.add(3);
		 intList2.add(4);
		 
		 intList3.add(6);
		 intList3.add(5);
		 intList3.add(7);
		 
		 intList4.add(4);
		 intList4.add(1);
		 intList4.add(8);
		 intList4.add(3);
		 
		 triangle.add(intList1);
		 triangle.add(intList2);
		 triangle.add(intList3);
		 triangle.add(intList4);
		 
		 int result=minimumTotal(triangle);
		 System.out.println(result);
		 
	 }

}

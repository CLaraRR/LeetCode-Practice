package pascalstriangle;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> getRow(int rowIndex) {
		rowIndex+=1;
		int num[][]=new int[rowIndex][rowIndex];  
        for(int i=0;i<rowIndex;i++)  
        {  
            num[i][0]=num[i][i]=1;  
            for(int j=1;j<i;j++)  
            {  
                num[i][j]=num[i-1][j-1]+num[i-1][j];  
            }  
        }  
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<rowIndex;i++){
        	list.add(num[rowIndex-1][i]);
        }
        return list;
    }
	
	public static void main(String[] args){
		int n=3;
		ArrayList<Integer> list=getRow(n);
		System.out.println(list);
	}
}

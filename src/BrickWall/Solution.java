package BrickWall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * 554. Brick Wall 
 * Difficulty: Medium
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * Example
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 * 
 * 
 * Note:
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 * 
 * 
 * @author CLara1
 *
 */
public class Solution {

	//如果能够同时go through说明每一层左边的和是相等的，图中go through的位置和为4，第2、3、5、6层的均满足，
	//而brick总共6层，于是最少穿过的brick为2层。
	//于是想到出现同一个和的个数越多，即满足穿过的brick越少。
	//用一个map来统计即可。
	public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer> sumTable=new HashMap<Integer,Integer>();
        int count=0;
        for(int i=0;i<wall.size();i++){//要排除每一层的个数都为1的情况，此时要返回高度
        	if(wall.get(i).size()==1)
        		count++;
        }
        if(count==wall.size())
        	return wall.size();
        
        for(int i=0;i<wall.size();i++){
        	int sum=0;
        	for(int j=0;j<wall.get(i).size()-1;j++){//倒数第一个结束
        		sum+=wall.get(i).get(j);
        		if(sumTable.containsKey(sum)){
        			int num=sumTable.get(sum);
        			sumTable.put(sum, ++num);
        		}else{
        			sumTable.put(sum, 1);
        		}
        		
        	}
        }
        
        int maxAppear=0;
        Iterator<Integer> it=sumTable.keySet().iterator();
        while(it.hasNext()){
        	int appear=sumTable.get(it.next());
        	maxAppear=Math.max(maxAppear, appear);
        }
        
        return wall.size()-maxAppear;
        
	}
	
	public static void main(String[] agrs){
		List<Integer> row1=new ArrayList<Integer>();
		List<Integer> row2=new ArrayList<Integer>();
		List<Integer> row3=new ArrayList<Integer>();
		List<Integer> row4=new ArrayList<Integer>();
		List<Integer> row5=new ArrayList<Integer>();
		List<Integer> row6=new ArrayList<Integer>();
		
		List<List<Integer>> wall=new ArrayList<List<Integer>>();
		row1.add(1);
		row1.add(2);
		row1.add(2);
		row1.add(1);
		wall.add(row1);
		
		row2.add(3);
		row2.add(1);
		row2.add(2);
		wall.add(row2);
		
		row3.add(1);
		row3.add(3);
		row3.add(2);
		wall.add(row3);
		
		row4.add(2);
		row4.add(4);
		wall.add(row4);
		
		row5.add(3);
		row5.add(1);
		row5.add(2);
		wall.add(row5);
		
		row6.add(1);
		row6.add(3);
		row6.add(1);
		row6.add(1);
		wall.add(row6);
		
//		row1.add(100000000);
//		row2.add(100000000);
//		row3.add(100000000);
//		wall.add(row1);
//		wall.add(row2);
//		wall.add(row3);

		
		int result=leastBricks(wall);
		System.out.println(result);
		
		
	}
}

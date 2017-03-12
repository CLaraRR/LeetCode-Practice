package EliminationGame;

/**
 * 390. Elimination Game 
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 * Find the last number that remains starting with a list of length n.
 * Example:
 * Input
 * n = 9
 * 1 2 3 4 5 6 7 8 
 * 2 4 6 8
 * 2 6
 * 6
 * 
 * Output
 * 6
 * 
 * 
 * 思路：每次记录删除完一遍后剩下序列的首尾两项，当然每次的删除方向和跳动距离也要不停更新
 * 每次判断start和end除以jump 的余数是否等于起始项对应的余数，判断是否保留或跳动。
 * 其实自己举几个例子就会发现，只有首尾两项的余数相等的时候才会都被删除，否则只有起始项删除。
 * 最后剩下的start和end相等，就是我们要找的值。 
 * 这里之所以这么判断，是在另一个层面观察的结果。
 * 因为从删除的那一项开始，删除的数都是跟他对于jump 有同样余数的数
 * 所以这就是为什么判断余数来看下次的起始项。
 * @author CLara1
 *
 */
public class Solution {
	public static int lastRemaining(int n) {
		int jump=2;//每次循环要间隔的个数
		Boolean flag=true;//标记是从左到右还是从右到左
		int start=1;
		int end=n;
		while(start<end){
			int r=(flag?start:end)%jump;
			if(start%jump==r)
				start+=jump/2;
			if(end%jump==r)
				end-=jump/2;
			flag=!flag;
			jump*=2;
		}
		return start;
	}

	public static void main(String[] args){
		int number=lastRemaining(100000000);
		System.out.println(number);
	}
}

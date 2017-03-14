package RotateFunction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * 396. Rotate Function 
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * Note
 * n is guaranteed to be less than 105.
 * Example:
 * A = [4, 3, 2, 6]
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 2
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 1
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 2
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * 
 * 思路：刚开始做这道题的时候我就想这么简单它的难度怎么会是medium呢？直接用两个循环暴力算出来就好了啊
 * 事实证明我错了。。。这种做法会超时，时间复杂度为O(n^2)
 * 后来参考网上的做法，时间复杂度为O(n)
 * 只要推一下它的规律就可以了，很神奇
 * 我们观察一下上面的例子哈，F(0)和F(1)，可能写成这样子会直观一点：
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6)
 * F(1) = (1 * 4) + (2 * 3) + (3 * 2) + (0 * 6) 
 * 是不是发现了一些什么~~
 * 除了最后一位元素，所有元素的权重值都加了1，也就是和多加了A[0]+A[1]+...+A[N-2]
 * 对于最后一个元素，他的权重值从n-1变成了0，也就是减去了(N-1)*A[N-1]
 * 所以得到的规律就是：
 * F(k)=F(k-1)+(A[0]+A[1]+...+A[N-2]-(N-1)*A[N-1])
 *     =F(k-1)+(sum(A)-A[N-1]-(N-1)*A[N-1])
 * 因此，每顺时针移动一位，只需要进行一次计算就好。
 * @author CLara1
 *
 */

public class Solution {
	public static int maxRotateFunction(int[] A) {
		if(A.length<=1)
			return 0;
		int sum=0;
		int max=Integer.MIN_VALUE;
		int f=0;
		int len=A.length;
		for(int i=0;i<len;i++){
			sum+=A[i];
			f+=i*A[i];
		}
		
		max=Math.max(max, f);
		
		for(int i=1;i<len;i++){
			f=f+sum-A[len-i]-(len-1)*A[len-i];
			max=Math.max(max, f);
		}
		
		return max;
		
    }
	
	public static void main(String[] args){
		int[] A={-2147483648,-2147483648};
		int sum=maxRotateFunction(A);
		System.out.println(sum);
	}
}

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
 * ˼·���տ�ʼ��������ʱ���Ҿ�����ô�������Ѷ���ô����medium�أ�ֱ��������ѭ������������ͺ��˰�
 * ��ʵ֤���Ҵ��ˡ��������������ᳬʱ��ʱ�临�Ӷ�ΪO(n^2)
 * �����ο����ϵ�������ʱ�临�Ӷ�ΪO(n)
 * ֻҪ��һ�����Ĺ��ɾͿ����ˣ�������
 * ���ǹ۲�һ����������ӹ���F(0)��F(1)������д�������ӻ�ֱ��һ�㣺
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6)
 * F(1) = (1 * 4) + (2 * 3) + (3 * 2) + (0 * 6) 
 * �ǲ��Ƿ�����һЩʲô~~
 * �������һλԪ�أ�����Ԫ�ص�Ȩ��ֵ������1��Ҳ���ǺͶ����A[0]+A[1]+...+A[N-2]
 * �������һ��Ԫ�أ�����Ȩ��ֵ��n-1�����0��Ҳ���Ǽ�ȥ��(N-1)*A[N-1]
 * ���Եõ��Ĺ��ɾ��ǣ�
 * F(k)=F(k-1)+(A[0]+A[1]+...+A[N-2]-(N-1)*A[N-1])
 *     =F(k-1)+(sum(A)-A[N-1]-(N-1)*A[N-1])
 * ��ˣ�ÿ˳ʱ���ƶ�һλ��ֻ��Ҫ����һ�μ���ͺá�
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

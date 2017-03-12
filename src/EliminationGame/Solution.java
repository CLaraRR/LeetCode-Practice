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
 * ˼·��ÿ�μ�¼ɾ����һ���ʣ�����е���β�����Ȼÿ�ε�ɾ���������������ҲҪ��ͣ����
 * ÿ���ж�start��end����jump �������Ƿ������ʼ���Ӧ���������ж��Ƿ�����������
 * ��ʵ�Լ��ټ������Ӿͻᷢ�֣�ֻ����β�����������ȵ�ʱ��Żᶼ��ɾ��������ֻ����ʼ��ɾ����
 * ���ʣ�µ�start��end��ȣ���������Ҫ�ҵ�ֵ�� 
 * ����֮������ô�жϣ�������һ������۲�Ľ����
 * ��Ϊ��ɾ������һ�ʼ��ɾ���������Ǹ�������jump ��ͬ����������
 * ���������Ϊʲô�ж����������´ε���ʼ�
 * @author CLara1
 *
 */
public class Solution {
	public static int lastRemaining(int n) {
		int jump=2;//ÿ��ѭ��Ҫ����ĸ���
		Boolean flag=true;//����Ǵ����һ��Ǵ��ҵ���
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

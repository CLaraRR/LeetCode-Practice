package AddTwoNumbersII;

import java.util.Stack;

/**
 * [Title]:Add Two Numbers II
 * 
 * [Description]:You are given two non-empty linked lists 
 * representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes 
 * contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, 
 * except the number 0 itself.
 * Follow up:
 * What if you cannot modify the input lists? In other words, 
 * reversing the lists is not allowed.
 * 
 * [Example]:Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 * 
 * [Note]:use Stack
 * @author CLara1
 *
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode resultList=null;
		
		Stack<Integer> stack1=new Stack<Integer>();
		Stack<Integer> stack2=new Stack<Integer>();
		ListNode p=l1;
		ListNode q=l2;
		while(p!=null||q!=null){
			if(p!=null){
				stack1.push(p.val);
				p=p.next;
			}
			if(q!=null){
				stack2.push(q.val);
				q=q.next;
			}
		}
		int jinwei=0;
		while(!stack1.empty()||!stack2.empty()){
			int x=(stack1.empty())?0:stack1.pop();
			int y=(stack2.empty())?0:stack2.pop();
			
			int sum=jinwei+x+y;
			
			jinwei=sum/10;
			int yushu=sum%10;
			
			ListNode temp=new ListNode(yushu);
			temp.next=resultList;
			resultList=temp;
		}
		
		if(jinwei>0){
			ListNode temp=new ListNode(jinwei);
			temp.next=resultList;
			resultList=temp;
		}
		
		
		return resultList;
        
    }
	
	
	public static void main(String[] args){
		Solution test=new Solution();
		Solution.ListNode l1=test.new ListNode(7);
		Solution.ListNode l11=l1;
		l1.next=test.new ListNode(2);
		l1=l1.next;
		l1.next=test.new ListNode(4);
		l1=l1.next;
		l1.next=test.new ListNode(3);
		l1=l1.next;
		
		Solution.ListNode l2=test.new ListNode(5);
		Solution.ListNode l22=l2;
		l2.next=test.new ListNode(6);
		l2=l2.next;
		l2.next=test.new ListNode(4);
		l2=l2.next;
		
		Solution.ListNode resultList=test.addTwoNumbers(l11, l22);
		Solution.ListNode rr=resultList;
		while(rr!=null){
			System.out.print(rr.val+" ");
			rr=rr.next;
		}
		
		
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { 
			val = x; 
			}
		}
}

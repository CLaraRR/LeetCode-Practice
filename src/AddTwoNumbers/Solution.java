package AddTwoNumbers;
/**
 * [Title]:Add Two Numbers
 * 
 * [Description]:You are given two non-empty linked lists representing 
 * two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain 
 * a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero,
 *  except the number 0 itself.
 *  
 * [Example]:Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  
 * @author CLara1
 *
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode resultList=new ListNode(0);
		 ListNode rr=resultList;
		 ListNode p=l1;
		 ListNode q=l2;
		 int jinwei=0;
		 while(p!=null||q!=null){
			 
			 int x=(p!=null)?p.val:0;
			 int y=(q!=null)?q.val:0;
			 int sum=jinwei+x+y;
			 jinwei=sum/10;
			 int yushu=sum%10;
			 resultList.next=new ListNode(yushu);
			 resultList=resultList.next;
			 if(p!=null) p=p.next;
			 if(q!=null) q=q.next;
			 
			 
		 }
		 if(jinwei>0){
			 resultList.next=new ListNode(jinwei);
		 }
		 return rr.next;
		
	        
	 }
	 
	 
	 public static void main(String[] args){
		// Scanner in=new Scanner(System.in);
		 Solution test=new Solution();
		 Solution.ListNode l1=test.new ListNode(2);
		 Solution.ListNode l11=l1;
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
		 
		 Solution.ListNode resultList=test.addTwoNumbers(l11,l22);
		 Solution.ListNode rr=resultList;
		 while(rr!=null){
			 System.out.print(rr.val+" ");
			 rr=rr.next;
		 }
			 
		 
	 }
	 
	 
	 public class ListNode {
		 int val;
		 ListNode next;
		 ListNode(int x){ 
			 val = x;
			 }
		 }

}

package NextGreaterElementIII;


/**
 * 556. Next Greater Element III
 * Given a positive 32-bit integer n, 
 * you need to find the smallest 32-bit integer 
 * which has exactly the same digits existing in the integer n and is greater 
 * in value than n. If no such positive 32-bit integer exists,
 *  you need to return -1.
 * Example 1:
 * Input: 12
 * Output: 21
 * 
 * Example 2:
 * Input: 21
 * Output: -1
 * 
 * 如果从数字的第k位开始到数字尾部都是递减的并且第k位数字比第k-1位数字大，
 * 表明从第k位开始到尾部的这段数字是他们能组合出的最大数字，
 * 在下一个数字中他们要整体倒序变为能组合出的最小数字，
 * 倒序后从这段数字序列中找出第一个大于第k-1位数字的位置和第k-1位交换即可。
 * 举个栗子，如果n=13452，其中52是递减的，而且5>4，这样我们先把52倒序，n就变为13425，
 * 然后从25中找出第一个大于4的数字和4交换，就得到了最终结果13524。
 * 需要注意的是下一个数字可能会超出INT_MAX范围。
 * @author CLara1
 *
 */
public class Solution {
	public int nextGreaterElement(int n) {

		String str=String.valueOf(n);
		int i=str.length()-1;
		while(i>0&&str.charAt(i)<=str.charAt(i-1)){
			i--;
		}
		if(i==0){
			return -1;
		}
		
		StringBuffer s2=new StringBuffer();
		for(int j=i;j<str.length();j++){
			s2.append(str.charAt(j));
		}
		s2=s2.reverse();

		StringBuffer ss=new StringBuffer();
		for(int j=0;j<i;j++){
			ss.append(str.charAt(j));
		}

		for(int j=0;j<s2.length();j++){
			if(s2.charAt(j)>ss.charAt(ss.length()-1)){
				char temp=ss.charAt(ss.length()-1);
				ss.setCharAt(ss.length()-1, s2.charAt(j));
				s2.setCharAt(j, temp);
				break;
			}
		}
		
		ss.append(s2);
		if(ss.length()>=10&&ss.toString().compareTo(String.valueOf(Integer.MAX_VALUE))>0){
			return -1;
		}
		return Integer.parseInt(ss.toString());
        
       
    }
	
	public static void main(String[] args){
		int n=1999999999;
		int r=new Solution().nextGreaterElement(n);
		System.out.println(r);
	}
}

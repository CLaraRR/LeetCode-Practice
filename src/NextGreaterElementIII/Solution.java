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
 * ��������ֵĵ�kλ��ʼ������β�����ǵݼ��Ĳ��ҵ�kλ���ֱȵ�k-1λ���ִ�
 * �����ӵ�kλ��ʼ��β���������������������ϳ���������֣�
 * ����һ������������Ҫ���嵹���Ϊ����ϳ�����С���֣�
 * ��������������������ҳ���һ�����ڵ�k-1λ���ֵ�λ�ú͵�k-1λ�������ɡ�
 * �ٸ����ӣ����n=13452������52�ǵݼ��ģ�����5>4�����������Ȱ�52����n�ͱ�Ϊ13425��
 * Ȼ���25���ҳ���һ������4�����ֺ�4�������͵õ������ս��13524��
 * ��Ҫע�������һ�����ֿ��ܻᳬ��INT_MAX��Χ��
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

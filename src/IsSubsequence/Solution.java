package IsSubsequence;


/**
 * 392.Is Subsequence
 * Given a string s and a string t, check if s is subsequence of t.
 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
 * 
 * Example 1
 * s = "abc", t = "ahbgdc"
 * Return true.
 * Example 2
 * s = "axc", t = "ahbgdc"
 * Return false.
 * 
 * ˼·���������ң�����һ���ַ���t�е�λ��һ��Ҫ����ǰһ���ַ���t�е�λ�ã�
 * ���С�ڵĻ��������ң�����Ҳ�����˵�����ַ���t�в����ڣ�ֱ�ӷ���false
 * @author CLara1
 *
 */
public class Solution {
	public static boolean isSubsequence(String s, String t) {
        if(s==null){
        	return false;
        }
        
        int lastIndex=-1;//��¼ǰһ���ַ���t�г��ֵ�λ��
        for(int i=0;i<s.length();i++){
        	int j;
        	for(j=0;j<t.length();j++){
        		if(s.charAt(i)==t.charAt(j)&&j>lastIndex){
        			lastIndex=j;
        			break;
        		}
        	}
        	if(j==t.length()){
        		return false;
        	}
        }
        return true;
        
    }
	
	public static void main(String[] args){
		String s="abc";
		String t="acbqaptbc";
		Boolean flag=isSubsequence(s,t);
		System.out.println(flag);
	}
}

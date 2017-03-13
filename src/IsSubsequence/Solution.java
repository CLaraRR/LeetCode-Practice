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
 * 思路：从左到右找，后面一个字符在t中的位置一定要大于前一个字符在t中的位置，
 * 如果小于的话，继续找，如果找不到就说明该字符在t中不存在，直接返回false
 * @author CLara1
 *
 */
public class Solution {
	public static boolean isSubsequence(String s, String t) {
        if(s==null){
        	return false;
        }
        
        int lastIndex=-1;//记录前一个字符在t中出现的位置
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

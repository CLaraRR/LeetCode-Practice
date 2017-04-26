package LongestUncommonSubsequenceI;
/**
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.

A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.

The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
Input: "aba", "cdc"
Output: 3
Explanation: The longest uncommon subsequence is "aba" (or "cdc"), 
because "aba" is a subsequence of "aba", 
but not a subsequence of any other strings in the group of two strings. 
Note:

Both strings' lengths will not exceed 100.
Only letters from a ~ z will appear in input strings.

这道题容易让人想太多，要注意的一点是任何字符串他的本身就是一个子序列，所以要求最长不同子序列直接返回长度比较长的那个字符串就好了
 * @author CLara1
 *
 */
public class Solution {
	public static int findLUSlength(String a, String b) {
        if(a.equals(b)){
        	return -1;
        	
        }
        return Math.max(a.length(), b.length());
		
		
    }
	public static void main(String[] agrs){
		String a="aba";
		String b="cdc";
		int result=findLUSlength(a,b);
		System.out.println(result);
	}
}

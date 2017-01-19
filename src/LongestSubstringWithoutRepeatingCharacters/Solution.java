package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * [Title]:Longest Substring Without Repeating Characters
 * 
 * [Description]:Given a string, find the length of the longest substring without repeating characters.
 * 
 * [Example]:Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * 
 * 
 * [Note]:使用map来记录字符和该字符最后一次出现的位置
 * 当前扫到字符s[j],j是它的下标，当前没有重复的字符串的下标范围是[i,j-1]，如果在这个范围里面找到了这个字符
 * 且这个字符的下标是j'(可以根据map中已有的记录容易得到)，那么我们只要跳过[i,j']这一段范围内的字符就可以了，
 * 然后i重新设为j'+1。
 * @author CLara1
 *
 */
public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		int strlen=s.length();
		int maxlen=0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		for(int i=0,j=0;j<strlen;j++){
			if(map.containsKey(s.charAt(j))){
				i=Math.max(i, map.get(s.charAt(j)));
			}
			maxlen=Math.max(maxlen, j-i+1);
			map.put(s.charAt(j), j+1);
		}
		return maxlen;
        
    }
	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		String str=in.nextLine();
		int len=lengthOfLongestSubstring(str);
		System.out.println(len);
	}
}

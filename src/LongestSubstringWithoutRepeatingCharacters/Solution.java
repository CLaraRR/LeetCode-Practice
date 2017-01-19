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
 * [Note]:ʹ��map����¼�ַ��͸��ַ����һ�γ��ֵ�λ��
 * ��ǰɨ���ַ�s[j],j�������±꣬��ǰû���ظ����ַ������±귶Χ��[i,j-1]������������Χ�����ҵ�������ַ�
 * ������ַ����±���j'(���Ը���map�����еļ�¼���׵õ�)����ô����ֻҪ����[i,j']��һ�η�Χ�ڵ��ַ��Ϳ����ˣ�
 * Ȼ��i������Ϊj'+1��
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

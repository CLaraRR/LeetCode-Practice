package LongestSubstringwithAtLeastKRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;


/**
 * 395. Longest Substring with At Least K Repeating Characters 
 * Find the length of the longest substring T of a given string
 * (consists of lowercase letters only) such that every character in T appears no less than k times.
 * 
 * Example 1:
 * Input
 * s = "aaabb", k = 3
 * Output
 * 3
 * The longest substring is "aaa", as 'a' is repeated 3 times
 * 
 * Example 2:
 * Input
 * s = "ababbc", k = 2
 * Output
 * 5
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * 问题分析：
 * 最终得到的字符串中一定不会包含个数小于k的字符，那么我们可以先找出那些字符，将他们作为分隔符号
 * 然后再递归查找被分割掉的字符串，这些字符串同样也要满足上面的特点
 * 
 * 思路：用递归
 * 1、统计字符串每个字符出现的个数
 * 2、如果存在字符的个数小于k的话，将他们作为分隔符号来split字符串；如果不存在，则直接返回字符串长度
 * 3、将分隔得到的字符串做同样的判断和处理
 * 4、最终取长度最长的字符串
 * 
 * 我在做的时候一开始使用长度为26的整型数组来保存每个字符出现的次数
 * 但是会报错，说是栈溢出。。。表示不懂为什么
 * 后来用了HashMap来保存就不会出现这个问题了。。。蜜汁报错
 * @author CLara1
 *
 */
public class Solution {
	public static int longestSubstring(String s, int k) {
        if(s==null||k<0){
        	return 0;
        }
        
        Map<Character,Integer> charsMap=new HashMap<Character,Integer>();//记录每个字符出现的次数
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
        	if(charsMap.containsKey(c)){
        		charsMap.put(c, charsMap.get(c)+1);
        	}else{
        		charsMap.put(c, 1);
        	}
        }
        
        Character sp=null;
        for(Character c:charsMap.keySet()){
        	if(charsMap.get(c)<k){
        		sp=c; //找到个数小于k的字符作为分隔符,
        		      //其实分隔符可能会有多种选择，但是从哪个开始分隔最后的结果都是一样的，
        		      //不信的话可以去掉break
        		break;//break的作用是只要找到一个小于k的字符就立即把他当作分隔符（分隔符可能存在多种选择）
        	}
        }
        if(sp==null){
        	return s.length();//如果没有分隔符则说明这个字符串中所有字符的个数都大于等于k，可以直接返回字符串长度
        }
        String[] splitStr=s.split(sp.toString());//分隔字符串
        
        int maxlen=0;
        for(int i=0;i<splitStr.length;i++){
        	int len=longestSubstring(splitStr[i],k);//递归查找最长的字符串
        	maxlen=Math.max(maxlen,len);
        }
        return maxlen;
    }
	
	public static void main(String[] args){
		String s="ababbaacbadbaabb";
		int k=3;
		int length=longestSubstring(s,k);
		System.out.println(length);
	}
}

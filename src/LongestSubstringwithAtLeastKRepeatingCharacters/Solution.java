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
 * ���������
 * ���յõ����ַ�����һ�������������С��k���ַ�����ô���ǿ������ҳ���Щ�ַ�����������Ϊ�ָ�����
 * Ȼ���ٵݹ���ұ��ָ�����ַ�������Щ�ַ���ͬ��ҲҪ����������ص�
 * 
 * ˼·���õݹ�
 * 1��ͳ���ַ���ÿ���ַ����ֵĸ���
 * 2����������ַ��ĸ���С��k�Ļ�����������Ϊ�ָ�������split�ַ�������������ڣ���ֱ�ӷ����ַ�������
 * 3�����ָ��õ����ַ�����ͬ�����жϺʹ���
 * 4������ȡ��������ַ���
 * 
 * ��������ʱ��һ��ʼʹ�ó���Ϊ26����������������ÿ���ַ����ֵĴ���
 * ���ǻᱨ��˵��ջ�����������ʾ����Ϊʲô
 * ��������HashMap������Ͳ��������������ˡ�������֭����
 * @author CLara1
 *
 */
public class Solution {
	public static int longestSubstring(String s, int k) {
        if(s==null||k<0){
        	return 0;
        }
        
        Map<Character,Integer> charsMap=new HashMap<Character,Integer>();//��¼ÿ���ַ����ֵĴ���
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
        		sp=c; //�ҵ�����С��k���ַ���Ϊ�ָ���,
        		      //��ʵ�ָ������ܻ��ж���ѡ�񣬵��Ǵ��ĸ���ʼ�ָ����Ľ������һ���ģ�
        		      //���ŵĻ�����ȥ��break
        		break;//break��������ֻҪ�ҵ�һ��С��k���ַ����������������ָ������ָ������ܴ��ڶ���ѡ��
        	}
        }
        if(sp==null){
        	return s.length();//���û�зָ�����˵������ַ����������ַ��ĸ��������ڵ���k������ֱ�ӷ����ַ�������
        }
        String[] splitStr=s.split(sp.toString());//�ָ��ַ���
        
        int maxlen=0;
        for(int i=0;i<splitStr.length;i++){
        	int len=longestSubstring(splitStr[i],k);//�ݹ��������ַ���
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

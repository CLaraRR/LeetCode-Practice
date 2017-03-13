package DecodeString;

import java.util.Stack;


/**
 * 394. Decode String
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc"
 * s = "3[a2[c]]", return "accaccacc"
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * 思路：用两个Stack分别存储字符和数字（倍数）
 * 碰到数字就把数字存进numStack（要注意数字不止一位数的情况）
 * 每次碰到'['就把之前解码得到的字符串存进charStack，
 * 碰到']'就把最近存进charStack的字符串取出来，这个字符串是最新解码的字符串newStr
 * 再取出最近存进numStack的倍数k，'['和']'之间的字符串重复k次并加到newStr
 * 此时得到的newStr就是最新解码的得到的字符串
 * 
 * @author CLara1
 *
 */
public class Solution {
	public static String decodeString(String s) {
		String res = "";//记录每个阶段得到的最新的字符串，初始化为""
		Stack<String> charStack = new Stack<>();//存放字符串
		Stack<Integer> numStack = new Stack<>();//存放倍数
		char sArray[] = s.toCharArray();
		for(int i = 0 ; i < s.length(); i++){
			if(sArray[i] > '0' && sArray[i] <= '9'){  // if num = 10,111... while
				int j = i;
				int count = 0;
				while(sArray[j] >= '0' && sArray[j] <= '9'){ //考虑大于1位数的情况
					count = count * 10 +  sArray[j] - '0';
					j++;
				}
				i = j - 1;//重新定位i的位置
				numStack.push(count);//把数字存进numStack
			} 
			else if(sArray[i] == '['){
				charStack.push(res);//把之前得到的字符串存进charStack
				res = "";//清空
			}
			else if(sArray[i] == ']'){
				StringBuilder newStr = new StringBuilder(charStack.pop());//获取最新解码得到的字符串
				int k = numStack.pop();//获取最近的倍数
				while(k > 0){//重复倍数次添加到最新解码的字符串后面
					newStr.append(res);
					k--;
				}
				res = newStr.toString();//更新字符串
			}
			else
				res += sArray[i];
			}
		return res;
    }
	
	public static void main(String[] args){
		String s="3[a2[c]]2[abc]";
		String t=decodeString(s);
		System.out.println(t);
	}
}

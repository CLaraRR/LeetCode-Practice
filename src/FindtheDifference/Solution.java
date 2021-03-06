package FindtheDifference;

import java.util.ArrayList;
import java.util.List;


/**
 * Given two strings s and t which consist of only lowercase letters.
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * Find the letter that was added in t.
 * 
 * Example:
 * Input:
 * s = "abcd"
 * t = "abcde"
 * 
 * Output:
 * e
 * Explanation:
 * 'e' is the letter that was added.
 * 
 * @author CLara1
 *
 */
public class Solution {
	public static char findTheDifference(String s, String t) {
        List<Character> list=new ArrayList<Character>();
        for(int i=0;i<t.length();i++){
        	list.add(t.charAt(i));
        }
        for(int i=0;i<s.length();i++){
        	if(list.contains(s.charAt(i))){
        		Character c=s.charAt(i);
        		list.remove(c);
        	}
        }
        
        return list.get(0);
    }
	
	public static void main(String[] args){
		String s="abcd";
		String t="dbcae";
		char c=findTheDifference(s,t);
		System.out.println(c);
	}
}

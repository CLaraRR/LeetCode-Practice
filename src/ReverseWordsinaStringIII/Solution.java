package ReverseWordsinaStringIII;

public class Solution {
	public static String reverseWords(String s) {
	    StringBuffer result=new StringBuffer();
	    String[] split=s.split(" ");
	    int i;
	    for(i=0;i<split.length-1;i++){
	    	result.append(new StringBuffer(split[i]).reverse()+" ");
	    }
	    result.append(new StringBuffer(split[i]).reverse());
		return result.toString();
		
    }  
	public static void main(String[] args){
		String s="Let's take LeetCode contest";
		String result=reverseWords(s);
		System.out.println(result);
	}
}

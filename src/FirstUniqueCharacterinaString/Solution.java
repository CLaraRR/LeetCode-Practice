package FirstUniqueCharacterinaString;



public class Solution {
	public int firstUniqChar(String s) {
		int index=-1;
		int[] count=new int[26];
		for(int i=0;i<s.length();i++){
			int k=s.charAt(i)-'a';
			count[k]++;
		}
		for(int i=0;i<s.length();i++){
			int k=s.charAt(i)-'a';
			if(count[k]==1){
				index=i;
				return index;
			}
		}
        return index;
    }
	
	public static void main(String[] args){
		Solution test=new Solution();
		String s="loveleetcode";
		int index=test.firstUniqChar(s);
		System.out.println(index);
	}
}

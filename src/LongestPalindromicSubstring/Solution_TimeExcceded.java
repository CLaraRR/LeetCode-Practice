package LongestPalindromicSubstring;

public class Solution_TimeExcceded {
	public static String longestPalindrome(String s) {
		String reverseStr=reverseString(s);
		int maxlength=0;
		String longestPalindromeStr=null;
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<=s.length();j++){
				String str1=s.substring(i,j);
				int str1len=str1.length();
				if(str1len==maxlength&&reverseString(str1).equals(longestPalindromeStr)){
					//System.out.println("%%%% "+str1);
					s=s.replace(longestPalindromeStr, "");
					//reverseStr=reverseStr.replace(str1, "");
					//continue;
					//System.out.println(s);
					longestPalindromeStr=longestPalindrome(s);
					return longestPalindromeStr;
				}
				if(reverseStr.contains(str1)&&str1len>maxlength){
					maxlength=str1len;
					longestPalindromeStr=str1;
				}
			}
		}
		
		return longestPalindromeStr;
        
    }
	
	public static String reverseString(String s){
		String reverseStr;
		int len=1;
		int strlen=s.length();
		reverseStr=s.substring(strlen);
		while(len<=strlen){
			reverseStr+=s.charAt(strlen-len);
			len++;
		}
		return reverseStr;
	}
	public static void main(String[] args){
		String s="ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
		String longestPalindromeStr=longestPalindrome(s);
		System.out.println(longestPalindromeStr);
	}

}

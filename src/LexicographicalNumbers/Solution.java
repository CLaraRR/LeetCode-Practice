package LexicographicalNumbers;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> lexicalOrder(int n) {
		List<Integer> rl=new LinkedList<Integer>();
	
		int cur=1;
		for(int i=0;i<n;i++){
			rl.add(cur);
			if(cur*10<=n){
				cur*=10;
			}else{
				if (cur >= n) cur /= 10;
				cur+=1;
				while(cur%10==0){
					cur/=10;
				}
			}
		}
		return rl;
        
    }
	public static void main(String[] args){
		//Scanner in=new Scanner(System.in);
		//int n=in.nextInt();
		Solution test=new Solution();
		List<Integer> list=test.lexicalOrder(23);
		for(Integer each:list){
			System.out.print(each+" ");
		}
		System.out.println();
	}
}

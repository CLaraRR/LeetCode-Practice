package BinaryTreeTilt;

public class Solution {
	public int tilt=0;
	public  int findTilt(TreeNode root) {
		calTilt(root);
		return tilt;
		
	}
	
	public  int calTilt(TreeNode root){
		if(root==null){
			return 0;
		}
		
		int lefttilt=calTilt(root.left);
		int righttilt=calTilt(root.right);
		tilt+=Math.abs(lefttilt-righttilt);
		//System.out.println(tilt);
		return root.val+lefttilt+righttilt;
	}

	public static void main(String[] args){
		TreeNode n1=new TreeNode(1);
		TreeNode n2=new TreeNode(2);
		TreeNode n3=new TreeNode(3);
		TreeNode n4=new TreeNode(4);
		TreeNode n5=new TreeNode(5);
		//TreeNode n6=new TreeNode(6);
		n1.left=n2;
		n1.right=n3;
		n2.left=n4;
		//n2.right=n5;
		n3.left=n5;
		int r=new Solution().findTilt(n1);
		System.out.println(r);
		
	}
	
	private static class TreeNode {
		int val;
		TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { 
	    	val = x; 
	    }
	}
}

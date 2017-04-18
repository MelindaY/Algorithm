package Algorithm;
/*要求：  操作给定的二叉树，将其变换为源二叉树的镜像。
 *     二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5 
 *  
 *  
 *方法： 利用递归，每次交换调用，结束条件为根节点为null */


public class MirrorTree {
	public void Mirror(TreeNode root) {
		if(root==null)
			return;
		TreeNode swp=new TreeNode(0);
		swp=root.left;
		root.left=root.right;
		root.right=swp;
		Mirror(root.left);
		Mirror(root.right);      
    }
	
}

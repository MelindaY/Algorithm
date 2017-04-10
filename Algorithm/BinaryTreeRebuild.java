package Algorithm;
/**
 * Definition for binary tree*/
/* 题目要求：已知二叉树的先序遍历和中序遍历的顺序，求得该二叉树
 * Tips：     利用递归思想：先序遍历第一个节点便是根节点，对应到中序遍历中，便能找到左右子树
 * 基础：       先序遍历：根->左->右
 *        中序遍历：左->根->右
 * 难点：       这个顺序是一个数组，怎么找到数组中的某个值？只能遍历了
 * 体会：       啊啊啊啊啊啊啊我简直是太讨厌递归了！！！！
 *        递归：每一次只执行一次，结果是递归到下一次递归，而不是没完没了的递归。换句话说，
 *            每一次是建立根节点，然后赋值左右子树，而不是一直找最左边的叶子节点
 *            Hope you would not forget several months later*/
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class BinaryTreeRebuild {
	
	    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
	        if(pre==null||in==null)
	        	return null;
	        return  reConstructBinaryTree(pre, 0,pre.length-1, in,0,in.length-1);   	
	    	
	    }
	  private TreeNode reConstructBinaryTree(int[]pre, int startPre,int endPre, int[] in, int startIn,int endIn){
		  if(startPre>endPre||startIn>endIn)
			  return null;
		  TreeNode root= new TreeNode(pre[startPre]);
		  for(int i=startIn;i<=endIn;i++){
			 if(in[i]==pre[startPre]){
				 root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1); 
				 root.right=reConstructBinaryTree(pre,startPre+i-startIn+1,endPre,in,i+1,endIn); 
			 }
		  }
		  return root;
	  }
	  public static void main(String[] args){
		  int[] pre= {1,2,4,3,5,6};
		  int[] in={4,2,1,5,3,6};
		  TreeNode root=null;
		  BinaryTreeRebuild treeBuild=new  BinaryTreeRebuild();
		  root=treeBuild.reConstructBinaryTree(pre,in);
		  while(root!=null){
			  System.out.print(root.val);
			  if(root.left!=null)
				  System.out.print(root.left.val);
			  if(root.right!=null)
				  System.out.print(root.right.val);
			  root=root.left;
		  }
	  }

}

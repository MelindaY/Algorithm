package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 该类中全部为二叉树的操作，包括对于搜索二叉树的。
 * @author wzq
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Tree {
	
	private ArrayList<ArrayList<Integer>>list=
			new  ArrayList<ArrayList<Integer>>();
	 private ArrayList<Integer>subList=
			 new ArrayList<Integer>();
	 private TreeNode root=null;
	 
	 
	 /** 创建二叉排序树*/
	 public TreeNode createBST(){
		 TreeNode test=null;
		 for(int i=0;i<5;i++){
			 root=BSTInsert(root, i);
			 test=root;
		 }
		 return root;
		 
	 }
	 
	 
	 /**在某一二叉排序树中插入节点*/
	 public TreeNode BSTInsert(TreeNode tree,int ele){
		 if(tree==null){
			 tree=new TreeNode(ele);
			 tree.left=null;
			 tree.right=null;
			 return tree;
		 }
		else if(ele>tree.val)
			 return BSTInsert(tree.right,ele);
		else
			return BSTInsert(tree.left,ele);
	 }
	 
	 
	 /** 先序遍历二叉树*/
	 public void preOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 preOrder(tree.left);
		 System.out.println(tree.val);
		 preOrder(tree.right);
	 }
	 
	 
	/* 题目要求：已知二叉树的先序遍历和中序遍历的顺序，求得该二叉树
	 * Tips：     利用递归思想：先序遍历第一个节点便是根节点，对应到中序遍历中，便能找到左右子树
	 * 基础：       先序遍历：根->左->右
	 *        中序遍历：左->根->右
	 * 难点：       这个顺序是一个数组，怎么找到数组中的某个值？只能遍历了
	 * 体会：       啊啊啊啊啊啊啊我简直是太讨厌递归了！！！！
	 *        递归：每一次只执行一次，结果是递归到下一次递归，而不是没完没了的递归。换句话说，
	 *            每一次是建立根节点，然后赋值左右子树，而不是一直找最左边的叶子节点
	 *            Hope you would not forget several months later*/
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
	
	
	/**
	 * 判断某一序列是不是二叉排序树的后序遍历
	 */
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0)
        	return false;
        int size=sequence.length-1;
        int i=0;
        while(size>0){
        	while(sequence[i++]<sequence[size]);
        	if(i<size)
        	    while(sequence[i++]>sequence[size]);
        	if(i<size)
        		return false;
        	i=0;
        	size--;
        }
        return true;
    }
	
	
	/**
	 * 返回满足从根节点到叶子节点相加等于某一值的所有序列
	 */
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root==null||root.val>target)
        	return list;
    	subList.add(root.val);
    	target-=root.val;

        if(root.left==null&&root.right==null&&target==0)
        	list.add(new ArrayList<Integer>(subList));
        FindPath(root.left,target);
        FindPath(root.right,target);
        subList.remove(subList.size()-1);
        return list;
    }
	
	
	/**
	 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 * 思路：辅助工具队列
	 */
	public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root==null)
        	return null;
        ArrayList<Integer> result=new ArrayList<Integer>();
        Queue<TreeNode> queueNode=new LinkedList<TreeNode>();
        queueNode.offer(root);
        while(!queueNode.isEmpty()){
        	TreeNode node=queueNode.poll();
        	if(node.left!=null)
        		queueNode.offer(node.left);
        	if(node.right!=null)
        		queueNode.offer(node.right);
        	result.add(node.val);
        }
        return result;
    }
	
	
	/**
	 * 判断某一树是不是另外一个树的子树
	 */
	public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
		 if(root1==null||root2==null)
			 return false;
		 return isSubTree(root1,root2)||HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);    
	    }
	public static boolean isSubTree(TreeNode root1,TreeNode root2){
		if(root1==null&&root2!=null)
			return false;
		if(root2==null)
			return true;
		if(root1.val!=root2.val)
			return false;
		return (isSubTree(root1.left,root2.left)&&isSubTree(root1.right,root2.right));
			
	}
	
	
	/*
	 *题目要求：对于深度为k的满二叉排序树，节点数为2^k-1,值为1-2^k-1,已知任意三个节点的值和深度
	 *        求最小子树的根节点。
	 *分析：      满二叉树：     就是每个根都有两个节点（完全二叉树：满二叉树去掉一部分右子树）
	 *    满二叉排序树：    左子树< 根节点<右子树
	 *      二分查找法：   如果对于二分点m满足在任意两点中间（(i-m)*(j-m)<=0)）或者本身就等于该节点
	 *                就返回。否则，递归。注意递归时返回值的写的方式。 */
	public int findRoot(int i,int j,int k, int left, int right){
		int m=left+(right-left)/2;
	    if(((i-m)*(j-m)<=0)||((i-m)*(k-m)<=0)||((j-m)*(k-m)<=0)){
	    	return m;
	    }
	    else if(i>m)
	    	return findRoot(i,j,k, m+1, right);
	    else
	    	return findRoot(i,j,k, left, m-1);

	}
	
	
	 public static void main(String[] args){
		 /**
		  * 测试已知二叉树的先序遍历和中序遍历，求二叉树
		  */
		  int[] pre= {1,2,4,3,5,6};
		  int[] in={4,2,1,5,3,6};
		  TreeNode root=null;
		  Tree treeBuild=new  Tree();
		  root=treeBuild.reConstructBinaryTree(pre,in);
		  treeBuild.Mirror(root);
		  while(root!=null){
			  System.out.print(root.val);
			  if(root.left!=null)
				  System.out.print(root.left.val);
			  if(root.right!=null)
				  System.out.print(root.right.val);
			  root=root.left;
		  }
		  /*测试是否为搜索二叉树的后序遍历序列*/
		  int[] sequence={};
		  System.out.println(treeBuild.VerifySquenceOfBST(sequence));
		  /* 求最小子树的根节点*/
		  Scanner s=new Scanner(System.in);
			int i=s.nextInt();
			int j=s.nextInt();
			int k=s.nextInt();
			int right=s.nextInt();
			s.close();
			System.out.println(treeBuild.findRoot(i,j,k,1,(2 <<right)-1));
	 }

}

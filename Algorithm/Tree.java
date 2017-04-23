package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * ������ȫ��Ϊ�������Ĳ������������������������ġ�
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
	 
	 
	 /** ��������������*/
	 public TreeNode createBST(){
		 TreeNode test=null;
		 for(int i=0;i<5;i++){
			 root=BSTInsert(root, i);
			 test=root;
		 }
		 return root;
		 
	 }
	 
	 
	 /**��ĳһ�����������в���ڵ�*/
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
	 
	 
	 /** �������������*/
	 public void preOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 preOrder(tree.left);
		 System.out.println(tree.val);
		 preOrder(tree.right);
	 }
	 
	 
	/* ��ĿҪ����֪��������������������������˳����øö�����
	 * Tips��     ���õݹ�˼�룺���������һ���ڵ���Ǹ��ڵ㣬��Ӧ����������У������ҵ���������
	 * ������       �����������->��->��
	 *        �����������->��->��
	 * �ѵ㣺       ���˳����һ�����飬��ô�ҵ������е�ĳ��ֵ��ֻ�ܱ�����
	 * ��᣺       ���������������Ҽ�ֱ��̫����ݹ��ˣ�������
	 *        �ݹ飺ÿһ��ִֻ��һ�Σ�����ǵݹ鵽��һ�εݹ飬������û��û�˵ĵݹ顣���仰˵��
	 *            ÿһ���ǽ������ڵ㣬Ȼ��ֵ����������������һֱ������ߵ�Ҷ�ӽڵ�
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
	
	
	/*Ҫ��  ���������Ķ�����������任ΪԴ�������ľ���
	 *     �������ľ����壺Դ������ 
	    	    8
	    	   /  \
	    	  6   10
	    	 / \  / \
	    	5  7 9 11
	    	���������
	    	    8
	    	   /  \
	    	  10   6
	    	 / \  / \
	    	11 9 7  5 
	 *  
	 *  
	 *������ ���õݹ飬ÿ�ν������ã���������Ϊ���ڵ�Ϊnull */
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
	 * �ж�ĳһ�����ǲ��Ƕ����������ĺ������
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
	 * ��������Ӹ��ڵ㵽Ҷ�ӽڵ���ӵ���ĳһֵ����������
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
	 * ��Ŀ���������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
	 * ˼·���������߶���
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
	 * �ж�ĳһ���ǲ�������һ����������
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
	 *��ĿҪ�󣺶������Ϊk�����������������ڵ���Ϊ2^k-1,ֵΪ1-2^k-1,��֪���������ڵ��ֵ�����
	 *        ����С�����ĸ��ڵ㡣
	 *������      ����������     ����ÿ�������������ڵ㣨��ȫ����������������ȥ��һ������������
	 *    ��������������    ������< ���ڵ�<������
	 *      ���ֲ��ҷ���   ������ڶ��ֵ�m���������������м䣨(i-m)*(j-m)<=0)�����߱���͵��ڸýڵ�
	 *                �ͷ��ء����򣬵ݹ顣ע��ݹ�ʱ����ֵ��д�ķ�ʽ�� */
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
		  * ������֪���������������������������������
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
		  /*�����Ƿ�Ϊ�����������ĺ����������*/
		  int[] sequence={};
		  System.out.println(treeBuild.VerifySquenceOfBST(sequence));
		  /* ����С�����ĸ��ڵ�*/
		  Scanner s=new Scanner(System.in);
			int i=s.nextInt();
			int j=s.nextInt();
			int k=s.nextInt();
			int right=s.nextInt();
			s.close();
			System.out.println(treeBuild.findRoot(i,j,k,1,(2 <<right)-1));
	 }

}

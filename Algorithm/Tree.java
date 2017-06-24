package Algorithm;
import ThinkingInJava.CoreBasicTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * 该类中全部为二叉树的操作，包括对于搜索二叉树的。
 * @author wzq
 * 包括对二叉树的如下操作：
 * 
 * ************************    创建        *************************************************
 *     createBST(int num)                   创建节点数为num的搜索二叉树
 *     BSTInsert(TreeNode tree,int ele)     向搜索二叉树tree中插入元素ele
 * *************************    遍历       ************************************************
 *       名称                                       概念                                       递归版函数名                       非递归版函数名
 *      前序遍历                  root->left->right         preOrder       NonRecursivePreOrder
 *      中序遍历                  left->root->right         midOrder       
 *      后序遍历                  left->right->root         postOrder
 **********************************************************************************
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
public class Tree {
	
	private Stack<TreeNode> rootStack=new Stack<TreeNode>();
	private ArrayList<ArrayList<Integer>>list=
			new  ArrayList<ArrayList<Integer>>();
	private ArrayList<Integer>subList=
			 new ArrayList<Integer>();
	private TreeNode tmp=null;  //Q8
	private TreeNode head=null; //Q8
	private TreeNode root=null; 
	private int index=-1;
	
	public TreeNode getRoot(){
		 return root;
	 }
	 
	 
	 /**
	  * 创建搜索二叉树，元素为随机数
	  * @param num 二叉树节点个数
	  * @return
	  */
	 public TreeNode createBST(int num){
		 for(int i=0;i<num;i++){
			//因为每次传的都是形参，是需要将返回值赋值给右节点的
			 root=BSTInsert(root, (int)(Math.random()*100));
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
		 if(ele==tree.val)
			 return tree;
		else if(ele>tree.val)
			//因为每次传的都是形参，是需要将返回值赋值给右节点的
			tree.right=BSTInsert(tree.right,ele);
		else
			tree.left=BSTInsert(tree.left,ele);
		 return tree;
	 }
	 
	 
	 /** 递归中序遍历二叉树*/
	 public void midOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 midOrder(tree.left);
		 System.out.println(tree.val);
		 midOrder(tree.right);
	 }
	 /** 递归前序遍历二叉树*/
	 public void preOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 System.out.println(tree.val);
		 preOrder(tree.left);
		 preOrder(tree.right);
	 }
	 /** 递归后序遍历二叉树*/
	 public void postOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 postOrder(tree.left);
		 postOrder(tree.right);
		 System.out.println(tree.val);
	 }
	 /*非递归 中序遍历*/
	 public void nonRecursiveMidOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 Stack<TreeNode>result=new Stack<TreeNode>();
		 TreeNode node=null;
		 node=tree;
		 while(node!=null||!result.isEmpty()){
			 
			 while(node!=null){
				 result.push(node);
				 node=node.left;
			 }
			 if(!result.isEmpty()){
				 node=result.pop();
				 System.out.println(node.val);
				 node=node.right;
			 }
		 }
	 }
	 /** 删除节点*/
	 public TreeNode deleteNode(TreeNode tree, int ele){
		 TreeNode tmpLeft=null;
		 TreeNode tmpRight=null;
		 TreeNode preNode=null;
		 if(tree==null)
			 return null;
		 if(tree.val==ele){
			 if(tree.right==null){
				 tree=tree.left;
			 }
			 else{
				 tmpLeft=tree.left;
				 tree=tree.right;
				 while(tree.left!=null){
					 preNode=tree;
					 tree=tree.left;
				 }
				 tree.left=tmpLeft;
				 if(tree.right!=null){
					 preNode.left=tree.right;
				 }
				 tree.right=tmpRight;
			 }
			 return tree;
		 }
		 if(tree.val>ele)
			 tree=deleteNode(tree.right, ele);
		 if(tree.val<ele)
			 tree=deleteNode(tree.left, ele);
		 return tree;
	 }
	 
	 /** 删除最值点，实现的是最小值，最大值和最小值是类似的*/
	 public TreeNode deleteMin(TreeNode tree){
		 if(tree==null)
			 return null;
		 if(tree.left==null){
			 tree=tree.right;
			 return tree;
		 }
		 //为什么是tree.left? 因为如果左子树为空，就直接返回。否则的话 就修改左子树
		 tree.left=deleteMin(tree.left);
		 return tree;
	 }
	 /** Q1: 查找节点*/	
	/* 题目要求：已知二叉树的先序遍历和中序遍历的顺序，求得该二叉树
	 * Tips：     利用递归思想：先序遍历第一个节点便是根节点，对应到中序遍历中，便能找到左右子树
	 *  基础：     先序遍历：根->左->右
	 *        中序遍历：左->根->右
	 *  难点：    这个顺序是一个数组，怎么找到数组中的某个值？只能遍历了
	 *  体会：    啊啊啊啊啊啊啊我简直是太讨厌递归了！！！！
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
	
	
	/*Q2:           
	 *              要求：  操作给定的二叉树，将其变换为源二叉树的镜像。
	 *     二叉树的镜像定义：  源二叉树 
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
	 *             方法：       利用递归，每次交换调用，结束条件为根节点为null */
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
	 * Q3: 判断某一序列是不是二叉排序树的后序遍历
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
	 * Q4: 返回满足从根节点到叶子节点相加等于某一值的所有序列
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
	
	
	/**Q5
	 * 题目：从上往下打印出二叉树的每个节点，同层节点从左至右打印。
	 * 思路：辅助工具队列 层次打印
	 */
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
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
	
	
	/**Q6
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
	
	
	/*Q7
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
	
    /**Q8
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，
     * 只能调整树中结点指针的指向。
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        SubConvert(pRootOfTree);
        return head;
    }
    
    public void SubConvert(TreeNode root){
    	if(root==null)
    		return;
    	SubConvert(root.left);
    	if(tmp==null){
    		head=root;
    		tmp=root;
    	}
    	else{
    		tmp.right=root;
    		root.left=tmp;
    		tmp=root;	
    	}
    	SubConvert(root.right);
    }
	
    public TreeNode nonRecuriseConvert(TreeNode pRootOfTree) {
        TreeNode head=null;
        TreeNode tmp=null;
        boolean flag=false;
        Stack<TreeNode> result=new Stack<TreeNode>();
        while(pRootOfTree!=null||!result.isEmpty()){
		    while(pRootOfTree!=null){
		    	result.push(pRootOfTree);
		    	pRootOfTree=pRootOfTree.left;
		    }
		    if(!result.isEmpty()){
		    	pRootOfTree=result.pop();
		    	if(!flag){
		    		head=pRootOfTree;
		    		tmp=pRootOfTree;
		    		flag=true;
		    	}
		    	else{
		    		tmp.right=pRootOfTree;
		    		pRootOfTree.left=tmp;
		    		tmp=pRootOfTree;
		    	}
		    	pRootOfTree=pRootOfTree.right;
		    }
        }
        return head;
    }
	
    /*
     * 输入一棵二叉树，求该树的深度。
     * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。*/
    public int TreeDepth(TreeNode root) {
        if(root==null)
        	return 0;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
    /*
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
        	return true; //这个写的有问题
        int leftHeight=TreeHeight(root.left);
        int rightHeight=TreeHeight(root.right);
        int diff=leftHeight-rightHeight;
        if(diff>1||diff<-1)
        	return false;
        else{
        	return (IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right));
        }
        
    }

    public int TreeHeight(TreeNode root){
    	if(root==null)
        	return 0;
    	int treeLeft=TreeHeight(root.left);
    	int treeRight=TreeHeight(root.right);
    	return treeLeft>treeRight?treeLeft+1:treeRight+1;
    }
    
    /**
     * 给定一个二叉树和其中的一个结点，
     * 请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
     * @param args
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null)
        	return pNode;
        if(pNode.right!=null){
        	pNode=pNode.right;
        	while(pNode.left!=null)
        		pNode=pNode.left;
        	return pNode;
        }
        while(pNode.next!=null){
        	TreeLinkNode fatherNode=pNode.next;
    		if(fatherNode.left==pNode){
    		    return fatherNode;
        	}
    		pNode=pNode.next;
        }
        return null;//不是pNode
    }
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * @param args
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
	    	if(pRoot==null)
	    		return true;
	    	return isSymmetrical(pRoot.left,pRoot.right);
	        
	    }
    private boolean isSymmetrical(TreeNode pRoot1,TreeNode pRoot2){
    	if((pRoot1==null&&pRoot2!=null)||(pRoot2==null&&pRoot1!=null))
    		return false;
    	if(pRoot1==null&&pRoot2==null)
    		return true;
    	else 
    		return pRoot1.val==pRoot2.val&&isSymmetrical(pRoot1.left,pRoot2.right)
    		       &&isSymmetrical(pRoot2.left,pRoot1.right);
    }
    
    /**
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
     * 第三行按照从左到右的顺序打印，其他行以此类推。
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    	 LinkedList<TreeNode> queueNode=new LinkedList<TreeNode>();
    	 queueNode.add(pRoot);
    	 boolean leftToRight=false;
    	 Iterator<TreeNode> it;
    	 int layer=0;
    	 ArrayList<ArrayList<Integer>>result=new ArrayList<ArrayList<Integer>>();
    	 if(pRoot==null)
    		 return result;
    	 while(queueNode.peek()!=null){
    		 ArrayList<Integer>rowTree=new ArrayList<Integer>();
    		 int cur=0,size=queueNode.size();
    		 if(leftToRight){
    			 it=queueNode.descendingIterator();
    			 leftToRight=!leftToRight;
    		 }    			
    		 else{
    			 it=queueNode.iterator(); 
    			 leftToRight=!leftToRight;
    		 }	
    		 while(it.hasNext()){
    			 rowTree.add(it.next().val);
    		 }
    		 while(cur<size){
    		 TreeNode node=queueNode.poll();
    		 if(node.left!=null)
    			 queueNode.add(node.left);
    		 if(node.right!=null)
    			 queueNode.add(node.right);
    		 cur++;
    		 }
    		 result.add(rowTree);
    	 }
    	 return result;
    }
    
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * @param pRoot
     * @return
     */
    
    public ArrayList<ArrayList<Integer> > PrintTopToBottom(TreeNode pRoot) {
        LinkedList<TreeNode>queueTree=new LinkedList<TreeNode>();
        queueTree.add(pRoot);
        ArrayList<ArrayList<Integer> >result=new ArrayList<ArrayList<Integer> >();
        if(pRoot==null)
        	return null;
        Iterator<TreeNode>iter;
        while(!queueTree.isEmpty()){
        	int cur=0,size=queueTree.size();
        	ArrayList<Integer>layer=new ArrayList<Integer>();
        	iter=queueTree.iterator();
        	while(iter.hasNext())
        		layer.add(iter.next().val);
        	while(cur<size){
       		 TreeNode node=queueTree.poll();
       		 if(node.left!=null)
       			 queueTree.add(node.left);
       		 if(node.right!=null)
       			 queueTree.add(node.right);
       		 cur++;
       		 }
        	result.add(layer);
        		
        }
        return result;
    }
    
    /**请实现两个函数，分别用来序列化和反序列化二叉树
     * 
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
    	StringBuilder sb=new StringBuilder();
        if(root==null){
        	sb.append("#");
        	sb.append(",");
        	return sb.toString();
        }
        sb.append(root.val);
        sb.append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
        
    }
   /* public  TreeNode Deserialize(String str) {
         char[]ch=str.toCharArray();
         if(str==null||ch[0]=='#')
        	 return null;
         
    }*/
	    
	 public static void main(String[] args){
		 /**
		  * 测试已知二叉树的先序遍历和中序遍历，求二叉树
		  */
		  /*int[] pre= {1,2,4,3,5,6};
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
		  }*/
		 /* 测试是否为搜索二叉树的后序遍历序列
		  int[] sequence={};
		  System.out.println(treeBuild.VerifySquenceOfBST(sequence));
		   求最小子树的根节点
		  Scanner s=new Scanner(System.in);
			int i=s.nextInt();
			int j=s.nextInt();
			int k=s.nextInt();
			int right=s.nextInt();
			s.close();
			System.out.println(treeBuild.findRoot(i,j,k,1,(2 <<right)-1));*/
		 /*TreeNode treeList=null;
		 TreeNode node=new TreeNode(5);
		 node.left=new TreeNode(4);
		 node.left.left=new TreeNode(2);
		 node.right=new TreeNode(6);
		 Tree tree=new Tree();
		 tree.pushTree(node);
		 //tree.printStackNode();
		 treeList=tree.ConvertToList(node);
		 while(treeList.left!=null){
			 //System.out.println(treeList.val);
			 treeList=treeList.left;
		 }
		 while(treeList!=null){
			 System.out.println(treeList.val);
			 treeList=treeList.right;
		 }*/
		 
		 /*Tree tree=new Tree();
 		 tree.createBST(5);
 		 TreeNode node=tree.getRoot();
 		 int ele=node.val;
 		 System.out.println("The original Tree is:");
		 tree.preOrder(node);
		 System.out.println("The deleted Tree is:");
		// node=tree.deleteNode(node, ele);
		 node=tree.deleteMin(node);
		 tree.preOrder(node);*/
		 
		 Tree tree=new Tree();
		 TreeNode node1=new TreeNode(5);
		 TreeNode node2=new TreeNode(6);
		 TreeNode node3=new TreeNode(6);
		 TreeNode node4=new TreeNode(4);
		 TreeNode node5=new TreeNode(9);
		 node2.left=null;
		 node2.right=null;
		 node3.left=node4;
		 node3.right=node5;
		 node4.left=null;
		 node4.right=null;
		 node5.left=null;
		 node5.right=null;
		 node1.left=node2;
		 node1.right=node3;
		 
 		 TreeNode node=tree.createBST(5);
 		 CoreBasicTest.print(tree.Serialize(node1));
 		 /*System.out.println("递归方法：");
 		 tree.midOrder(node);
 		 System.out.println("非递归方法：");
 		 tree.nonRecursiveMidOrder(node);*/
 		 //TreeNode nodeList=null;
 		 //System.out.println(tree.TreeDepth(node));;
 		//System.out.print(tree.IsBalanced_Solution(node));
 //		 tree.nonRecursiveMidOrder(nodeList);
	 }

}

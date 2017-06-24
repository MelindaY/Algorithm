package Algorithm;
import ThinkingInJava.CoreBasicTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * ������ȫ��Ϊ�������Ĳ������������������������ġ�
 * @author wzq
 * �����Զ����������²�����
 * 
 * ************************    ����        *************************************************
 *     createBST(int num)                   �����ڵ���Ϊnum������������
 *     BSTInsert(TreeNode tree,int ele)     ������������tree�в���Ԫ��ele
 * *************************    ����       ************************************************
 *       ����                                       ����                                       �ݹ�溯����                       �ǵݹ�溯����
 *      ǰ�����                  root->left->right         preOrder       NonRecursivePreOrder
 *      �������                  left->root->right         midOrder       
 *      �������                  left->right->root         postOrder
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
	  * ����������������Ԫ��Ϊ�����
	  * @param num �������ڵ����
	  * @return
	  */
	 public TreeNode createBST(int num){
		 for(int i=0;i<num;i++){
			//��Ϊÿ�δ��Ķ����βΣ�����Ҫ������ֵ��ֵ���ҽڵ��
			 root=BSTInsert(root, (int)(Math.random()*100));
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
		 if(ele==tree.val)
			 return tree;
		else if(ele>tree.val)
			//��Ϊÿ�δ��Ķ����βΣ�����Ҫ������ֵ��ֵ���ҽڵ��
			tree.right=BSTInsert(tree.right,ele);
		else
			tree.left=BSTInsert(tree.left,ele);
		 return tree;
	 }
	 
	 
	 /** �ݹ��������������*/
	 public void midOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 midOrder(tree.left);
		 System.out.println(tree.val);
		 midOrder(tree.right);
	 }
	 /** �ݹ�ǰ�����������*/
	 public void preOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 System.out.println(tree.val);
		 preOrder(tree.left);
		 preOrder(tree.right);
	 }
	 /** �ݹ�������������*/
	 public void postOrder(TreeNode tree){
		 if(tree==null)
			 return;
		 postOrder(tree.left);
		 postOrder(tree.right);
		 System.out.println(tree.val);
	 }
	 /*�ǵݹ� �������*/
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
	 /** ɾ���ڵ�*/
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
	 
	 /** ɾ����ֵ�㣬ʵ�ֵ�����Сֵ�����ֵ����Сֵ�����Ƶ�*/
	 public TreeNode deleteMin(TreeNode tree){
		 if(tree==null)
			 return null;
		 if(tree.left==null){
			 tree=tree.right;
			 return tree;
		 }
		 //Ϊʲô��tree.left? ��Ϊ���������Ϊ�գ���ֱ�ӷ��ء�����Ļ� ���޸�������
		 tree.left=deleteMin(tree.left);
		 return tree;
	 }
	 /** Q1: ���ҽڵ�*/	
	/* ��ĿҪ����֪��������������������������˳����øö�����
	 * Tips��     ���õݹ�˼�룺���������һ���ڵ���Ǹ��ڵ㣬��Ӧ����������У������ҵ���������
	 *  ������     �����������->��->��
	 *        �����������->��->��
	 *  �ѵ㣺    ���˳����һ�����飬��ô�ҵ������е�ĳ��ֵ��ֻ�ܱ�����
	 *  ��᣺    ���������������Ҽ�ֱ��̫����ݹ��ˣ�������
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
	
	
	/*Q2:           
	 *              Ҫ��  ���������Ķ�����������任ΪԴ�������ľ���
	 *     �������ľ����壺  Դ������ 
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
	 *             ������       ���õݹ飬ÿ�ν������ã���������Ϊ���ڵ�Ϊnull */
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
	 * Q3: �ж�ĳһ�����ǲ��Ƕ����������ĺ������
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
	 * Q4: ��������Ӹ��ڵ㵽Ҷ�ӽڵ���ӵ���ĳһֵ����������
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
	 * ��Ŀ���������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
	 * ˼·���������߶��� ��δ�ӡ
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
	
	
	/*Q7
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
	
    /**Q8
     * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬
     * ֻ�ܵ������н��ָ���ָ��
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
     * ����һ�ö����������������ȡ�
     * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�*/
    public int TreeDepth(TreeNode root) {
        if(root==null)
        	return 0;
        int leftDepth=TreeDepth(root.left);
        int rightDepth=TreeDepth(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
    /*
     * ����һ�ö��������жϸö������Ƿ���ƽ���������
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null)
        	return true; //���д��������
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
     * ����һ�������������е�һ����㣬
     * ���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ��
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
        return null;//����pNode
    }
    /**
     * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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
     * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ��
     * �����а��մ����ҵ�˳���ӡ���������Դ����ơ�
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
     * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
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
    
    /**��ʵ�������������ֱ��������л��ͷ����л�������
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
		  * ������֪���������������������������������
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
		 /* �����Ƿ�Ϊ�����������ĺ����������
		  int[] sequence={};
		  System.out.println(treeBuild.VerifySquenceOfBST(sequence));
		   ����С�����ĸ��ڵ�
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
 		 /*System.out.println("�ݹ鷽����");
 		 tree.midOrder(node);
 		 System.out.println("�ǵݹ鷽����");
 		 tree.nonRecursiveMidOrder(node);*/
 		 //TreeNode nodeList=null;
 		 //System.out.println(tree.TreeDepth(node));;
 		//System.out.print(tree.IsBalanced_Solution(node));
 //		 tree.nonRecursiveMidOrder(nodeList);
	 }

}

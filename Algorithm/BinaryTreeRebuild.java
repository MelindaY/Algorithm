package Algorithm;
/**
 * Definition for binary tree*/
/* ��ĿҪ����֪��������������������������˳����øö�����
 * Tips��     ���õݹ�˼�룺���������һ���ڵ���Ǹ��ڵ㣬��Ӧ����������У������ҵ���������
 * ������       �����������->��->��
 *        �����������->��->��
 * �ѵ㣺       ���˳����һ�����飬��ô�ҵ������е�ĳ��ֵ��ֻ�ܱ�����
 * ��᣺       ���������������Ҽ�ֱ��̫����ݹ��ˣ�������
 *        �ݹ飺ÿһ��ִֻ��һ�Σ�����ǵݹ鵽��һ�εݹ飬������û��û�˵ĵݹ顣���仰˵��
 *            ÿһ���ǽ������ڵ㣬Ȼ��ֵ����������������һֱ������ߵ�Ҷ�ӽڵ�
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

package Algorithm;
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

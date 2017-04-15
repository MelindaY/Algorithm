package Algorithm;
class TreeBuild{
	private TreeNode node1;
	public void bulidTree(TreeNode node,int k){
		if(k>0){
			this.node1=new TreeNode(2);
			System.out.print(this.node1.val+" ");
			bulidTree(this.node1.left,k-1);
			bulidTree(this.node1.right,k-1);
			}
		else return;
		}
	public TreeNode getTree(){
		return node1;
	}
}
	
public class SubTree {
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
	
	public static void main(String args[]){
		TreeNode node1=new TreeNode(2);
		node1.left=new TreeNode(5);
		node1.right=new TreeNode(6);
		TreeNode node2=new TreeNode(2);
		node2.left=new TreeNode(5);
		node2.right=new TreeNode(6);
		System.out.println(HasSubtree(node1,node2));
    	
    	
    	
    }

}

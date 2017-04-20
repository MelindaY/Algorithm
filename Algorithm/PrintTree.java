package Algorithm;
import Algorithm.BinaryTreeRebuild;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;


public class PrintTree {
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

	public static void main(String args[]){
		TreeNode node1=new TreeNode(2);
		node1.left=new TreeNode(5);
		node1.right=new TreeNode(6);
		ArrayList<Integer> list=new ArrayList<Integer>();
		list=PrintFromTopToBottom(null);
		int i=0;
		while(i<list.size()){
			System.out.println(list.get(i));
			i++;
		}
	}
}

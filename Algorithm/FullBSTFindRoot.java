package Algorithm;
import java.util.*;
/*
 *题目要求：对于深度为k的满二叉排序树，节点数为2^k-1,值为1-2^k-1,已知任意三个节点的值和深度
 *        求最小子树的根节点。
 *分析：满二叉树：就是每个根都有两个节点（完全二叉树：满二叉树去掉一部分右子树）
 *    满二叉排序树：左子树< 根节点<右子树
 *    二分查找法：如果对于二分点m满足在任意两点中间（(i-m)*(j-m)<=0)）或者本身就等于该节点
 *             就返回。否则，递归。注意递归时返回值的写的方式。 */
public class FullBSTFindRoot {
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
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int i=s.nextInt();
		int j=s.nextInt();
		int k=s.nextInt();
		int right=s.nextInt();
		FullBSTFindRoot bst=new FullBSTFindRoot();
		System.out.println(bst.findRoot(i,j,k,1,(2 <<right)-1));
		
	}


}

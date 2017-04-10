package Algorithm;
import java.util.*;
/*
 *��ĿҪ�󣺶������Ϊk�����������������ڵ���Ϊ2^k-1,ֵΪ1-2^k-1,��֪���������ڵ��ֵ�����
 *        ����С�����ĸ��ڵ㡣
 *��������������������ÿ�������������ڵ㣨��ȫ����������������ȥ��һ������������
 *    ��������������������< ���ڵ�<������
 *    ���ֲ��ҷ���������ڶ��ֵ�m���������������м䣨(i-m)*(j-m)<=0)�����߱���͵��ڸýڵ�
 *             �ͷ��ء����򣬵ݹ顣ע��ݹ�ʱ����ֵ��д�ķ�ʽ�� */
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

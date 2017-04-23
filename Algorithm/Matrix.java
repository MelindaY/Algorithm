package Algorithm;

import java.util.ArrayList;

public class Matrix {

	/**
	 * ��ĿҪ�� ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
	 *         ���磬����������¾��� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	 *         �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 * ˼·��         �����ĸ���top,bottom,left��right��
	 *         ÿ�δ�ӡһ������ֱ��left>right&&top>bottom
	 *         ���磺
	 *         1  2  3  4
	 *         5  6  7  8
	 *         9 10 11  12
	 *         top=0, left=0, 
	 *         right=row-1=matrix[0].length-1
	 *         bottom=column-1=matrix.length-1
	 * ���⣺         ���˼·�ǽ�����˵�
	 *         ֻ��һ����¼��ʱ�򣬼�¼ֻ��һ�顣�����Ҫ�ж�         
	 * @author wzq
	 *
	 */
	public  ArrayList<Integer> printMatrix(int [][] matrix) {
		ArrayList<Integer> list=new ArrayList<Integer>();
		if(matrix==null)
			return null;
       int column=matrix.length;
       int row=matrix[0].length;
       int top=0,bottom=column-1,left=0,right=row-1;
       for(;(left<=right)&&(top<=bottom);){
    	   //left-->right
    	   for(int i=left;i<=right;i++)
    		   list.add(matrix[top][i]);
    	   //top-->bottom
    	   for(int i=top+1;i<=bottom;i++)//i��top+1�������ظ�
    		   list.add(matrix[i][right]);
    	   //right--->left
    	   if (top != bottom)//��Ҫ�Ƕ�ά���鲻��һ�������ε�ʱ��һ������ֻ��һ��
    	   for(int i=right-1;i>=left;i--)
    		   list.add(matrix[bottom][i]);
    	   //bottom-->top
    	   if (left != right)
    	   for(int i=bottom-1;i>=top+1;i--)
    		   list.add(matrix[i][left]);
    	   right--;
    	   left++;
    	   top++;
    	   bottom--;
       }
       return list;
	}
	
	/*
	 * ��Ŀ�����������Ѱ��ĳ���ض������Ƿ���ڡ������ң����ϵ��£�����������˳����
	 * ˼�룺�����½ǻ������Ͻǿ�ʼ�����Ʊ�����һ��һС�����������������������С������Ĳ�ѯ������ǹ̶���
	 * �ص㣺��Ҫ���Ƕ�����Ϊ�յĴ���
	 * */
	 public boolean Find(int target, int [][] array) {
		 //��ά���飺a[i][j]�ĳ��ȣ�a[i].length(j�ĳ���)��a.length(i�ĳ���)
	        /*int i=0,j=array[i].length-1;
	        if(j<0)
	            return false;
	        if((array.length-1)<0)
	            return false;
	        while(target!=array[i][j]&&(i<array.length-1)&&(j>0)){
	            if(target>array[i][j]){
	                i++;
	            }
	            else if(target<array[i][j]){
	                j--;
	            }
	        }
	        if(target==array[i][j])
	        	return true;
	        else
	        	return false;*/	   
		 int i=0,j=array[i].length-1;
		 while((i<=array.length-1)&&(j>=0)){
			 if(target==array[i][j])
		        	return true;
			 else if(target>array[i][j]){
	                i++;
	            }
	         else {
	                j--;
	            }
		 }
	     return false;
	    }
	
	public static void main(String[] args){

		/*����˳���ӡ����*/
       int[][] a = new int[3][5];
       int t=1; //������
       for(int i = 0; i < 3; i++){
           for(int j = 0; j < 5; j++){
               a[i][j] = t++;
               System.out.print(a[i][j]);
           }
           System.out.println();
       }
		 ArrayList<Integer>list=new ArrayList<Integer>();
		 Matrix matrix=new Matrix();
		 list= matrix.printMatrix(a);
		 System.out.print("The result is:");
		 for(int k=0;k<list.size();k++){
			 System.out.print(list.get(k));
			 if((k+1)%5==0)
				 System.out.println();
		 }
		 
		 int arr[][]={{1,2,3},{4,5,6}};
		 System.out.println(matrix.Find(4,arr));
	 }
}

package Algorithm;

import java.util.ArrayList;

public class Matrix {

	/**
	 * 题目要求： 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
	 *         例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
	 *         则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
	 * 思路：         设置四个点top,bottom,left和right。
	 *         每次打印一个方向直到left>right&&top>bottom
	 *         例如：
	 *         1  2  3  4
	 *         5  6  7  8
	 *         9 10 11  12
	 *         top=0, left=0, 
	 *         right=row-1=matrix[0].length-1
	 *         bottom=column-1=matrix.length-1
	 * 问题：         这个思路是借鉴别人的
	 *         只有一条记录的时候，记录只走一遍。因此需要判断         
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
    	   for(int i=top+1;i<=bottom;i++)//i从top+1，避免重复
    		   list.add(matrix[i][right]);
    	   //right--->left
    	   if (top != bottom)//主要是二维数组不是一个正方形的时候，一条数据只走一遍
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
	 * 题目：有序矩阵中寻找某个特定的数是否存在。从左到右，从上到下，矩阵中数字顺序变大
	 * 思想：从左下角或者右上角开始。控制变量，一大一小。这样，如果比这个数大或者小，数组的查询方向就是固定的
	 * 重点：不要忘记对数组为空的处理！
	 * */
	 public boolean Find(int target, int [][] array) {
		 //二维数组：a[i][j]的长度：a[i].length(j的长度)和a.length(i的长度)
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

		/*测试顺序打印矩阵*/
       int[][] a = new int[3][5];
       int t=1; //计数器
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

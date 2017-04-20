package Algorithm;

import java.util.ArrayList;

public class ClockwiseMatrixPrint {
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
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
    	   for(int i=top+1;i<=bottom;i++)
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
 public static void main(String[] args){
		 /*int[][] matrix=new int[5][5];
		 for(int i=0;i<5;i++){
			 for(int j=0;i<5;j++)
				matrix[i][j]=0;
		 }*/

        int[][] a = new int[3][5];
        int t=1;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 5; j++){
                a[i][j] = t++;
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
		 ArrayList<Integer>list=new ArrayList<Integer>();
		 list= printMatrix(a);
		 System.out.print("The result is:");
		 for(int k=0;k<list.size();k++){
			 System.out.print(list.get(k));
			 if((k+1)%5==0)
				 System.out.println();
		 }
	 }
    
}

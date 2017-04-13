package Algorithm;
/*
 * 题目：有序矩阵中寻找某个特定的数是否存在。从左到右，从上到下，矩阵中数字顺序变大
 * 思想：从左下角或者右上角开始。控制变量，一大一小。这样，如果比这个数大或者小，数组的查询方向就是固定的
 * 重点：不要忘记对数组为空的处理！
 * */
public class OrderMatrixFindElement {
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
	 public static void main(String args[]){
		 int arr[][]={{1,2,3},{4,5,6}};
		 OrderMatrixFindElement om=new OrderMatrixFindElement();
		 System.out.println(om.Find(4,arr));
		
	 }
}

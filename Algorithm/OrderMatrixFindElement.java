package Algorithm;
/*
 * ��Ŀ�����������Ѱ��ĳ���ض������Ƿ���ڡ������ң����ϵ��£�����������˳����
 * ˼�룺�����½ǻ������Ͻǿ�ʼ�����Ʊ�����һ��һС�����������������������С������Ĳ�ѯ������ǹ̶���
 * �ص㣺��Ҫ���Ƕ�����Ϊ�յĴ���
 * */
public class OrderMatrixFindElement {
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
	 public static void main(String args[]){
		 int arr[][]={{1,2,3},{4,5,6}};
		 OrderMatrixFindElement om=new OrderMatrixFindElement();
		 System.out.println(om.Find(4,arr));
		
	 }
}

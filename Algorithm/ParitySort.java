package Algorithm;
/*
 * 题目：     输入：一个数组 输出：前面是奇数，后面是偶数且奇数与奇数之间顺序不变
 * 思路：     用另外一个数组来存储。遍历两次，一次为奇数，一次为偶数
 * 问题：      这个题目本身不难，但是我对数组的值传递和引用传递有点理解不透彻
 * *************************************************************
 * Others：没有看到特别好的解决方案。不然就是换来换去啊
 * */
public class ParitySort {
	public static void reOrderArray(int [] array) {
		if(array==null)
			throw new RuntimeException("empty array!");
        int[] t=new int[array.length];
        // int[] t=a; 这样子就会把t指向a；然后你说后面还能玩吗，t一变化，a也变化
        int position=0;
        for(int i=0;i<array.length;i++)
        	if(array[i]%2!=0){
        	    t[position++]=array[i];    
        	}
        for(int i=0;i<array.length;i++)
        	if(array[i]%2==0)
        	{
        		t[position++]=array[i];
        		/*if(position!=array.length)
        			position++;*/
        	}
        //a=t; 这时候a指向t，但是这是形参啊宝贝，等程序调用完a也不指向t啦，回去指向原先的位置了
        for(int i=0;i<array.length;i++)
        	array[i]=t[i];

    }
	 public static void main(String args[]){
		
		 int[] array={0,2,-3,1,99,4,-5};
		 array[222]=0;
		 reOrderArray(array);
		for(int i:array)
		 System.out.println(i);
		
	 }

}

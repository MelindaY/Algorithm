package Algorithm;

public class Array {
	
	/*
	 * 题目：     输入：一个数组 输出：前面是奇数，后面是偶数且奇数与奇数之间顺序不变
	 * 思路：     用另外一个数组来存储。遍历两次，一次为奇数，一次为偶数
	 * 问题：      这个题目本身不难，但是我对数组的值传递和引用传递有点理解不透彻
	 * *************************************************************
	 * Others：没有看到特别好的解决方案。不然就是换来换去啊
	 * */
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
		
		/*题目要求：  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
		 *        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
		 *        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
		 *  NOTE：  给出的所有元素都大于0，若数组大小为0，请返回0。
		 *   解法：  因为是两个有序的子列，因此用二分查找。取中间点，如果在前面那个子列，就一定比任意元素小
		 *        如果在后面，就一定比任意元素大
		 *        在哪个子列，就将该子列的指针指向mid
		 *遍历结束：  start点的数据不再大于end点，返回mid
		 *   特例：  中间节点等于左边等于右边，这种情况就需要逐个遍历  */
    public static int minNumberInRotateArray(int [] array) {
		/*int rotate[] = array;
		int position=0;
		for(int i=0;i<array.length;i++,position=i)
			if(i!=array.length-1)
				if(array[i]>array[i+1])
					break;
		
		int j=position;
		if(position==array.length)
			return array[0];
		for(int i=position+1;i<array.length;i++){
			int t=i-position-1;
			rotate[i-position-1]=array[i];
		}
		for(int i=0;i<=position;i++){
			rotate[i+position]=array[i];
		}
		return rotate[0];*/
		if(array==null)
			System.exit(0);
		int start=0;
		int end=array.length-1;
		int mid=(end-start)/2;
		while(start+1<end){
			if(array[start]==array[end]&&(array[mid]==array[end])
					&&(array[start]==array[mid]))
				return minNumberInPlaceArray(array);
			if(array[mid]>=array[start]){
				start=mid;
			}
			else if(array[mid]<=array[end]){
				end=mid;
			}
			mid=(end+start)/2;
		}
		return array[end];
		}
    public static int minNumberInPlaceArray(int [] array) {
		int rotate[] = array;
		int position=0;
		for(int i=0;i<array.length;i++,position=i)
			if(i!=array.length-1)
				if(array[i]>array[i+1])
					break;
		
		int j=position;
		if(position==array.length)
			return array[0];
		for(int i=position+1;i<array.length;i++){
			int t=i-position-1;
			rotate[i-position-1]=array[i];
		}
		for(int i=0;i<=position;i++){
			rotate[i+position]=array[i];
		}
		return rotate[0];
		}
		

}

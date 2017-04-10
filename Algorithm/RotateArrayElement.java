package Algorithm;
import java.util.ArrayList;
    
/*题目要求：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
                        输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
                        例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
          NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     解法：         因为是两个有序的子列，因此用二分查找。取中间点，如果在前面那个子列，就一定比任意元素小
                         如果在后面，就一定比任意元素大
                         在哪个子列，就将该子列的指针指向mid
                         遍历结束：start点的数据不再大于end点，返回mid
                         特例：中间节点等于左边等于右边，这种情况就需要逐个遍历  */
public class RotateArrayElement {
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
	public static void main(String[] args){
		int [] array=null;
		System.out.println(minNumberInRotateArray(array));
	}
}

package Algorithm;
import java.util.ArrayList;
    
/*��ĿҪ�󣺰�һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
                        ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
                        ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
          NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
     �ⷨ��         ��Ϊ��������������У�����ö��ֲ��ҡ�ȡ�м�㣬�����ǰ���Ǹ����У���һ��������Ԫ��С
                         ����ں��棬��һ��������Ԫ�ش�
                         ���ĸ����У��ͽ������е�ָ��ָ��mid
                         ����������start������ݲ��ٴ���end�㣬����mid
                         �������м�ڵ������ߵ����ұߣ������������Ҫ�������  */
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

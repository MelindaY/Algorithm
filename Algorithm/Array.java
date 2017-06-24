package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Array {
	
	int t=-1;
	int count=-1;
	int s=-1;
	
	
	

	
	public static void print(Object O){
		System.out.println(O);
	}
	
	
	/**
	 * 快排
	 * @param array
	 */
	public void QuickSort(int[] arr,int front,int rear){
		if(front<rear){
			int index=Partition(arr,front,rear);
			QuickSort(arr,front,index-1);
			QuickSort(arr,index+1,rear);
		}
	}
	public int Partition(int[] arr,int front,int rear){
		int x=arr[rear];
		int i=front-1;
		for(int j=front;j<=rear-1;j++){
			if(arr[j]<x){
				i++;
				swap(arr,i,j);
			}
		}
		swap(arr,i+1,rear);
		return i+1;
	}
	public void swap(int[]arr,int i,int j){
		if(i==j)
			return;
		arr[i]^=arr[j];
		arr[j]^=arr[i];
		arr[i]^=arr[j];
	}
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
    /**
     * Q:        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *           例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     *           由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
    	if(array==null)
    		return 0;
        Arrays.sort(array);
        int[] result=new int[array[array.length-1]+1];
        int num=0;
        /*for(int i:result)
        	result[i]=0;*/
        for(int i:array)
        	result[i]++;
        for(int i=0;i<result.length;i++){
        	if(result[i]>array.length/2)
        		num=i;
        }
        return num;
    }
    
   /**
    *  输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
    * @param args
    */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
    	ArrayList<Integer> minK=new ArrayList<Integer>();
        if(input==null||k<=0||k>input.length)
        	return minK;
        int i=0;
        int j=input.length-1;
        int index=subSort(input,i,j);
        while(index+1!=k){
        	if(index+1>k){
        		j=index-1;
        		index=subSort(input,i,j);
        	}

        	if(index+1<k){
        		i=index+1;
        		index=subSort(input,i,j);
        	}
        		
        }
        for(i=0;i<k;i++){
        	minK.add(input[i]);
        }
        return minK;
    }
    
    public int subSort(int[]input,int i,int j){
    	if(i==j||i>j)
    		return i;
    	int base=0;
    	int left=i;
    	i=i+1;
    	base=input[i-1];
        while(i<j){
        	while(base<=input[j]&&j>i)
        		j--;
        	while(base>input[i]&&i<j)
        		i++;
        	if(i<j){
        		input[i]^=input[j];
            	input[j]^=input[i];
            	input[i]^=input[j];
        	}	
        }
         //if(i!=j){
        	input[left]^=input[i];
            input[i]^=input[left];
            input[left]^=input[i];
        //}
        
        return j;
    }
    
    /**
     * 问题：          今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,
     *          当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
     *          例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
     *          你会不会被他忽悠住？(子向量的长度至少是1)
     * 求解：           动态规划
     *          对于每个子序列，如果为负数，则遇到正数就舍去。比较当前子序列之和与历史最大
     *          例如对于序列：{1,-2,3,10,-4,7,2,-5}
     *          1. sum=1,  GreatestSum=1
     *          2. sum=-1, GreatestSum=1
     *          3. sum=3,  GreatestSum=3 //舍去前两个子序列，因为负数加正数比正数本身小
     *          4. sum=13, GreatestSum=13
     *          ......
     * 
     */
    //W1: 复杂度：O(n)
    public int FindGreatestSumOfSubArray(int[] array) {
    	if(array.length==0)
    		return 0;
    	int sum=0;//当前子序列之和
    	int GreatestSum=array[0];//历史最大子序列
        for(int i=0;i<array.length;i++){
        	
        	if(array[i]>sum&&sum<0){//如果前一个子序列是负数，则与正数相加会使其变小，因此舍去
        		sum=array[i];
        	}
        	else
        		sum+=array[i];
        	if(GreatestSum<sum)
        		GreatestSum=sum;
        }
       
        return GreatestSum;
    }
    
    //W2:复杂度：O(nlgn) 分冶算法
    public int FindGreatestSumOfSubArray2(int[] array) {
    	if(array.length==0)
    		return 0;
    	int[] result=nonCrossGreatestSumOfSubArray(array,0,array.length-1);
    	return result[2];
    	
    }
    public int[] nonCrossGreatestSumOfSubArray(int[]array, int begin,int end){
    	if(begin==end)
    		return new int[]{begin,end,array[begin]};
    	int mid=(begin+end)/2;
    	int[] resultLeft=nonCrossGreatestSumOfSubArray(array,begin,mid);
    	int[] resultRight=nonCrossGreatestSumOfSubArray(array,mid+1,end);
    	int[] resultCross=crossGreatestSumOfSubArray(array,begin,mid,end);
    	if((resultLeft[2]>=resultRight[2])&&(resultLeft[2]>=resultCross[2]))
    		return resultLeft;
    	else if((resultRight[2]>resultLeft[2])&&(resultRight[2]>=resultCross[2]))
    		return resultRight;
    	else 
    		return resultCross;
    }
    
    public int[] crossGreatestSumOfSubArray(int[]array, int begin,int mid,int end){
    	int GreatestSum=(int)Double.NEGATIVE_INFINITY;
    	int sum=0;
    	int positionLeft=0;
    	int positionRight=0;
    	for(int i=mid;i>=0;i--){
    		sum+=array[i];
    		if(GreatestSum<sum){
    			GreatestSum=sum;
    			positionLeft=i;
    		}
    	}
    	for(int i=mid+1;i<=end;i++){
    		sum+=array[i];
    		if(GreatestSum<sum){
    			GreatestSum=sum;
    			positionRight=i;
    		}
    	}
    	int[]result=new int[3];
    	result[0]=positionLeft;
    	result[1]=positionRight;
    	result[2]=GreatestSum;
    	return result;
    }
    
    /**
     * 问题：      求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
                                   为此他特别数了一下1~13中包含1的数字有1、10、11、12、13
                                   因此共出现6次,但是对于后面问题他就没辙了。
              ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
              
     */
    public int NumberOf1Between1AndN_Solution(int n) {
    	
    	int number=0;
    	int upperNum=0; //遍历到i位后，i之前的数字 比如a1a2aia3 upperNum=a1a2
    	int lowerNum=0; //遍历i位后，i之后的数字
    	int divideNum=0; //用以得到上述两个变量
    	int position=0;  //遍历的i是哪一位
    	String stringN=String.valueOf(n);
    	char[] charN=stringN.toCharArray();
    	if(charN.length==0)
    		return 0;
    	for(int i=0;i<charN.length;i++){
    		divideNum=(int)Math.pow(10, charN.length-i);
    		position=divideNum/10;
    		if(i==0){
    			lowerNum=n%(int)(Math.pow(10, charN.length-1)*(charN[i]-'0'));
    			upperNum=0;
    		}
    		else{
    			upperNum=n/divideNum; 
    			String subString=stringN.substring(0, i);
        		lowerNum=n%(Integer.parseInt(subString)*divideNum);
    		}
    		if((int)charN[i]-'0'==0){
    			number+=upperNum*position;
    		}
    		else if((int)charN[i]-'0'==1){
    			if(upperNum-1>0)
    				upperNum--;
    			number+=(upperNum)*position+lowerNum+1;	
    		}
    		else if((int)charN[i]-'0'>1){
    			number+=(upperNum+1)*position;	
    		}
    	}
    	return number;
    }
    
 public int SimplifiedNumberOf1Between1AndN_Solution(int n) {
    	
    	int number=0;
    	int upperNum=0; //遍历到i位后，i之前的数字 比如a1a2aia3 upperNum=a1a2
    	int lowerNum=0; //遍历i位后，i之后的数字
    	int divideNum=1; //用以得到上述两个变量
    	int currentNum=0;
    	while(n/divideNum!=0){
    		lowerNum=n-(n/divideNum)*divideNum;
    		upperNum=n/(divideNum*10);
    		currentNum=(n/divideNum)%10;
    		switch(currentNum){
    		case 0:
    			number+=upperNum*divideNum;
    			break;
    		case 1:
    			number+=(upperNum)*divideNum+lowerNum+1;
    			break;
    		default:
    			number+=(upperNum+1)*divideNum;	
    		}
    		divideNum*=10;
    	}
    	return number;
    }
    /*
     * 问题：  输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     *      例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
     * 思路：  对于任一数字，n，m，如果nm>mn,则n在前。利用Collections.sort()
     */
 public String PrintMinNumber(int [] numbers) {
	 if(numbers.length==0)
		 return null;
	 ArrayList<String>numbersArray=new ArrayList<String>();
	 for(int i:numbers)
		 numbersArray.add(String.valueOf(i));//避免出现nm越界
	 Collections.sort(numbersArray, new Comparator<String>() {
         @Override
         public int compare(String s, String t1) {
        	 String st1=s+t1;
        	 String t1s=t1+s;
             return st1.compareTo(t1s);
         }
     });
	 StringBuilder resultString=new StringBuilder();
	 for(String i:numbersArray)
		 resultString.append(i);
	 return resultString.toString();
 }
 
 /**
  * 题目：    把只包含因子2、3和5的数称作丑数（Ugly Number）。
  *       例如6、8都是丑数，但14不是，因为它包含因子7。 
  *       习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
  * @param args
  */
 public int GetUglyNumber_Solution(int index) {
	 if(index<0)
		 return 0;
	 if(index==0)
		 return 0;
	 int[] uglyArray=new int[index];
	 int t2 = 0,t3=0,t5=0;
	 int min=0;
	 uglyArray[0]=1;
	 for(int i=1;i<index;i++){
		 uglyArray[i]=getMin(uglyArray[t2]*2,uglyArray[t3]*3,uglyArray[t5]*5);
		 if(uglyArray[i]==uglyArray[t2]*2)
			 t2++;
		 if(uglyArray[i]==uglyArray[t3]*3)
			 t3++;
		 if(uglyArray[i]==uglyArray[t5]*5)
			 t5++;
	 }
     return uglyArray[index-1];
 }
 
 public int getMin(int a,int b,int c){
	 if(a<=b&&a<=c)
		 return a;
	 else if(b<=c&&b<=a)
		 return b;
	 else
		 return c;
	 
 }
 
 /**
  * 问题描述：         在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
  *            输入一个数组,求出这个数组中的逆序对的总数P。
  *            并将P对1000000007取模的结果输出。 即输出P%1000000007 
  *            输入描述:
                                                               题目保证输入的数组中没有的相同的数字
                                     数据范围：
	                                                    对于%50的数据,size<=10^4
	                                                    对于%75的数据,size<=10^5
	                                                    对于%100的数据,size<=2*10^5
	                           输入例子:
                         1,2,3,4,5,6,7,0
                                     输出例子:
                         7
  * @param args
  */
 public int Merge(int[]arr, int front,int rear,int mid) {
	 count=0;
     int frontArr[]=new int[mid-front+2];//原本写的是mid+2
     int rearArr[]=new int[rear-mid+1];
     for(int i=front;i<=mid;i++)
    	 frontArr[i-front]=arr[i];
     for(int i=mid+1;i<=rear;i++)
    	 rearArr[i-mid-1]=arr[i];
     frontArr[mid-front+1]=(int)Float.NEGATIVE_INFINITY;
     rearArr[rear-mid]=(int)Float.NEGATIVE_INFINITY;
     int i=0;
     int j=0;
     for(int k=front;k<=rear;k++){
    	 if(frontArr[i]>rearArr[j]){
    		 arr[k]=frontArr[i];
    		 i++;
    		 count=rear-mid-j+count;
    		 if(count>=1000000007)
    			 count=count%1000000007;
    	 }
    	 else{
    		 arr[k]=rearArr[j];
    		 j++;
    	 }
     }
     return count;
     
 }
 public int MergeSort(int[]arr,int begin,int end){
	 if(end<=begin||end<0||begin<0)
		 return 0;
	 int mid=(end+begin)/2;//为什么是加呢
	 MergeSort(arr,begin,mid);
	 MergeSort(arr,mid+1,end);
	 if(count>=1000000007)
		 count=count%1000000007;
	 count+=Merge(arr,begin,end,mid);
	 return count;
 
 }
 /*
  * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
  * num1,num2分别为长度为1的数组。传出参数.将num1[0],num2[0]设置为返回结果
  */
 public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	 if(array.length==0)
    	 return;
     Arrays.sort(array);
     //num1[0]=array[0];
     /*for(int i=1;i<array.length;i++){
    	 num1[0]^=array[i];
    	 if(num1[0]!=0&&i==1)
    		num2[0]=array[0]; 
    	 if(num1[0]!=0&&((i+1)/2==0))
    		 num2[0]=array[i];
     }
     num1[0]^=num2[0]; */
     for(int i:array)
    	 num1[0]^=i;
     for(int i=0;i<array.length;i++){
    	 num1[0]^=array[i];
    	 if(num1[0]==0&&i!=0){
    		 num2[0]=array[i];
    		 break;
    	 }
     }
     for(int i:array)
    	 num1[0]^=i;
     num1[0]^=num2[0];
     
 }
 /*
  * 统计一个数字在排序数组中出现的次数。
  */
 public int GetNumberOfK(int [] array , int k) {
     if(array==null)
    	 return 0;
     int count=0;
     for(int i=0;i<array.length;i++){
    	 if(k==array[i])
    		 count++;
     }
     return count;
 }
 
 public int GetNumberOfK2(int [] array , int k) {
     if(array==null)
    	 return 0;
     int last=dichotomyLast(array , 0,array.length-1,k);
     int first=dichotomyFirst(array , 0,array.length-1,k);
     if(last!=-1&&first!=-1)
         count=last-first+1;
     return count;
 }
 
 public int dichotomyFirst(int [] array , int begin,int end,int k){
	 //v1: 不知道如何定两点位置: 解决方案：一个函数查找头 一个查找尾
	 if(begin>end)
		 return -1;
	 int mid=(end+begin)/2;
	 //错误出处
	 if((array[mid]!=k&&mid==begin)||(array[mid]!=k&&mid==end))
		 return -1;
	 if(array[mid]==k){
		 if(mid==begin||array[mid-1]<k){
			 s=mid;
			 return s; 
		 }
	 }
		 
	 if(array[mid]<k)
	     dichotomyFirst(array,mid+1,end,k);
		 
	 else 
		 dichotomyFirst(array,begin,mid,k);
		 end=mid;
	 return s;
 }
 
 public int dichotomyLast(int [] array , int begin,int end,int k){
	 //错误：没有考虑在原有数中不存在的现象
	 if(begin>end)//delete begin==end
		 return -1;
	 int mid=(end+begin)/2;
	 if((array[mid]!=k&&mid==begin)||(array[mid]!=k&&mid==end))
		 return -1;
	 if(array[mid]==k){
		 if(mid==end||array[mid+1]>k){
			 t=mid;
			 return t; 
		 }
	 }	 
	 if(array[mid]>k)
	     dichotomyLast(array,begin,mid,k);
	 else 
	     dichotomyLast(array,mid+1,end,k);
	 return t;
 }
 
 /**
  * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，
  * 如果有多对数字的和等于S，输出两个数的乘积最小的。 
  * @param array
  * @param sum
  * @return
  */
 public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
     ArrayList<Integer>result=new  ArrayList<Integer>();
     if(array.length<2)
    	 return result;
     int i=0,j=array.length-1;
     while((i<=array.length-1)&&(j>=0)){
    	 if(array[i]+array[j]==sum){
    		 result.add(array[i]);
    		 result.add(array[j]);
    		 break;
    	 }
    	 else if (array[i]+array[j]>sum)
    		 j--;
    	 else i++;
     }
     return result;
 }
 
 
 /**
  * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
  * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,
  * 他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快
  * 的找出所有和为S的连续正数序列? Good Luck! 
  * @param args
  */
 
 public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
	 ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
     if(sum<3)
    	 return result;
     int d;
     for(int k=(int)Math.sqrt(sum*2);k>0;k--){
    	 ArrayList<Integer>subResult=new  ArrayList<Integer>();
    	 if(sum*2%k==0){
    		 d=sum*2/k;
    		 if((d%2==0&&k%2!=0)||(d%2!=0&&k%2==0)){
    			 int a=(Math.abs(k-d)+1)/2;
    			 for(;a<=(k+d-1)/2;a++)
    				 subResult.add(a);
    		 }
    		 if(!subResult.isEmpty()&&subResult.size()>1)
    		     result.add(subResult);
    	 }
     }
     return result;
 }
 /*
  * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
  * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
  * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
  * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
  * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
  * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何。
  * 为了方便起见,你可以认为大小王是0。
  */
 public boolean isContinuous(int [] numbers) {
	 Arrays.sort(numbers);
	 int zeroNum=0;
	 int preNum=numbers[0];
	 int gapNum=0;
	 int i=0;
	 for(i=0;i<numbers.length;i++)
		 if(numbers[i]==0){
			 zeroNum++;
			 preNum=numbers[i+1];
		 }
			
	 for(i=zeroNum+1;i<numbers.length;i++){
			 if(preNum==numbers[i])
				 return false;
			 gapNum+=numbers[i]-preNum-1;
			 preNum=numbers[i];
	 }
	if(gapNum==zeroNum&&zeroNum<5)
		return true;
	return false; 
 }
 
 /**
  * 圆圈中最后剩下的数字
  */
 
 public int LastRemaining_Solution(int n, int m) {
     if(n<=0||m<0)
    	 return 0;
     if(n==1)
    	 return 0;
     int result=0;
     for(int i=2;i<n;i++)
    	 result=(result+m)%i;
     return result;
 }
 /**
  * 求1+2+3+...+n，
  * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
  * @param n
  * @return
  */
 public int Sum_Solution(int n) {
	 int sum=n;
	 boolean ans=(n>0)&&((sum+=Sum_Solution(n-1))>0);
	 return sum;
    }
 /**
  * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0 
  * @param num1
  * @param num2
  * @return
  * 比如：+2147483647,1a33---->2147483647,0
  */
 public int Add(int num1,int num2) {
	 int a=num1;
	 int b=num2;
     //print(Integer.toBinaryString(b));
     while((num1&num2)!=0){
    	 num1=a;
    	 num2=b;
    	 a=num1^num2;
    	 b=num1&num2;
    	 b<<=1;
     }
     return a|b;
 }
 
 /**
  * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
  * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
  * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
  * @param numbers  an array of integers
  * @param length  the length of array numbers
  * @param duplication  (Output) the duplicated number in the array number,
  *                     length of duplication array is 1,
  *                     so using duplication[0] = ? in implementation;
  *                     Here duplication like pointer in C/C++, 
  *                     duplication[0] equal *duplication in C/C++
  *                     这里要特别注意~返回任意重复的一个，赋值duplication[0]                 
  * @return             true if the input is valid, 
  *                     and there are some duplications in the array number
                       otherwise false
  */
 public boolean duplicate(int numbers[],int length,int [] duplication) {
	if(length==0)
		 return false;
    Map<Integer,Integer>numMap=new HashMap<Integer,Integer>();
    for(int i:numbers){
    	if(numMap.containsKey(i)){
    		duplication[0]=i;
    		return true;
    	}
    	else{
    		numMap.put(i, 1);
    	}	
    }
    return false;
 } 
 
 public boolean duplicate2(int numbers[],int length,int [] duplication) {
		if(length==0)
			 return false;
	    for(int i=0;i<length;i++){
	    	int index=numbers[i];
	    	if(index>length)
	    		index=length-index;
	    	if(numbers[index]>length){
	    		duplication[0]=index;
	    		return true;
	    	}
	    	numbers[index]+=index;
	    }
	    return false;
	 } 
 
 /**
  * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
  * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
  * @param args
  */
 public int[] multiply(int[] A) {

	 if(A.length==0||A.length==1){
		 int[]B={};
		 return B;
	 }
	 int[]B=new int[A.length];
	 B[0]=1;
	 B[1]=1;
	 for(int i=1;i<A.length;i++){
		 B[i]*=A[i-1];
		 if(i+1<A.length)
			 B[i+1]=B[i];
	 }
	 int[]C=new int[A.length];
	 C[A.length-1]=1;
	 C[A.length-2]=1;
	 //C[1]=C[0];
	 for(int i=A.length-2;i>=0;i--){
		 C[i]*=A[i+1];
		 if(i-1>=0)
			 C[i-1]=C[i];
	 }
	for(int i=0;i<A.length;i++)
		B[i]*=C[i];
	 return B;
 }
 /**
  * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
  * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
  * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 
  * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，
  * 但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
  * @param matrix 
  * @param rows
  * @param cols
  * @param str
  * @return
  */
 public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
 {
	 if(matrix.length==0||str.length==0)
		 return false;
	 int[]flag=new int[matrix.length];
	 for(int i=0;i<rows;i++)
	 {
		 for(int j=0;j<cols;j++)
			 if(helper(matrix,rows,cols,0,i,j,str,flag))
				 return true;
	 }
	 return false;
 
 }
 
 public boolean helper(char[] matrix, int rows, int cols,int indexStr,int i,int j, char[] str,int[]flag){
	 int index=i*cols+j;                //j*cols+i不对：5行6列 计算index 应该是当前行*列数+当前列
	 if(j>=cols||j<0||i>=rows||i<0||str[indexStr]!=matrix[index]||flag[index]==1)
		 return false;
	 if(indexStr==str.length-1)
		 return true;
	 flag[index]=1;
	 if(helper(matrix,rows,cols,indexStr+1,i+1,j,str,flag)||
		helper(matrix,rows,cols,indexStr+1,i-1,j,str,flag)||
		helper(matrix,rows,cols,indexStr+1,i,j-1,str,flag)||
		helper(matrix,rows,cols,indexStr+1,i,j+1,str,flag))
		 return true;
	 flag[index]=0;
	 return false;
 }
 
 /**
  * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
  * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），
  * 因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
  * @param threshold
  * @param rows
  * @param cols
  * @return
  */
 
 public int movingCount(int threshold, int rows, int cols)
 {
	 if(threshold<0)
		 return 0;
	 int[]flag=new int[rows*cols];
	 return helperCount(threshold,rows,cols,0,0,flag);
 
 }
 
 private int helperCount(int threshold, int rows, int cols,int i,int j,int[]flag){
	 int index=i*cols+j;                //j*cols+i不对：5行6列 计算index 应该是当前行*列数+当前列
	 if(j>=cols||j<0||i>=rows||i<0||sumDigit(i)+sumDigit(j)>threshold||flag[index]==1)
		 return 0;
	 flag[index]=1;
	 return(helperCount(threshold,rows,cols,i+1,j,flag)+
			 helperCount(threshold,rows,cols,i-1,j,flag)+
			 helperCount(threshold,rows,cols,i,j+1,flag)+
			 helperCount(threshold,rows,cols,i,j-1,flag)+1);
 }

 private int sumDigit(int num){
	 int j=0;
	 do{
		 j+=num%10;
		 num=num/10;
	 }while(num>0);
	 return j;
 }
 
    public static void main(String[] args){
    	
    	Array arr=new Array();
    	/*int[] test=new int[10];
    	//ArrayList<Integer> minK=new ArrayList<Integer>();
    	for(int i=0;i<10;i++){
    		test[i]=(int)(Math.random()*100);
    		if(i==1||i==3||i==4||i==6||i==9)
    			test[i]=-test[i];
    	}*/
    	/*for(int i=0;i<10;i++){
    		System.out.print(test[i]+" ");
    	}*/
    	/*minK=arr.GetLeastNumbers_Solution(test, 1);
    	for(int i=0;i<minK.size();i++)
    	    System.out.println(minK.get(i));
    }*/
    	//System.out.println();
    	char[] matrix={'A','B','C','E','S','F','C','S','A','D','E','E'};
    	char[] str={'S','E','E'};
    	print(arr.movingCount(15,20,20));
    	/*arr.QuickSort(test,0,test.length-1);
    	for(int i=0;i<test.length;i++)
    		System.out.println(test[i]);*/
    	//System.out.println("Max is: "+arr.FindGreatestSumOfSubArray(test));
    	//int n=3;
    	//arr.test(n);
    	//Arrays.sort(test);
    	//ArrayList<ArrayList<Integer>>result=new  ArrayList<ArrayList<Integer>>();
    	//result=arr.FindContinuousSequence(3);
    	//arr.FindNumsAppearOnce(test,arr1,arr2);
    	
    	//System.out.println(arr.multiply(test));
    	
    	
    	
    }
    	
}



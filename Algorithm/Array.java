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
	 * ����
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
	 * ��Ŀ��     ���룺һ������ �����ǰ����������������ż��������������֮��˳�򲻱�
	 * ˼·��     ������һ���������洢���������Σ�һ��Ϊ������һ��Ϊż��
	 * ���⣺      �����Ŀ�����ѣ������Ҷ������ֵ���ݺ����ô����е���ⲻ͸��
	 * *************************************************************
	 * Others��û�п����ر�õĽ����������Ȼ���ǻ�����ȥ��
	 * */
	public static void reOrderArray(int [] array) {
			if(array==null)
				throw new RuntimeException("empty array!");
	        int[] t=new int[array.length];
	        // int[] t=a; �����Ӿͻ��tָ��a��Ȼ����˵���滹������tһ�仯��aҲ�仯
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
	        //a=t; ��ʱ��aָ��t�����������βΰ��������ȳ��������aҲ��ָ��t������ȥָ��ԭ�ȵ�λ����
	        for(int i=0;i<array.length;i++)
	        	array[i]=t[i];

	    }
		
		/*��ĿҪ��  ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
		 *        ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
		 *        ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
		 *  NOTE��  ����������Ԫ�ض�����0���������СΪ0���뷵��0��
		 *   �ⷨ��  ��Ϊ��������������У�����ö��ֲ��ҡ�ȡ�м�㣬�����ǰ���Ǹ����У���һ��������Ԫ��С
		 *        ����ں��棬��һ��������Ԫ�ش�
		 *        ���ĸ����У��ͽ������е�ָ��ָ��mid
		 *����������  start������ݲ��ٴ���end�㣬����mid
		 *   ������  �м�ڵ������ߵ����ұߣ������������Ҫ�������  */
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
     * Q:        ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
     *           ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}��
     *           ��������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
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
    *  ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,
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
     * ���⣺          ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
     *          ������ȫΪ������ʱ��,����ܺý��������,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
     *          ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
     *          ��᲻�ᱻ������ס��(�������ĳ���������1)
     * ��⣺           ��̬�滮
     *          ����ÿ�������У����Ϊ��������������������ȥ���Ƚϵ�ǰ������֮������ʷ���
     *          ����������У�{1,-2,3,10,-4,7,2,-5}
     *          1. sum=1,  GreatestSum=1
     *          2. sum=-1, GreatestSum=1
     *          3. sum=3,  GreatestSum=3 //��ȥǰ���������У���Ϊ��������������������С
     *          4. sum=13, GreatestSum=13
     *          ......
     * 
     */
    //W1: ���Ӷȣ�O(n)
    public int FindGreatestSumOfSubArray(int[] array) {
    	if(array.length==0)
    		return 0;
    	int sum=0;//��ǰ������֮��
    	int GreatestSum=array[0];//��ʷ���������
        for(int i=0;i<array.length;i++){
        	
        	if(array[i]>sum&&sum<0){//���ǰһ���������Ǹ���������������ӻ�ʹ���С�������ȥ
        		sum=array[i];
        	}
        	else
        		sum+=array[i];
        	if(GreatestSum<sum)
        		GreatestSum=sum;
        }
       
        return GreatestSum;
    }
    
    //W2:���Ӷȣ�O(nlgn) ��ұ�㷨
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
     * ���⣺      ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
                                   Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13
                                   ��˹�����6��,���Ƕ��ں�����������û���ˡ�
              ACMerϣ�����ǰ����,������������ձ黯,���Ժܿ���������Ǹ�����������1���ֵĴ�����
              
     */
    public int NumberOf1Between1AndN_Solution(int n) {
    	
    	int number=0;
    	int upperNum=0; //������iλ��i֮ǰ������ ����a1a2aia3 upperNum=a1a2
    	int lowerNum=0; //����iλ��i֮�������
    	int divideNum=0; //���Եõ�������������
    	int position=0;  //������i����һλ
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
    	int upperNum=0; //������iλ��i֮ǰ������ ����a1a2aia3 upperNum=a1a2
    	int lowerNum=0; //����iλ��i֮�������
    	int divideNum=1; //���Եõ�������������
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
     * ���⣺  ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
     *      ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323
     * ˼·��  ������һ���֣�n��m�����nm>mn,��n��ǰ������Collections.sort()
     */
 public String PrintMinNumber(int [] numbers) {
	 if(numbers.length==0)
		 return null;
	 ArrayList<String>numbersArray=new ArrayList<String>();
	 for(int i:numbers)
		 numbersArray.add(String.valueOf(i));//�������nmԽ��
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
  * ��Ŀ��    ��ֻ��������2��3��5��������������Ugly Number����
  *       ����6��8���ǳ�������14���ǣ���Ϊ����������7�� 
  *       ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
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
  * ����������         �������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�
  *            ����һ������,�����������е�����Ե�����P��
  *            ����P��1000000007ȡģ�Ľ������� �����P%1000000007 
  *            ��������:
                                                               ��Ŀ��֤�����������û�е���ͬ������
                                     ���ݷ�Χ��
	                                                    ����%50������,size<=10^4
	                                                    ����%75������,size<=10^5
	                                                    ����%100������,size<=2*10^5
	                           ��������:
                         1,2,3,4,5,6,7,0
                                     �������:
                         7
  * @param args
  */
 public int Merge(int[]arr, int front,int rear,int mid) {
	 count=0;
     int frontArr[]=new int[mid-front+2];//ԭ��д����mid+2
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
	 int mid=(end+begin)/2;//Ϊʲô�Ǽ���
	 MergeSort(arr,begin,mid);
	 MergeSort(arr,mid+1,end);
	 if(count>=1000000007)
		 count=count%1000000007;
	 count+=Merge(arr,begin,end,mid);
	 return count;
 
 }
 /*
  * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
  * num1,num2�ֱ�Ϊ����Ϊ1�����顣��������.��num1[0],num2[0]����Ϊ���ؽ��
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
  * ͳ��һ�����������������г��ֵĴ�����
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
	 //v1: ��֪����ζ�����λ��: ���������һ����������ͷ һ������β
	 if(begin>end)
		 return -1;
	 int mid=(end+begin)/2;
	 //�������
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
	 //����û�п�����ԭ�����в����ڵ�����
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
  * ����һ����������������һ������S���������в������������ǵ����ǵĺ�������S��
  * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ� 
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
  * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
  * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��û���,
  * ���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,���ܲ���Ҳ�ܿ�
  * ���ҳ����к�ΪS��������������? Good Luck! 
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
  * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
  * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
  * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,
  * ��������,������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
  * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
  * LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Ρ�
  * Ϊ�˷������,�������Ϊ��С����0��
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
  * ԲȦ�����ʣ�µ�����
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
  * ��1+2+3+...+n��
  * Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C����
  * @param n
  * @return
  */
 public int Sum_Solution(int n) {
	 int sum=n;
	 boolean ans=(n>0)&&((sum+=Sum_Solution(n-1))>0);
	 return sum;
    }
 /**
  * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0 
  * @param num1
  * @param num2
  * @return
  * ���磺+2147483647,1a33---->2147483647,0
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
  * ��һ������Ϊn����������������ֶ���0��n-1�ķ�Χ�ڡ� ������ĳЩ�������ظ��ģ�����֪���м����������ظ��ġ�
  * Ҳ��֪��ÿ�������ظ����Ρ����ҳ�����������һ���ظ������֡� 
  * ���磬������볤��Ϊ7������{2,3,1,0,2,5,3}����ô��Ӧ��������ظ�������2����3��
  * @param numbers  an array of integers
  * @param length  the length of array numbers
  * @param duplication  (Output) the duplicated number in the array number,
  *                     length of duplication array is 1,
  *                     so using duplication[0] = ? in implementation;
  *                     Here duplication like pointer in C/C++, 
  *                     duplication[0] equal *duplication in C/C++
  *                     ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]                 
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
  * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
  * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
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
  * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
  * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
  * ���һ��·�������˾����е�ĳһ�����ӣ����·�������ٽ���ø��ӡ� 
  * ���� a b c e s f c s a d e e �����а���һ���ַ���"bcced"��·����
  * ���Ǿ����в�����"abcb"·������Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
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
	 int index=i*cols+j;                //j*cols+i���ԣ�5��6�� ����index Ӧ���ǵ�ǰ��*����+��ǰ��
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
  * ������һ��m�к�n�еķ���һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
  * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� ���磬��kΪ18ʱ���������ܹ����뷽��35,37����
  * ��Ϊ3+5+3+7 = 18�����ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19�����ʸû������ܹ��ﵽ���ٸ����ӣ�
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
	 int index=i*cols+j;                //j*cols+i���ԣ�5��6�� ����index Ӧ���ǵ�ǰ��*����+��ǰ��
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



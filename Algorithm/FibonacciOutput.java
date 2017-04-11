package Algorithm;
/*
 * ��Ŀ�� 1.��Fibonacci���� 
 *      2.������̨�ף���ÿ����һ����������Q����n��̨���ж�����������
 *      
 *        ��Ϊ���ڵ�n��̨�ף�������f(n)=f(n-1)+f(n-2)
 *      3.���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 *        ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 *        
 *        ӦΪ���Ժ��ŷŻ����ŷţ�
 *        ����f(n)������2*(n-1)�ľ��μ�һ�����ŷŵ�2*1�ľ���
 *        ��2*(n-2)�ľ��μ�2���ŷŵģ���f(n)=f(n-1)+f(n-2)
 *******************************************************************
 * ��ʽ����һ�㲻���õݹ����
 *      ����һ�ֵ��� �ҷ����Ƚ�ϲ��*/
public class FibonacciOutput {
	 public static int Fibonacci(int n) {
		 /*if(n<=0)
	         return 0;
	     if(n==1)
	         return 1;
	     else
            return Fibonacci(n-1)+Fibonacci(n-2);*/
		 int firstElem=1;
		 int secElem=1;
		 int result=0;
		 if(n==1||n==2)
			 return 1;
		 while(n>2){
			 result=firstElem+secElem;
			 firstElem=secElem;
			 secElem=result;
			 n--;
		 }
		 return result;
	 }
	 public static void main(String[] args){
		 System.out.println(Fibonacci(20));
	 }
}

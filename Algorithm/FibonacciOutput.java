package Algorithm;
/*
 * ��Ŀ����Fibonacci���� ͬ������̨�ף���ÿ����һ����������Q����n��̨���ж�����������
 *      ��Ϊ���ڵ�n��̨�ף�������f(n)=f(n-1)+f(n-2)
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

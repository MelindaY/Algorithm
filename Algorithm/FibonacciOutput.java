package Algorithm;
/*
 * 题目： 1.求Fibonacci数列 
 *      2.青蛙跳台阶（即每次跳一个或两个，Q：到n级台阶有多少种跳法）
 *      
 *        因为对于第n级台阶，跳法发f(n)=f(n-1)+f(n-2)
 *      3.我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *        请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *        
 *        应为可以横着放或竖着放，
 *        多以f(n)可以是2*(n-1)的矩形加一个竖着放的2*1的矩形
 *        或2*(n-2)的矩形加2横着放的，即f(n)=f(n-1)+f(n-2)
 *******************************************************************
 * 方式：我一点不觉得递归好用
 *      还有一种迭代 我反而比较喜欢*/
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

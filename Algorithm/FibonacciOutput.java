package Algorithm;
/*
 * 题目：求Fibonacci数列 同青蛙跳台阶（即每次跳一个或两个，Q：到n级台阶有多少种跳法）
 *      因为对于第n级台阶，跳法发f(n)=f(n-1)+f(n-2)
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

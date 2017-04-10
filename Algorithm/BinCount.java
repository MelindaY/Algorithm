package Algorithm;
/*
 * 题目要求：统计某个数二进制1的个数。
 * 
 * */
public class BinCount {
	 public static int NumberOf1(int n) {
 		 /*int count=0;
 		 int re=0;
 		 if(n>>31==-1)
 		 {
 			 n=~n;
 			for(int i=0;i<32;i++){
 				re=n>>i;
 			    count+=re&1;
 			}			 
 			 return 32-count;			 
 		 }
		 for(int i=0;(1<<i)<=n;i++)
		 {
			 count+=(n>>i)&1;
			 
		 }
		 return count;*/
		 int count = 0; 
		 while(n!= 0){ 
			 count++; 
			 n = n & (n - 1);
			 } 
		 return count;
	    }
	 public static void main(String[] args){
		 System.out.println(Integer.toBinaryString(-5));
		 System.out.println(NumberOf1(-5));

	 }

}

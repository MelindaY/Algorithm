package Algorithm;
/*
 * 题目要求：     统计某个数二进制1的个数。
 * ************************************************************************
 * 自己想法：     分别求解。
 *          如果是正数，就是右移每一位和1与；
 *          如果是负数，因为是补码存储。即正数的反码加1，所以对负数求反码，可以计算0的个数。减
 *          或者用（>>>）,可以在右移的时候，给负数的最高位也补0.只不过这次得所有都遍历一下。
 **************************************************************************
 * 别人的想法：大于等于1的数字，都至少有1个"1".每次将n&(n-1),可以去掉一个1
 *          比如1101&1100=1100 1100&1011=1000
 **************************************************************************
 * 相关背景：    1. 关于补码。
 *             为什么要反码加1？主要是为了加法减法操作一样。
 *             e.g., （-8）=0-8=0000 0000
 *                           - 0000 1000
 *                           -------------
 *                             1111 1000（向0借位）
 *                       即：      10000 0000
 *                          - 00000 1000
 *             因为10000 0000=1111 1111+1
 *             所以该操作其实就是（1111 1111-被减数）+1
 *             为什么会一样？X+（-Y）=X+1111 1111-Y+1
 *             设Z=1111 1111-Y+1=-Y
 *             如果|Y|>X,得到是一个负数。即(-（-Y）-X).化简后为X-Y
 *             如果相反的话，得到的是一个正数。X-(-(-Y))
 *             参考：http://www.ruanyifeng.com/blog/2009/08/twos_complement.html
 *          2. 关于按位操作符和移位操作符。
 *             将n左移i位 n<<i
 *             将n右移i位 n>>i，最高位补0（正数），最高位补1（负数）。            
 *             取反：~ 异或：^ 与：& 或：|（二进制计算，输出还为十进制，如果不强制的话）
 *          
 * */
public class BinCount {
	 public static int NumberOf1(int n) {
 		 /* My WAY:*/
 		  int count=0;
 		 int re=0;
 		 if(n>>31==-1)
 		 {
 			 //n=~n;
 			for(int i=0;i<32;i++){
 				re=n>>>i;
 			    count+=re&1;
 			}			 
 			 return count;			 
 		 }
		 for(int i=0;(1<<i)<=n;i++)//2^i<n
		 {
			 count+=(n>>i)&1;
			 
		 }
		 return count;
		/* int count = 0; 
		 while(n!= 0){ 
			 count++; 
			 n = n & (n - 1);
			 } 
		 return count;*/
	    }
	 public static void main(String[] args){
		 System.out.println(Integer.toBinaryString(-6));//可以输出二进制
		 System.out.println(NumberOf1(-6));

	 }

}

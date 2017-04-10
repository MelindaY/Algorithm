package Algorithm;
/*
 * 题目要求：青蛙一次随便跳（1-n）级。Q：对于n级台阶，青蛙有几种跳法
 * 分析：对于第n级台阶，共有f(n)=f(n-1)+f(n-2)+...+f(1)
 *      对于第n-1级台阶，共有f(n-1)=f(n-2)+...+f(1)
 *      因此，f(n)=2*f(n-1)
 *      或者，对于每层台阶，青蛙可以选择跳或者不跳（除了最后一级台阶）
 *      因此结果为2^(n-1)*/
public class CrazyFrogJump {
	static public int JumpFloorII(int target) {
        /* 未用迭代方法求解
         * if(target<=0)
            return 0;
        return 1<<(target-1);//将1左移n-1次变为2^(n-1)*/    
		int result=1;
		if(target<=0)
            return 0;
		if(target==1)
            return 1;
		while(target>1){
			result*=2;
			target--;
		}
		return result;
		}
	 public static void main(String[] args){
		 
		 System.out.println(JumpFloorII(5));
	 }
}

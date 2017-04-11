package Algorithm;
/*
 * 题目要求：输入一个double类型数字和指数，求它的幂
 * 思考过程：主要是我已经忘了幂指数的要求和规则，怪谁呢笑脸
 *         Step1：我想用^符号，完了忘记这个根本不支持double型
 *         Step2：然后我就迭代乘啊，我知道肯定有好办法，但是我不会啊蠢哭
 *         Step3：我根本忘了还有指数是负数这回事！后来加上的
 *         Step4：很多特殊的测试用例没有想到：0^0和负数无意义。除了0的任何数的0次方都为1
 *         Step5: 看别人的代码修改自己的，更低的复杂度
 *                主要思想：如果x=y+z,那么a^x=a^(y+z)=a^y*a^x
 *                       比如x=5=101,a^5=a^100*a^1(通过与和移位实现)
 * 体会：         在写程序前，想好所有可能的特殊情况（边界点）很重要。我是想想的，奈何忘光了幂函数
 *         但其实还是说明自己欠缺发散性思维，耐心不够
 * */
public class DoublePower {
	public static double exponetDouble(double base,int n){
		
		/*v1.0 by Melinda. full of mistakes
		double result=1;
		for(int i=0;i<Math.abs(exponent);i++)
			result*=base;
		if(exponent<0)
			return 1/result;
		return result;*/
		//avoid any possible mistakes and exceptions
		int exponent=0;
		double res=1;
		double iter=base;
		if(base==0&&n==0)
			throw new RuntimeException("there is no answer");;
		if(base==0&&n<=0)
			throw new ArithmeticException("divided by 0");
		if(n<0)
			exponent=-n;
		else if(n>0)
			exponent=n;
		else return 1;
		while(exponent!=0){
			if((exponent&1)==1)
				res*=iter;
			iter*=iter;
			exponent>>=1;
		}
		return n>0?res:1/res;
					
	}
	public static void main(String[] args){

		System.out.println(exponetDouble(0,-1));

	}

}